package fr.ensibs.javafx.graphic;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import fr.ensibs.model.Sprite;
import fr.ensibs.model.SpriteConverter;
import fr.ensibs.util.graphic.Graphic;
import fr.ensibs.util.graphic.ISnapshotLayer;
import fr.ensibs.util.graphic.Snapshot;
import fr.ensibs.util.io.*;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import fr.ensibs.util.io.SnapshotConverter;

/**
 * Definitions of methods executed in reaction to user actions
 *
 * @author Pascale Launay
 */
public class ActionsHandler {
    /**
     * component that displays the list
     */
    @FXML
    private ListView<String> listView;

    /**
     * component that displays a message
     */
    @FXML
    private Label messageLabel;

    /**
     * component that displays a text
     */
    @FXML
    private TextArea textArea;

    @FXML
    private Canvas imageCanvas;

    @FXML
    private Group groupTextArea;

    @FXML
    private Group groupCanvas;

    /**
     * The directory that contains the names to be displayed in the list
     */
    private Directory directory;

    private final JsonLoader jsonLoader = new JsonLoader();
    private final TextLoader textLoader = new TextLoader();
    private final JavaFXImageLoader imageLoader = new JavaFXImageLoader();

    private final ZipLoader<JavaFXImage> zipLoader = new ZipLoader<>(jsonLoader, textLoader, imageLoader);

    private final Graphic<JavaFXImage> graphic = new Graphic<>(this.imageCanvas);

    private AnimationTimer timer;

    /**
     * Method called after the application has been displayed and the components
     * have
     * been initialized
     */
    public void initialize() {
        directory = new Directory();
        listView.getItems().addAll(directory.getFiles().keySet());
    }

    /**
     * Action load de la toolbar.
     *
     * @param ignoredActionEvent event
     */
    @FXML
    public void handleLoadFile(ActionEvent ignoredActionEvent) {
        try {
            InputStream is = new FileInputStream(FileExplorer.chooseFile());
            ZipInputStream zis = new ZipInputStream(is);

            Map<String, Object> content = this.zipLoader.load(zis);

            // Ajout des fichiers dans le directory
            directory.reset();
            directory.addAllFile(content);

            listView.getItems().clear();
            listView.getItems().addAll(content.keySet());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Action save de la toolbar.
     *
     * @param ignoredActionEvent event
     */
    @FXML
    public void handleSaveFile(ActionEvent ignoredActionEvent) {
        try {
            OutputStream is = new FileOutputStream(FileExplorer.saveFileChooser());
            ZipOutputStream zis = new ZipOutputStream(is);
            this.zipLoader.save(directory.getFiles(), zis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Manages actions to perform on an item in the list.
     *
     * @param ignoredMouseEvent the event that triggered this action
     *
     * @post the textArea content matches the selected item in the list
     */
    @FXML
    public void handleListClicked(MouseEvent ignoredMouseEvent) throws ParseException {
        String item = listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            if (this.timer != null) this.timer.stop(); // stop l'éventuel timer en cours
            graphic.clear(); // clear le canvas
            Object file = directory.getFile(item);
            String name = file.getClass().getName();

            switch (name) {
                case "fr.ensibs.javafx.graphic.JavaFXImage":
                    groupTextArea.setVisible(false);
                    groupCanvas.setVisible(true);
                    JavaFXImage image = (JavaFXImage) file;
                    graphic.drawImage(image);
                    break;
                case "org.json.JSONObject":
                    groupTextArea.setVisible(false);
                    groupCanvas.setVisible(true);

                    JSONObject json = (JSONObject) file;
                    System.out.println("JSON content : " + json);
                    Map<String, JavaFXImage> imgCollection = this.getImgFromDirectory(directory);

                    if (item.contains("snapshot")) {
                        SnapshotConverter<JavaFXImage> snapshotConverter = new SnapshotConverter<>(imgCollection);
                        Snapshot<JavaFXImage> snapshot = snapshotConverter.fromJson(json);
                        graphic.drawSnapshot(snapshot);

                    } else if (item.contains("sprite")) {
                        SpriteConverter<JavaFXImage> spriteConverter = new SpriteConverter<>(imgCollection);
                        Sprite<JavaFXImage> sprite = spriteConverter.fromJson(json);

                        if (sprite.isVisible()) {
                            AnimationTimer spriteTimer = new AnimationTimer() {
                                /**
                                 * @see <a href="https://stackoverflow.com/questions/50337303/how-do-i-change-the-speed-of-an-animationtimer-in-javafx">...</a>
                                 */
                                private long lastUpdate; // Last time in which `handle()` was called
                                private double totalElapsedMilliSeconds = 0;

                                @Override
                                public void start() {
                                    lastUpdate = System.nanoTime();
                                    super.start();
                                }

                                @Override
                                public void handle(long now) {
                                    long elapsedNanoSeconds = now - lastUpdate;
                                    double elapsedMilliSeconds = elapsedNanoSeconds / 1_000_000.0; // 1 second = 1,000,000,000 (1 billion) nanoseconds
                                    //System.out.println(elapsedMilliSeconds);

                                    if (totalElapsedMilliSeconds >= sprite.getDurationByFrame()) {
                                        JavaFXImage image = sprite.getCurrentImage();
                                        imageCanvas.getGraphicsContext2D().clearRect(0, 0, imageCanvas.getWidth(), imageCanvas.getHeight()); // clear le canva
                                        imageCanvas.getGraphicsContext2D().drawImage(image.getImage(), sprite.getX(), sprite.getY(), 350, 350);
                                        sprite.setCurrentTime(sprite.getCurrentTime() + 1);
                                        totalElapsedMilliSeconds = 0;
                                    } else {
                                        totalElapsedMilliSeconds = totalElapsedMilliSeconds + elapsedMilliSeconds;
                                    }
                                    lastUpdate = now;
                                }
                            };
                            this.timer = spriteTimer;
                            spriteTimer.start();
                        }
                    } else {
                        groupTextArea.setVisible(true);
                        groupCanvas.setVisible(false);
                        textArea.setText("Le type du fichier JSON n'est pas pris en charge.\n\n"
                                + directory.getFile(item).toString());
                    }
                    break;
                default:
                    groupCanvas.setVisible(false);
                    groupTextArea.setVisible(true);
                    textArea.setText("L'extension de fichier " + name + " n'est pas prise en charge.\n\n"
                            + directory.getFile(item).toString());
                    break;
            }
        } else {
            textArea.setText("");
        }
    }

    /**
     * Récupère les images depuis le dossier contenant les fichiers.
     *
     * @param directory le dossier contenant les fichiers
     * @return une collection d'images
     */
    private Map<String, JavaFXImage> getImgFromDirectory(@NotNull Directory directory) {
        Map<String, Object> collection = directory.getFiles(); // le dossier contenant tout les fichiers chargés
        Map<String, JavaFXImage> imgCollection = new HashMap<>(); // la collection d'images à renvoyer après remplissage

        for (Map.Entry<String, Object> entry : collection.entrySet()) { // parcours de la liste des fichiers du dossier
            String name = entry.getValue().getClass().getName();
            if (name.equals(JavaFXImage.class.getName())) {
                imgCollection.put(entry.getKey(), (JavaFXImage) entry.getValue()); // si un fichier est une image alors
                                                                                   // on l'ajoute à la nouvelle
                                                                                   // collection
            }
        }
        return imgCollection;
    }

    /**
     * Ask the user for a new name to be added to the list
     *
     * @param ignoredActionEvent the event that triggered this action
     * @post the name entered by the user, if any, is displayed in the list
     */
    @FXML
    public void handleAddItem(ActionEvent ignoredActionEvent) {

        try {
            File file = FileExplorer.chooseFile();
            String fileName = file.getName();
            String extension = fileName.substring(fileName.indexOf(".") + 1).toLowerCase();

            ILoader<?> loader;

            switch (extension) {
                case "png":
                case "jpg":
                case "jpeg":
                    loader = this.imageLoader;
                    break;
                case "json":
                    loader = this.jsonLoader;
                    break;
                default:
                    loader = this.textLoader;
                    break;
            }

            Object content = loader.load(new FileInputStream(file));

            directory.addFile(fileName, content);
            listView.getItems().add(fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package fr.ensibs.javafx.graphic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import fr.ensibs.util.io.JsonLoader;
import fr.ensibs.util.io.TextLoader;
import fr.ensibs.util.io.ZipLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

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

    /**
     * The directory that contains the names to be displayed in the list
     */
    private Directory directory;

    private JsonLoader jsonloader = new JsonLoader();

    private TextLoader textloader = new TextLoader();

    private ZipLoader zipLoader = new ZipLoader(jsonloader, textloader);

    /**
     * Method called after the application has been displayed and the components
     * have
     * been initialized
     */
    public void initialize() {
        directory = new Directory();
        listView.getItems().addAll(directory.getFiles().keySet());
    }

    @FXML
    public void handleLoadFile(ActionEvent actionEvent) {
        try {
            InputStream is = new FileInputStream(FileExplorer.chooseFile());
            ZipInputStream zis = new ZipInputStream(is);

            Map<String, Object> content = this.zipLoader.load(zis);

            directory.reset();
            directory.addAllFile(content);
            listView.getItems().clear();
            listView.getItems().addAll(content.keySet());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSaveFile(ActionEvent actionEvent) {
        try {
            OutputStream is = new FileOutputStream(FileExplorer.saveFileChooser());
            ZipOutputStream zis = new ZipOutputStream(is);
            this.zipLoader.save(directory.getFiles(), zis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the name selected in the list
     *
     * @param mouseEvent the event that triggered this action
     *
     * @post the textArea content matches the selected item in the list
     */
    @FXML
    public void handleListClicked(MouseEvent mouseEvent) {
        String item = listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            textArea.setText(directory.getFile(item).toString());
        } else {
            textArea.setText("");
        }
    }

    /**
     * Ask the user for a new name to be added to the list
     *
     * @param actionEvent the event that triggered this action
     * @post the name entered by the user, if any, is displayed in the list
     */
    @FXML
    public void handleAddItem(ActionEvent actionEvent) {

        try {
            File file = FileExplorer.chooseFile();
            String fileName = file.getName();

            TextLoader textloader = new TextLoader();
            String content = textloader.load(new FileInputStream(file));

            directory.addFile(fileName, content);
            listView.getItems().add(fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package fr.ensibs.javafx.graphic;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileExplorer {
    public static File chooseFile() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        return fileChooser.showOpenDialog(stage);
    }

    public static File saveFileChooser() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialFileName("file.zip");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Zip Files", "*.zip"));
        return fileChooser.showSaveDialog(stage);
    }
}

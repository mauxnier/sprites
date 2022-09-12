package fr.ensibs.mvc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

/**
 * Definitions of methods executed in reaction to user actions
 *
 * @author Pascale Launay
 */
public class ActionsHandler
{
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

    /**
     * Method called after the application has been displayed and the components have
     * been initialized
     */
    public void initialize()
    {
        directory = new Directory();
        listView.getItems().addAll(directory.getNames());
    }

    /**
     * Reset the list of names to its initial values
     *
     * @param actionEvent the event that triggered this action
     * @post the list contains the directory initial default elements
     */
    @FXML
    public void handleResetAction(ActionEvent actionEvent)
    {
        directory.reset();
        listView.getItems().clear();
        listView.getItems().addAll(directory.getNames());
    }

    /**
     * Displays the name selected in the list
     *
     * @param mouseEvent the event that triggered this action
     *
     * @post the textArea content matches the selected item in the list
     */
    @FXML
    public void handleListClicked(MouseEvent mouseEvent)
    {
        String item = listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            textArea.setText(item);
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
    public void handleAddItem(ActionEvent actionEvent)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setContentText("Name: ");
        inputDialog.setHeaderText("Enter the name to be added");
        inputDialog.showAndWait();
        String name = inputDialog.getEditor().getText();
        if (name != null && !name.equals("")) {
            directory.addName(name);
            listView.getItems().add(name);
        } else {
            messageLabel.setText("No name entered");
        }
    }
}

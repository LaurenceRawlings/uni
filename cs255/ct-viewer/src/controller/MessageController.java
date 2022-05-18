package controller;

import javafx.scene.control.Alert;

/**
 * Simple static method for displaying a message box from any FXML view.
 *
 * @author Laurence Rawlings (991368)
 * Declaration: I declare that this is my own code.
 */
class MessageController {
    static void showMessage(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
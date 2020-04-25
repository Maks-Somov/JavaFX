package sample.controllers;

/**
 * Maks
 * 09.04.2020.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerForNewFile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button nextButton;

    @FXML
    void initialize() {
        nextButton.setOnAction(event -> {
            Stage window = new Stage();
            nextButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/view/sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
//            window.setTitle("Hello");
            window.setScene(new Scene(root));
            window.show();
        });
    }
}



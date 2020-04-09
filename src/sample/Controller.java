package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passField;

    @FXML
    private Button authSignButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button loginSignUpButton;

    @FXML
    void initialize() {
        assert passField != null : "fx:id=\"passField\" was not injected: check your FXML file 'sample.fxml'.";
        assert authSignButton != null : "fx:id=\"authSignButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert loginField != null : "fx:id=\"loginField\" was not injected: check your FXML file 'sample.fxml'.";
        assert loginSignUpButton != null : "fx:id=\"loginSignUpButton\" was not injected: check your FXML file 'sample.fxml'.";

    }
}

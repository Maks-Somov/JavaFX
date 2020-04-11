package sample.controllers;
import static java.lang.System.out;
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
             authSignButton.setOnAction(event -> {
           out.println("была нажата кнопка вход");
       });

    }
}

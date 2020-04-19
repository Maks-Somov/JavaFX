package sample.controllers;

/**
 * Maks
 * 11.04.2020.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.datadase.DatabaseHandler;

public class ControllerForSignUp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private Button authSignButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField loginField1;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        authSignButton.setOnAction(event -> {
            dbHandler.signUpUser(signUpName.getText(), signUpLastName.getText(), loginField1.getText(),
                    passwordField1.getText(), signUpCountry.getText(), "Male");
        });
    }
}

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
import sample.User;
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


        authSignButton.setOnAction(event -> {
           signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = loginField1.getText();
        String password = passwordField1.getText();
        String location = signUpCountry.getText();
        String gender = "";

        if(signUpCheckBoxMale.isSelected()){
            gender = "Мужской";
        } else{
            gender = "Женский";
        }

        User user = new User(firstName, lastName, userName, password, location, gender);



        dbHandler.signUpUser(user);
    }
}

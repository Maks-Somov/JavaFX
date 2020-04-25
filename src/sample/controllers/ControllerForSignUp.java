package sample.controllers;

/**
 * Maks
 * 11.04.2020.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.User;
import sample.datadase.DatabaseHandler;
import javafx.scene.control.Alert;

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

            if(signUpNewUser()){

            Stage window = new Stage();
            authSignButton.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/view/sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            window.setTitle("Hello");
            window.setScene(new Scene(root, 700, 400));
            window.show();}
            else {
                System.out.println("gbsrtgbfdb");
            }
        });
    }

    private boolean signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        Window owner = authSignButton.getScene().getWindow();

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

        if(firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty() || location.isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Error!", "You should fill in all the fields!");
            return false;
        }else{

        if(password.length()>7) {
            User user = new User(firstName, lastName, userName, password, location, gender);
            dbHandler.signUpUser(user);
        }
        else {
            System.out.println("пароль должен быть больше 8 символов");
            showAlert(Alert.AlertType.ERROR, owner, "Error!", "You should write password more than 8 symbols!");
            return false;
        }
        }
       return true;
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}

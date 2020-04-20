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
           signUpNewUser();
           openNewScene("/sample/view/sample.fxml");
        });
    }

    private void signUpNewUser() {
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
        }else{

        if(password.length()>7) {
            User user = new User(firstName, lastName, userName, password, location, gender);
            dbHandler.signUpUser(user);
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                    "Welcome " + firstName + " "+ lastName);
        }else {System.out.println("пароль должен быть больше 8 символов");
            showAlert(Alert.AlertType.ERROR, owner, "Error!", "You should write password more than 8 symbols!");
        }
        }
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void openNewScene(String window){
        authSignButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}

package sample.controllers;
import static java.lang.System.out;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
            String loginText = loginField.getText().trim();
            String passwordText = passField.getText().trim();

            if(!loginText.equals("") && !passwordText.equals(""))
                userText(loginText, passwordText);
            else
                out.println("You didn't write login of password!");
        });

        loginSignUpButton.setOnAction(event -> {
           loginSignUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/SignUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

    private void userText(String loginText, String passwordText) {

    }
}

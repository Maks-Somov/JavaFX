package sample.controllers;
import static java.lang.System.out;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.User;
import sample.animations.Shake;
import sample.datadase.DatabaseHandler;


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


            Window owner = authSignButton.getScene().getWindow();

//            if(!loginText.equals("") && !passwordText.equals(""))
                userText(loginText, passwordText);
//            else{
//                out.println("You didn't write login or password!");
//            showAlert(Alert.AlertType.ERROR, owner, "Error!", "You should fill in all the fields!");
//            }
        });

        loginSignUpButton.setOnAction(event -> {
           openNewScene("/sample/view/SignUp.fxml");
        });

    }

    private void userText(String loginText, String passwordText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(passwordText);

        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter>=1){
            out.println("Success!");
            openNewScene("/sample/view/newFile.fxml");

        } else{
            Shake userLoginAnim = new Shake(loginField);
            Shake userPassAnim = new Shake(passField);
            userLoginAnim.playAnimation();
            userPassAnim.playAnimation();
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
        loginSignUpButton.getScene().getWindow().hide();

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

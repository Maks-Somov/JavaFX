package sample.controllers;

/**
 * Maks
 * 09.04.2020.
 */


import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ControllerForNewFile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label text;

    @FXML
    private Button pervButton;

    @FXML
    private Button nextButton;

    @FXML
    void initialize(){


        nextButton.setOnAction(event -> {

            try {
                text.setText(read("information.txt", 2, 5));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pervButton.setOnAction(event -> {

            text.setText("sdgd");
        });

    }

    private static String read(String fileName, int start, int end) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader (fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( "\n" );
        }

        return stringBuilder.toString();
    }


//            Stage window = new Stage();
//            nextButton.getScene().getWindow().hide();
//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getResource("/sample/view/sample.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            window.setTitle("Hello");
//            window.setScene(new Scene(root));
//            window.show();
}



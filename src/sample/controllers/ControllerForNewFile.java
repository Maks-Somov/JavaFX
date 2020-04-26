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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ControllerForNewFile {

    private static int count;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label text;

    @FXML
    private AnchorPane anhorPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button pervButton;

    @FXML
    private Button nextButton;

    @FXML
    void initialize() {
        try {
            text.setText(read("information.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(text, anhorPane, count, scrollPane);


        nextButton.setOnAction(event -> {
            try {
                if (text.getText().equals(read("information.txt"))) {
                    text.setText(read("info1.txt"));
                } else if (text.getText().equals(read("info1.txt"))) {
                    text.setText(read("info2.txt"));
                } else {
                    Stage window = new Stage();
                    nextButton.getScene().getWindow().hide();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/sample/view/test.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    window.setTitle("Hello");
                    window.setScene(new Scene(root));
                    window.show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            setSize(text, anhorPane, count, scrollPane);
        });

        pervButton.setOnAction(event -> {
            try {
                if (text.getText().equals(read("info1.txt"))) {
                    text.setText(read("information.txt"));
                } else if (text.getText().equals(read("info2.txt"))) {
                    text.setText(read("info1.txt"));
                } else text.setText(read("information.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setSize(text, anhorPane, count, scrollPane);
        });

    }

    private static String read(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            count++;
        }
        return stringBuilder.toString();
    }

    private void setSize(Label text, AnchorPane anhorPane, int count, ScrollPane scrollPane) {
        if (count > 10) {
            text.setPrefHeight(count * 20);
            anhorPane.setPrefHeight(count * 20);
            text.setPrefWidth(661);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } else {
            text.setPrefHeight(220);
            anhorPane.setPrefHeight(220);
            text.setPrefWidth(674);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        }
    }


}



package sample;

/**
 * Maks
 * 09.04.2020.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ControllerForNewFile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageButton;

    @FXML
    void initialize() {
        assert imageButton != null : "fx:id=\"imageButton\" was not injected: check your FXML file 'newFile.fxml'.";

    }
}


package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;


/**
 * Maks
 * 19.04.2020.
 */
public class Shake {
    private TranslateTransition tt;

    public Shake(Node node) {
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(-5f);
        tt.setByX(5f);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }

    public void playAnimation(){
        tt.playFromStart();
    }
}

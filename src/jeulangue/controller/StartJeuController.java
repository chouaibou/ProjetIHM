package jeulangue.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class StartJeuController {
    @FXML
    AnchorPane pageAccueil;

    @FXML
    private void lancerJeu(ActionEvent event) {
        changerEcran();
    }

    @FXML
    private void quitterJeu(ActionEvent event) {
        Stage stage = (Stage) pageAccueil.getScene().getWindow();
        stage.close();
    }

    private void changerEcran() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(pageAccueil);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event) -> {
            try {
                chargerFenetre();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fadeTransition.play();
    }

    private void chargerFenetre() throws IOException {
        Stage stage = (Stage) pageAccueil.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/choixLangue.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
    }
}

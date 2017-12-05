package jeulangue.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ChoixThemeController {
    @FXML
    AnchorPane pageTheme;

    @FXML
    Button btnRetour, btnSuivant;

    @FXML
    private void allerSuivant(ActionEvent event) { changerEcran(); }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnRetour.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/choixLangue.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    private void changerEcran() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(pageTheme);
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
        Stage stage = (Stage) pageTheme.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/quizVerbes.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
    }
}

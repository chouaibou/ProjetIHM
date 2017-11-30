package jeulangue.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoixLangueController {
    @FXML
    Button btnRetour, btnSuivant;

    @FXML
    private void allerSuivant(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSuivant.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/choixTheme.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnRetour.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/startJeu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

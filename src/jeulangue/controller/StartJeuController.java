package jeulangue.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartJeuController {
    @FXML
    Button btnJouer, btnQuitter;

    @FXML
    private void lancerJeu(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnJouer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/choixLangue.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void quitterJeu(ActionEvent event) {
        Stage stage = (Stage) btnQuitter.getScene().getWindow();
        stage.close();
    }
}

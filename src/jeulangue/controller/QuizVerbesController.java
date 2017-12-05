package jeulangue.controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizVerbesController implements Initializable {

    @FXML
    AnchorPane pageQuiz;

    @FXML
    Button btnRetour, btnReponse1, btnReponse2, btnReponse3;

    @FXML
    Label lblReponse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pageQuiz.setOpacity(0);
        ouvrirPage();
    }

    private void ouvrirPage() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(500));
        fadeTransition.setNode(pageQuiz);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnRetour.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/choixTheme.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void validerReponse(ActionEvent event) {
        Button boutonClique = (Button) event.getSource();
        String reponse = boutonClique.getText();
        lblReponse.setText(reponse);
        if (boutonClique == btnReponse1) {
            lblReponse.getStyleClass().remove("lblVrai");
            lblReponse.getStyleClass().add("lblFaux");
            btnReponse1.getStyleClass().removeAll("btnReponse");
            btnReponse1.getStyleClass().add("btnFaux");
            btnReponse1.setDisable(true);
        } else if (boutonClique == btnReponse2) {
            lblReponse.getStyleClass().remove("lblVrai");
            lblReponse.getStyleClass().add("lblFaux");
            btnReponse2.getStyleClass().removeAll("btnReponse");
            btnReponse2.getStyleClass().add("btnFaux");
            btnReponse2.setDisable(true);
        } else {
            lblReponse.getStyleClass().remove("lblFaux");
            lblReponse.getStyleClass().add("lblVrai");
            btnReponse3.getStyleClass().removeAll("btnReponse");
            btnReponse3.getStyleClass().add("btnVrai");
            btnReponse1.setDisable(true);
            btnReponse2.setDisable(true);
        }
    }
}

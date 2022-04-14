package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoggedIn implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button adminButton;


    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "login-page.fxml");
    }

    public void onStartTheGame(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "region-selector.fxml");

    }

    public void onPressTopScores(ActionEvent event) {
        Utility.getTop(event);

    }

    public void onAddQuestionButton(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "add-question.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("Welcome, " + Utility.name + "!");
        if (!Utility.name.equals("tavi")) {
            adminButton.setVisible(false);
        }

    }
}

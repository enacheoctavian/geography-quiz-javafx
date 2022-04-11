package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class LoggedIn {
    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "login-page.fxml");
    }
    public void onStartTheGame(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"region-selector.fxml");

    }
    public void onPressTopScores(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"region-selector.fxml");

    }
}

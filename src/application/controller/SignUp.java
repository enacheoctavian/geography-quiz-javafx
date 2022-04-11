package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SignUp {
    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"login-page.fxml");

    }
}

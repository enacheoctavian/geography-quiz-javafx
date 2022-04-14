package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Welcomepage {



    public void onPressStart(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"login-page.fxml");
    }
}

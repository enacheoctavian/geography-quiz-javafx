package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Welcomepage {



    public void onPressStart(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"login-page.fxml");
    }
}

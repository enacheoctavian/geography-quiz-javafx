package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class RegionSelector {

    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"logged-in-page.fxml");

    }

}

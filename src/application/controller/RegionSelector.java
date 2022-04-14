package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class RegionSelector {

    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"logged-in-page.fxml");

    }

    public void onPressEurope(ActionEvent event) throws IOException {
        Utility.reg=1;
        Utility.switchMyScene(event,"difficulty-selector.fxml");
    }
    public void onPressGlobal(ActionEvent event) throws IOException {
        Utility.reg=2;
        Utility.switchMyScene(event,"difficulty-selector.fxml");
    }

}

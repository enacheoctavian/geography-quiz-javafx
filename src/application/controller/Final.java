package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;


public class Final implements Initializable {


    @FXML
    private Label finals;
    @FXML
    private Label score;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        finals.setText("Congratulations "+ Utility.name + "!");
        score.setText("Your final score was:"+Utility.score+"!");
    }
}

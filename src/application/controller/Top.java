package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Top implements Initializable {

    @FXML
    private Label top1;
    @FXML
    private Label top2;
    @FXML
    private Label top3;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;




    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "logged-in-page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        score1.setText(""+Utility.scor1);
        score2.setText(Integer.toString(Utility.scor2));
        score3.setText(Integer.toString(Utility.scor3));
        top1.setText(Utility.top1);
        top2.setText(Utility.top2);
        top3.setText(Utility.top3);
    }
}

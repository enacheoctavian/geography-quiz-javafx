package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Final implements Initializable {


    @FXML
    private Label finals;
    @FXML
    private Label score;
    @FXML
    private Label winner3;
    @FXML
    private ImageView winner1;
    @FXML
    private ImageView winner2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Utility.isNewRecord()) {
            winner1.setVisible(true);
            winner2.setVisible(true);
            winner3.setVisible(true);
        } else {
            winner1.setVisible(false);
            winner2.setVisible(false);
            winner3.setVisible(false);
        }
        finals.setText("Congratulations " + Utility.name + "!");
        score.setText("Your final score was:" + Utility.score + "!");
        Utility.score=0;
    }

    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "logged-in-page.fxml");
    }
}

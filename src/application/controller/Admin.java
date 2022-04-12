package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Question;

import java.io.IOException;

public class Admin {

    @FXML
    private TextField questionId;
    @FXML
    private TextField ans1Id;
    @FXML
    private TextField ans2Id;
    @FXML
    private TextField ans3Id;
    @FXML
    private TextField ans4Id;
    @FXML
    private TextField correctId;
    @FXML
    private TextField diffId;
    @FXML
    private TextField regionId;

    private Question question=new Question();


    public void onAddQuestion(ActionEvent event) {
        question.setQuestion(questionId.getText());
        question.setAns1(ans1Id.getText());
        question.setAns2(ans2Id.getText());
        question.setAns3(ans3Id.getText());
        question.setAns4(ans4Id.getText());
        question.setCorrectAns(Integer.parseInt(correctId.getText()));
        question.setDif(Integer.parseInt(diffId.getText()));
        question.setRegion(Integer.parseInt(regionId.getText()));
        Utility.addQuestionToDB(event,question);

    }

    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "logged-in-page.fxml");
    }

}

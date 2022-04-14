package controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Difficulty {
    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "logged-in-page.fxml");

    }

    public void onPressEasy(ActionEvent event) throws IOException {
        Utility.dif = 1;
        Utility.getQuestionIds();
        Utility.nextQuestion(event);
        Utility.switchMyScene(event, "quiz-face.fxml");

    }

    public void onPressMedium(ActionEvent event) throws IOException {
        Utility.dif = 2;
        Utility.getQuestionIds();
        Utility.nextQuestion(event);
        Utility.switchMyScene(event, "quiz-face.fxml");

    }

    public void onPressHard(ActionEvent event) throws IOException {
        Utility.dif = 3;
        Utility.getQuestionIds();
        Utility.nextQuestion(event);
        Utility.switchMyScene(event, "quiz-face.fxml");
    }

}

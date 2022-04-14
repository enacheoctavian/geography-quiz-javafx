package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import model.Question;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActualQuiz implements Initializable {
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Label question;
    @FXML
    private ProgressBar progressBar;

    public static Question quiz = new Question();

    public void onBtn1(ActionEvent event) throws IOException {
        if (Utility.correct == 1)
            Utility.score = Utility.score + 10;
        if (Utility.n == 10)
            Utility.getScore(event);
        else {
            Utility.nextQuestion(event);
            question.setText(quiz.getQuestion());
            btn1.setText(quiz.getAns1());
            btn2.setText(quiz.getAns2());
            btn3.setText(quiz.getAns3());
            btn4.setText(quiz.getAns4());
        }
    }

    public void onBtn2(ActionEvent event) throws IOException {
        if (Utility.correct == 2)
            Utility.score = Utility.score + 10;
        if (Utility.n == 10)
            Utility.getScore(event);
        else {
            Utility.nextQuestion(event);
            question.setText(quiz.getQuestion());
            btn1.setText(quiz.getAns1());
            btn2.setText(quiz.getAns2());
            btn3.setText(quiz.getAns3());
            btn4.setText(quiz.getAns4());
        }
    }

    public void onBtn3(ActionEvent event) throws IOException {
        if (Utility.correct == 3)
            Utility.score = Utility.score + 10;
        if (Utility.n == 10)
            Utility.getScore(event);
        else {

            Utility.nextQuestion(event);
            question.setText(quiz.getQuestion());
            btn1.setText(quiz.getAns1());
            btn2.setText(quiz.getAns2());
            btn3.setText(quiz.getAns3());
            btn4.setText(quiz.getAns4());
        }
    }

    public void onBtn4(ActionEvent event) throws IOException {
        if (Utility.correct == 4)
            Utility.score = Utility.score + 10;
        if (Utility.n == 10)
            Utility.getScore(event);
        else {
            Utility.nextQuestion(event);
            question.setText(quiz.getQuestion());
            btn1.setText(quiz.getAns1());
            btn2.setText(quiz.getAns2());
            btn3.setText(quiz.getAns3());
            btn4.setText(quiz.getAns4());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        question.setText(quiz.getQuestion());
        btn1.setText(quiz.getAns1());
        btn2.setText(quiz.getAns2());
        btn3.setText(quiz.getAns3());
        btn4.setText(quiz.getAns4());

    }
}

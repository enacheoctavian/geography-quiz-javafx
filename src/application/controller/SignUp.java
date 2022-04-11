package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class SignUp {

    @FXML
    private TextField usernameSignUp;
    @FXML
    private PasswordField passwordSignUp;
    @FXML
    private Label errorSignup;

    public void canta(ActionEvent event) {
        if (!usernameSignUp.getText().trim().isEmpty() && !passwordSignUp.getText().trim().isEmpty())
            Utility.signUpUser(event, usernameSignUp.getText(), passwordSignUp.getText());
        else {
            System.out.println("Empty attempt");
            errorSignup.setText("Enter your desired credentials.");
        }

    }


    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event, "login-page.fxml");

    }
}

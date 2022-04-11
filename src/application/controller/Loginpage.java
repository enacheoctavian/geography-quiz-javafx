package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;
import java.sql.SQLException;

public class Loginpage {
    @FXML
    private Label loginErrorMessage;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    public void loginButtonOnAction(ActionEvent e) throws SQLException {
        Utility.logInUser(e,usernameTextField.getText(),passwordField.getText(),loginErrorMessage);
    }

    public void singUpButtonOnAction(ActionEvent e) throws IOException {
        Utility.switchMyScene(e,"sign-up-page.fxml");
    }
    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"welcome-page.fxml");

    }
}

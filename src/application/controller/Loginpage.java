package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Loginpage {
    public void onPressBack(ActionEvent event) throws IOException {
        Utility.switchMyScene(event,"welcome-page.fxml");

    }

    @FXML
    private Label loginErrorMessage;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    public void loginButtonOnAction(ActionEvent e){

        if(usernameTextField.getText().isBlank() == false && passwordField.getText().isBlank()==false) {
            loginErrorMessage.setText("Wrong credentials, try again!");
        }else{
            loginErrorMessage.setText("Please enter credentials");
        }
    }
}

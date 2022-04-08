package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Loginpage {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void onPressBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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

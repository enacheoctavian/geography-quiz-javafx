package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome-page.fxml"));
        stage.setTitle("Geography Quiz");
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.show();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root" ,"tavi");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users");

        while(resultSet.next()){
            System.out.println(resultSet.getString("userName"));
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

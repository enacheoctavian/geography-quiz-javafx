package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static javafx.fxml.FXMLLoader.load;

public class Utility {

    public static String name;
    public static String bestScore;
    public static String top1="";
    public static String top2="";
    public static String top3="";
    public static int scor1=1;
    public static int scor2=1;
    public static int scor3=1;


    public static void switchMyScene(ActionEvent event, String fxmlFile) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        root = load(Utility.class.getResource(fxmlFile));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void signUpUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE userName = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username.");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (userName , password) VALUES(?, ?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.executeUpdate();
                System.out.println("Sign-Up completed");
                name = username;

                switchMyScene(event, "logged-in-page.fxml");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String username, String password, Label warningText) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE userName = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found in database!");
                warningText.setText("Wrong credentials!");
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        name = username;
                        switchMyScene(event, "logged-in-page.fxml");
                    } else {
                        System.out.println("Passwords did not match!");
                        warningText.setText("Wrong credentials!");
                    }
                }

            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    public static void getTop(ActionEvent event) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("SELECT userName,bestScore FROM users ORDER BY bestScore;");
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                    i++;
                    String retrievedName = resultSet.getString("userName");
                    int retrievedScore = resultSet.getInt("bestScore");
                    if (i == 1) {
                        scor1 = retrievedScore;
                        top1 = retrievedName;

                    } else if (i == 2) {
                        scor2 = retrievedScore;
                        top2 = retrievedName;

                    } else {
                        scor3 = retrievedScore;
                        top3 = retrievedName;

                    }

                    if(i==3)
                        break;

            }

            switchMyScene(event, "top-page.fxml");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
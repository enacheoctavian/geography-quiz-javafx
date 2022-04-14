package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Question;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

import static java.util.Arrays.sort;
import static javafx.fxml.FXMLLoader.load;

public class Utility {

    public static String name;
    public static int bestScore;
    public static String top1 = "";
    public static String top2 = "";
    public static String top3 = "";
    public static int scor1 = 1;
    public static int scor2 = 1;
    public static int scor3 = 1;
    public static int reg = 1;
    public static int dif = 1;
    public static int correct;
    public static int score = 0;
    public static int[] ints;
    public static int i = -1;
    public static int n=0;


    public static void switchMyScene(ActionEvent event, String fxmlFile) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = load(Utility.class.getResource(fxmlFile));
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
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("SELECT userName,bestScore FROM users ORDER BY bestScore DESC;");
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

                if (i == 3)
                    break;

            }

            switchMyScene(event, "top-page.fxml");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void getTop2() {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("SELECT userName,bestScore FROM users ORDER BY bestScore DESC;");
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

                if (i == 3)
                    break;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addQuestionToDB(ActionEvent event, Question question) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("INSERT INTO questions (q,a1,a2,a3,a4,c,r,d) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getAns1());
            preparedStatement.setString(3, question.getAns2());
            preparedStatement.setString(4, question.getAns3());
            preparedStatement.setString(5, question.getAns4());
            preparedStatement.setInt(6, question.getCorrectAns());
            preparedStatement.setInt(7, question.getRegion());
            preparedStatement.setInt(8, question.getDif());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added to database!");
            switchMyScene(event, "add-question.fxml");
        } catch (SQLException | IOException e) {
            System.out.println("Fail");
            e.printStackTrace();
        }
    }

    public static void updateBest(String username, int NewBest) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("UPDATE users SET bestScore=? WHERE userName = ?");
            preparedStatement.setInt(1, NewBest);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fail");
            e.printStackTrace();
        }
    }

    public static void getQuestionIds() {
        if (dif == 1 & reg == 1)
            ints = new Random().ints(1, 41).distinct().limit(10).toArray();
        else if (dif == 2 & reg == 1)
            ints = new Random().ints(41, 51).distinct().limit(10).toArray();
        else if (dif == 3 && reg == 1)
            ints = new Random().ints(51, 62).distinct().limit(10).toArray();
        else
            ints = new Random().ints(1, 62).distinct().limit(10).toArray();
        sort(ints);
        i = -1;
    }

    public static void nextQuestion() {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        i++;
        n++;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-geography", "root", "tavi");
            preparedStatement = connection.prepareStatement("SELECT * FROM questions WHERE idquestions = ?");
            preparedStatement.setInt(1, ints[i]);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ActualQuiz.quiz.setQuestion(resultSet.getString("q"));
                ActualQuiz.quiz.setAns1(resultSet.getString("a1"));
                ActualQuiz.quiz.setAns2(resultSet.getString("a2"));
                ActualQuiz.quiz.setAns3(resultSet.getString("a3"));
                ActualQuiz.quiz.setAns4(resultSet.getString("a4"));
                correct = resultSet.getInt("c");
            }

        } catch (SQLException e) {
            System.out.println("Fail");
            e.printStackTrace();
        }

    }

    public static void getScore(ActionEvent event) throws IOException {
        n=0;
        if(score > bestScore)
        {
            updateBest(name,score);
        }


        switchMyScene(event,"final.fxml");
    }

    public static boolean isNewRecord(){
        getTop2();
        return score > scor1;
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
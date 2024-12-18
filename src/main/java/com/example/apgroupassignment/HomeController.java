package com.example.apgroupassignment;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HomeController {

    @FXML
    private Label username;
    @FXML
    private Button startQuizBtn,result;


    @FXML
    private void initialize() {

        username.setText("Welcome "+ CurrentUserDetails.naam+"!");


        startQuizBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try{
                    Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    thisstage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("quiz.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Quiz");
                    Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/pictures/logo.png")));
                    stage.getIcons().add(icon);
                    stage.setScene(scene);
                    stage.show();
                    quizController controller = fxmlLoader.getController();
                    controller.startTimer();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });


    }


    public void viewResults() {
        try {
            Stage thisStage = (Stage) result.getScene().getWindow();
            thisStage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("results.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/pictures/logo.png")));
            stage.getIcons().add(icon);
            stage.setTitle("Results");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




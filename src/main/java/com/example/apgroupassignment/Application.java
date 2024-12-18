package com.example.apgroupassignment;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application{
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        registerScene();
    }

    public void registerScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/pictures/logo.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Register!");
        stage.setScene(scene);
        stage.show();

        RegisterController registerController = fxmlLoader.getController();
        registerController.setApplication(this);
    }

    public void loginScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();

        LoginController loginController = fxmlLoader.getController();
        loginController.setApplication(this);
    }

    public void homeScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

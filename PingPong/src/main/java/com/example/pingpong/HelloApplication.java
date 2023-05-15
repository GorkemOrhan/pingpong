package com.example.pingpong;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox loader = fxmlLoader.load();
        double sceneWidth = 960;
        double sceneHeight = 600;
        Scene scene = new Scene(loader, sceneWidth, sceneHeight);
        Circle circle = new Circle(0,0,60);
        circle.setId("circleBall");
        circle.setFill(Ball.ballColor);
        loader.getChildren().add(circle);

        Rectangle rectangleLeft = new Rectangle(20,70);
        rectangleLeft.setId("rectLeftPaddle");
        loader.getChildren().add(rectangleLeft);
        rectangleLeft.setTranslateY(50);
        rectangleLeft.setTranslateX(100);
        rectangleLeft.setFill(Paddle.paddleColor);
        rectangleLeft.setStroke(Paddle.strokeColor);

        Rectangle rectangleRight = new Rectangle(20,100);
        rectangleRight.setId("rectRightPaddle");
        loader.getChildren().add(rectangleRight);
        rectangleRight.setTranslateY(50);
        rectangleRight.setTranslateX(-100);
        rectangleRight.setFill(Paddle.paddleColor);
        rectangleRight.setStroke(Paddle.strokeColor);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
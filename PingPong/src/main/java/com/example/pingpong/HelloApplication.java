package com.example.pingpong;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
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
        AnchorPane loader = fxmlLoader.load();
        double sceneWidth = 960;
        double sceneHeight = 600;
        Scene scene = new Scene(loader, sceneWidth, sceneHeight);
        Circle circle = new Circle(0,0,30);
        circle.setId("circleBall");
        circle.setFill(Ball.ballColor);
        circle.setLayoutX(scene.getWidth()/2);
        circle.setLayoutY(scene.getHeight()/2);
        loader.getChildren().add(circle);

        Rectangle rectangleLeft = new Rectangle(10,73);
        rectangleLeft.setId("rectLeftPaddle");
        rectangleLeft.setLayoutX(3);
        loader.getChildren().add(rectangleLeft);
        rectangleLeft.setFill(Paddle.BG_COLOR_LEFT);
        rectangleLeft.setStroke(Paddle.STROKE_COLOR);


        Rectangle rectangleRight = new Rectangle(10,73);
        rectangleRight.setId("rectRightPaddle");
        loader.getChildren().add(rectangleRight);
        rectangleRight.setLayoutX(scene.getWidth()-rectangleRight.getWidth()-3);
        rectangleRight.setFill(Paddle.BG_COLOR_RIGHT);
        rectangleRight.setStroke(Paddle.STROKE_COLOR);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        //rectangleLeft.setX(100);
        //rectangleLeft.setY(200);

    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.pingpong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
        stage.setResizable(false);
        Circle circle = new Circle(0,0,30);
        circle.setId("circleBall");
        circle.setFill(Ball.COLOR);
        circle.setLayoutX(scene.getWidth()/2);
        circle.setLayoutY(scene.getHeight()/2);
        loader.getChildren().add(circle);

        Rectangle rectangleLeft = new Rectangle(Paddle.WIDTH,Paddle.HEIGHT);
        rectangleLeft.setId("rectLeftPaddle");
        rectangleLeft.setLayoutX(Paddle.EDGE_SPACE);
        rectangleLeft.setLayoutY(scene.getHeight()/2-rectangleLeft.getHeight()/2);
        loader.getChildren().add(rectangleLeft);
        rectangleLeft.setFill(Paddle.BG_COLOR_LEFT);
        rectangleLeft.setStroke(Paddle.STROKE_COLOR);


        Rectangle rectangleRight = new Rectangle(Paddle.WIDTH,Paddle.HEIGHT);
        rectangleRight.setId("rectRightPaddle");
        loader.getChildren().add(rectangleRight);
        rectangleRight.setLayoutX(scene.getWidth()-rectangleRight.getWidth()-Paddle.EDGE_SPACE);
        rectangleRight.setLayoutY(scene.getHeight()/2-rectangleRight.getHeight()/2);
        rectangleRight.setFill(Paddle.BG_COLOR_RIGHT);
        rectangleRight.setStroke(Paddle.STROKE_COLOR);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
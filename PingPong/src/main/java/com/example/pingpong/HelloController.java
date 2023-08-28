package com.example.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;


public class HelloController {
    @FXML
    private AnchorPane apView;
    @FXML
    private Label xPosition;
    @FXML
    private Label yPosition;

    public void onActionStart(ActionEvent actionEvent) {
        Scene scene = apView.getScene();
        scene.setOnKeyPressed(event -> handleKeyPress(event));
        initializeBall();

    }

    private void handleKeyPress(KeyEvent event) {
        Scene scene = apView.getScene();
        Rectangle rectLeftPaddle = (Rectangle) apView.lookup("#rectLeftPaddle");
        Rectangle rectRightPaddle = (Rectangle) apView.lookup("#rectRightPaddle");
        double previousPosLeft = rectLeftPaddle.getTranslateY();
        double previousPosRight = rectRightPaddle.getTranslateY();
        double upperBoundary = -(scene.getHeight() / 2 - rectLeftPaddle.getHeight() / 2);
        if (event.getCode() == KeyCode.W && previousPosLeft > upperBoundary){
            rectLeftPaddle.setTranslateY(previousPosLeft - Paddle.SPEED);
        }
        else if (event.getCode() == KeyCode.Z && (previousPosLeft < scene.getHeight() / 2 - rectLeftPaddle.getHeight() / 2)){
            rectLeftPaddle.setTranslateY(previousPosLeft + Paddle.SPEED);
        }
        else if (event.getCode() == KeyCode.O && previousPosRight > upperBoundary){
            rectRightPaddle.setTranslateY(previousPosRight - Paddle.SPEED);
        }
        else if (event.getCode() == KeyCode.L && previousPosRight < scene.getHeight() / 2 - rectRightPaddle.getHeight() / 2){
            rectRightPaddle.setTranslateY(previousPosRight + Paddle.SPEED);
        }
    }
    private void initializeBall(){
        Random rand = new Random();
        int dir = rand.nextInt(4);
        xPosition.setText(BallDirection.getByNumber(dir).toString());
        //yPosition.setText(Double.toString(sceneY));
        Circle ball = (Circle) apView.lookup("#circleBall");
        double circlePreviousX = ball.getCenterX();// 50
        double circlePreviousY = ball.getCenterY();//100


        double circleNextX = circlePreviousX-Ball.SPEED_X;

        double circleNextY = circlePreviousY-Ball.SPEED_Y;

        ball.setTranslateY(circleNextY);
        ball.setCenterY(circleNextY);
        ball.setTranslateX(circleNextX);
        ball.setCenterX(circleNextX);
        Point2D pointInScene = ball.localToScene(ball.getCenterX(), ball.getCenterY());
        double sceneX = pointInScene.getX();
        double sceneY = pointInScene.getY();

    }

}
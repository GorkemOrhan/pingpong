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
import javafx.util.Pair;

import java.util.Random;


public class HelloController {
    @FXML
    private AnchorPane apView;
    @FXML
    private Label xPosition;
    @FXML
    private Label yPosition;


    private Circle getBall(){
        Circle ball = (Circle) apView.lookup("#circleBall");
        return ball;
    }

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

    double circleNextX = 0;
    double circleNextY = 0;

    private Speed getSpeed(){
        double x = Ball.SPEED_MULTIPLIER;
        double y = Ball.SPEED_MULTIPLIER*Math.sqrt(3);
        Speed speed = new Speed(x,y);
        return speed;
    }
    
    private void topLeft(double circlePrevX,double circlePrevY){
        Speed speed = getSpeed();
        circleNextX = circlePrevX-speed.getX();
        circleNextY = circlePrevY-speed.getY();
    }

    private void topRight(double circlePrevX, double circlePrevY){
        Speed speed = getSpeed();
        circleNextX = circlePrevX+speed.getX();
        circleNextY = circlePrevY-speed.getY();
    }

    private void bottomLeft(double circlePrevX, double circlePrevY){
        Speed speed = getSpeed();
        circleNextX = circlePrevX-speed.getX();
        circleNextY = circlePrevY+speed.getY();
    }

    private void bottomRight(double circlePrevX, double circlePrevY){
        Speed speed = getSpeed();
        circleNextX = circlePrevX+speed.getX();
        circleNextY = circlePrevY+speed.getY();
    }

    private void initializeBall(){
        Random rand = new Random();
        int dir = rand.nextInt(4 - 1 + 1) + 1;
        BallDirection currentDirection = BallDirection.TOP_LEFT; //BallDirection.getByNumber(dir);
        xPosition.setText(currentDirection.toString());
        Circle ball = (Circle) apView.lookup("#circleBall");
        double circlePreviousX = ball.getCenterX();
        double circlePreviousY = ball.getCenterY();

        switch (currentDirection){
            case TOP_LEFT:
                topLeft(circlePreviousX,circlePreviousY);
                break;
            case TOP_RIGHT:
                topRight(circlePreviousX,circlePreviousY);
                break;
            case BOTTOM_LEFT:
                bottomLeft(circlePreviousX,circlePreviousY);
                break;
            case BOTTOM_RIGHT:
                bottomRight(circlePreviousX,circlePreviousY);
                break;
        }

        ball.setTranslateY(circleNextY);
        ball.setCenterY(circleNextY);
        ball.setTranslateX(circleNextX);
        ball.setCenterX(circleNextX);
        Pair<Double, Double> currentPos = getCurrentPosition();
        xPosition.setText(String.valueOf(currentPos.getKey()));
        yPosition.setText(String.valueOf(currentPos.getValue()));
    }

    private Pair<Double,Double> getCurrentPosition(){
        Circle ball = getBall();
        Point2D pointInScene = ball.localToScene(ball.getCenterX(), ball.getCenterY());
        double sceneX = pointInScene.getX();
        double sceneY = pointInScene.getY();
        return new Pair<>(sceneX,sceneY);
    }
}
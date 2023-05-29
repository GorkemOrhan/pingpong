package com.example.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML
    private AnchorPane apView;

    public void onActionStart(ActionEvent actionEvent) {
        Circle circle = (Circle) apView.lookup("#circleBall");
        double previousPos = circle.getCenterX();
        double newPos = previousPos+100;
        Rectangle rectangle = (Rectangle) apView.lookup("#rectLeftPaddle");
        double layoutX = rectangle.getLayoutX();
        circle.setTranslateX(newPos);
        circle.setCenterX(newPos);
        Scene scene = apView.getScene();
        scene.setOnKeyPressed(event -> handleKeyPress(event));

    }

    private void handleKeyPress(KeyEvent event) {
        Scene scene = apView.getScene();
        Rectangle rectLeftPaddle = (Rectangle) apView.lookup("#rectLeftPaddle");
        Rectangle rectRightPaddle = (Rectangle) apView.lookup(("#rectRightPaddle"));
        double previousPosLeft = rectLeftPaddle.getLayoutY();
        double previousPosRight = rectRightPaddle.getLayoutY();
        if (event.getCode() == KeyCode.W && previousPosLeft>0){
            rectLeftPaddle.setTranslateY(Paddle.SPEED);
            rectLeftPaddle.setLayoutY();
        }
        else if (event.getCode() == KeyCode.Z && (previousPosLeft < scene.getHeight() - rectLeftPaddle.getHeight())){
            rectLeftPaddle.setTranslateY(previousPosLeft +Paddle.SPEED);
        }
//        else if (event.getCode() == KeyCode.O && previousPosRight>0){
//            rectRightPaddle.setTranslateY(previousPosRight -Paddle.SPEED);
//        }
//        else if (event.getCode() == KeyCode.L && previousPosRight < scene.getHeight() - rectRightPaddle.getHeight()){
//            rectRightPaddle.setTranslateY(previousPosRight +Paddle.SPEED);
//        }
    }


}
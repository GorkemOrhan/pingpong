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
        Rectangle rectLeftPaddle = (Rectangle) apView.lookup("#rectLeftPaddle");
        Rectangle rectRightPaddle = (Rectangle) apView.lookup(("#rectRightPaddle"));
        double previousPosLeft = rectLeftPaddle.getY();
        double previousPosRight = rectRightPaddle.getY();
        if (event.getCode() == KeyCode.W){
            rectLeftPaddle.setTranslateY(previousPosLeft -10);
            rectLeftPaddle.setY(previousPosLeft -10);
        }
        else if (event.getCode() == KeyCode.Z){
            rectLeftPaddle.setTranslateY(previousPosLeft +10);
            rectLeftPaddle.setY(previousPosLeft +10);
        }
        else if (event.getCode() == KeyCode.O){
            rectRightPaddle.setTranslateY(previousPosRight -10);
            rectRightPaddle.setY(previousPosRight -10);
        }
        else if (event.getCode() == KeyCode.L){
            rectRightPaddle.setTranslateY(previousPosRight -10);
            rectRightPaddle.setY(previousPosRight +10);
        }
    }


}
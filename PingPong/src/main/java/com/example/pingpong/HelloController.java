package com.example.pingpong;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML
    private VBox vBox;
    @FXML
    public Rectangle rectRightPaddle;

    public void onActionMoveRight(ActionEvent actionEvent) {
        Circle circle = (Circle) vBox.lookup("#circleBall");
        double previousPos = circle.getCenterX();
        double newPos = previousPos+100;
        circle.setTranslateX(newPos);
        circle.setCenterX(newPos);
        Scene scene = vBox.getScene();
        scene.setOnKeyPressed(event -> handleKeyPress(event));

    }

    private void handleKeyPress(KeyEvent event) {
        Rectangle rectLeftPaddle = (Rectangle) vBox.lookup("#rectLeftPaddle");
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
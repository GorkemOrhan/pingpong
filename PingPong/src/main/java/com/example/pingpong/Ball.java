package com.example.pingpong;

import javafx.scene.paint.Color;

import java.util.Random;

public class Ball {
    static Random rand = new Random();
    public static final int SPEED_MAX = 100;
    public static final int SPEED_MIN = -100;
    public static final int SPEED_X= 10;//rand.nextInt(SPEED_MAX - SPEED_MIN + 1) + SPEED_MIN;
    public static final int SPEED_Y = 10;//rand.nextInt(SPEED_MAX - SPEED_MIN + 1) + SPEED_MIN;
    public static final Color COLOR = Color.RED;
    public static final double posX = 0.0;
    public static final double posY = 0.0;
}

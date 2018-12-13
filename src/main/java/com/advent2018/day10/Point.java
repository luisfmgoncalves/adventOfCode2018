package com.advent2018.day10;

public class Point {
    public int xPos;
    public int yPos;
    public int xVel;
    public int yVel;

    public Point(int xPos, int yPos, int xVel, int yVel) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public void move() {
        xPos = xPos + xVel;
        yPos = yPos + yVel;
    }

    public void undo() {
        xPos = xPos - xVel;
        yPos = yPos - yVel;
    }

    public boolean isAtPosition(int x, int y) {
        return xPos == x && yPos == y;
    }
}

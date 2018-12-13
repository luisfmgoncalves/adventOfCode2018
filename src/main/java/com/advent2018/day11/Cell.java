package com.advent2018.day11;

public class Cell {

    public Integer x;
    public Integer y;
    private Integer rackID;
    public Integer powerLevel;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void calculatePowerLevel(Integer serialNumber) {
        rackID = x + 10;
        powerLevel = rackID * y;
        powerLevel += serialNumber;
        powerLevel *= rackID;
        powerLevel = (powerLevel/100)%10;
        powerLevel-=5;
    }
}

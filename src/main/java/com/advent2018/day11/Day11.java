package com.advent2018.day11;

public final class Day11 {

    private static final Integer SIZE = 300;
    private static final Integer SERIAL_NUMBER = 8444;
    private static Cell[][] cells = new Cell[SIZE][SIZE];

    public static void solveProblem() {
        solvePartOne();
//        solvePartTwo();
    }

    private static void solvePartOne() {
        setupCells();
        Result result = findPartOneResult();

        //Day 11 - part 1: 243,68
        System.err.println("Day 11 - part 1: " + result.cell.x + "," + result.cell.y);
    }

    public static void solvePartTwo() {
        setupCells();
        Result result = findPartTwoResult();
        //Day 11 - part 2: 236,252,12
        System.err.println("Day 11 - part 2: " + result.cell.x + "," + result.cell.y + "," + result.squareSize);
    }

    private static void setupCells() {
        for(int x = 0; x < SIZE; x++) {
            for(int y = 0; y < SIZE; y++) {
                cells[x][y] = new Cell(x,y);
                cells[x][y].calculatePowerLevel(SERIAL_NUMBER);
            }
        }
    }

    private static Result findPartOneResult() {
        int squareSize = 3;
        int max = 0;
        Result result = null;
        int currentValue;
        for (int x = 0; x < SIZE - squareSize; x++) {
            for (int y = 0; y < SIZE - squareSize; y++) {
                currentValue = getTotalPowerStartingAtForSquareSize(x, y, squareSize);
                if (currentValue > max) {
                    max = currentValue;
                    result = new Result(cells[x][y], squareSize);
                }
            }
        }
        return result;
    }


    private static Result findPartTwoResult() {
        /*
        * Same as finPartOneResult() but with a dynamic square size.
        * It gives the right result but is slow af.
        * TODO: Improve performance
        * */
        int max = 0;
        Result result = null;
        int currentValue;
        for(int squareSize = 1; squareSize < 300; squareSize++) {
            for (int x = 0; x < SIZE - squareSize; x++) {
                for (int y = 0; y < SIZE - squareSize; y++) {
                    currentValue = getTotalPowerStartingAtForSquareSize(x, y, squareSize);
                    if (currentValue > max) {
                        max = currentValue;
                        result = new Result(cells[x][y], squareSize);
                    }
                }
            }
        }
        return result;
    }

    private static Integer getTotalPowerStartingAtForSquareSize(int x, int y, int squareSize) {
        int totalPower = 0;
        for(int i = x; i < x + squareSize; i++) {
            for(int j = y; j < y + squareSize; j++) {
                totalPower += cells[i][j].powerLevel;
            }
        }
        return totalPower;
    }

    public static class Result {
        Cell cell;
        int squareSize;
        Result(Cell cell, int squareSize) {
            this.cell = cell;
            this.squareSize = squareSize;
        }
    }

}

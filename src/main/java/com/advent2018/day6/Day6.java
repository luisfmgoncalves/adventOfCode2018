package com.advent2018.day6;

import java.util.ArrayList;
import java.util.List;

public final class Day6 {

    public static void solveProblem() {
//        solvePartOne();
        solvePartTwo();
    }

    private static List<Coordinate> getInput() {
        List<Coordinate> coordinateList = Day6Input.getCoordinates();

//        int factor = 1;
//        List<Coordinate> coordinateList = new ArrayList<>();
//        coordinateList.add(new Coordinate(1*factor,1*factor));
//        coordinateList.add(new Coordinate(1*factor,6*factor));
//        coordinateList.add(new Coordinate(8*factor,3*factor));
//        coordinateList.add(new Coordinate(3*factor,4*factor));
//        coordinateList.add(new Coordinate(5*factor,5*factor));
//        coordinateList.add(new Coordinate(8*factor,9*factor));
        return coordinateList;
    }

    private static void solvePartOne() {
        Grid grid = new Grid(10);
        grid.storeCoordinates(getInput());
        grid.fillGridWithManhattenDistance();
//        grid.print();
        grid.gatherValuesForPartOne();
    }


    private static void solvePartTwo() {
        Grid grid = new Grid(600);
        grid.storeCoordinates(getInput());
        grid.fillGrid(10000);
//        grid.print();
        grid.gatherValuesForPartTwo();
    }

}

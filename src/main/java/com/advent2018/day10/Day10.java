package com.advent2018.day10;

import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public final class Day10 {

    private static List<Point> points;

    private static Integer minX = MAX_VALUE;
    private static Integer maxX = MIN_VALUE;
    private static Integer minY = MAX_VALUE;
    private static Integer maxY = MIN_VALUE;

    private static Integer numSeconds;

    public static void solveProblem() {
        points = Day10Input.getPointList();

        minX = minY = MAX_VALUE;
        maxX = maxY = MIN_VALUE;

        Integer distanceX = MAX_VALUE;
        Integer distanceY = MAX_VALUE;
        boolean found = false;
        numSeconds = 0;
        while(!found) {
            minX = minY = MAX_VALUE;
            maxX = maxY = MIN_VALUE;
            for(Point p : points) {
                p.move();
                setLimits(p);
            }

            if((maxX - minX) > distanceX && (maxY - minY) > distanceY) {
                //the distance between the points has increased
                found = true;
            }

            distanceX = maxX - minX;
            distanceY = maxY - minY;
            numSeconds++;
        }

        showResult();
    }

    private static void showResult() {
        //undo the point position
        for(Point p : points) {
            p.undo();
            setLimits(p);
        }
        numSeconds--;

        //"Day 10 - part 1: GFANEHKJ
        printPoints();

        //"Day 10 - part 2: 10086
        System.err.println("Day 10 - part 2: " + numSeconds);
    }

    private static void setLimits(Point point) {
        if(point.xPos < minX) minX = point.xPos;
        if(point.xPos > maxX) maxX = point.xPos;
        if(point.yPos < minY) minY = point.yPos;
        if(point.yPos > maxY) maxY = point.yPos;
    }

    private static void printPoints() {
        Character toPrint;
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                toPrint = '.';
                for (Point point : points) {
                    if (point.isAtPosition(x, y)) {
                        toPrint = '#';
                        break;
                    }
                }
                System.out.print(toPrint);
            }
            System.out.println();
        }
    }
}

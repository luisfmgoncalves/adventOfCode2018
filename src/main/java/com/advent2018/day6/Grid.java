package com.advent2018.day6;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Grid {

    private int size;
    private int[][] content;
    private List<Coordinate> coordinateList;

    public Grid(int size) {
        this.size = size;
        content = new int[size][size];
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                content[x][y] = -1;
            }
        }
    }

    public void storeCoordinates(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
        Coordinate c;
        for(int i = 0; i < coordinateList.size(); i++) {
            c = coordinateList.get(i);
            content[c.xPos][c.yPos] = i;
        }
    }

    public void print() {
        for (int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                String value = String.valueOf(content[x][y]);
                if(isInitialCoordinate(x,y)) {
                    value = "(" + value + ")";
                } else {
                    value = " " + value;
                }
                System.err.print(StringUtils.leftPad(value, 3, " "));
            }
            System.err.println();
        }
    }

    private boolean isInitialCoordinate(int x, int y) {
        for(Coordinate c : coordinateList) {
            if(c.xPos == x && c.yPos == y) {
                return true;
            }
        }
        return false;
    }

    public void fillGridWithManhattenDistance() {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(isInitialCoordinate(x, y)) continue;
                content[x][y] = getValueBasedOnManhattanDistance(x,y);
            }
        }
    }


    private int getValueBasedOnManhattanDistance(int x, int y) {
        Coordinate coordinate = coordinateList.get(0);
        int minDistance = 1000;
        int distance;
        int numOfCoordinatedAtSameDistance = 0;
        for(Coordinate c : coordinateList) {
            distance = Math.abs(x-c.xPos) + Math.abs(y-c.yPos);
            if(distance < minDistance) {
                minDistance = distance;
                coordinate = c;
                numOfCoordinatedAtSameDistance = 1;
            } else if (distance == minDistance){
                numOfCoordinatedAtSameDistance++;
            }
        }

        if(numOfCoordinatedAtSameDistance > 1) return -1;
        return content[coordinate.xPos][coordinate.yPos];
    }


    public void gatherValuesForPartOne() {
        Map<Integer,Integer> results = new HashMap<>();
        int value;
        for(int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                value = content[x][y];
                if(value == -1) continue;
                if(reachesLimit(value)) continue;
                if(results.get(value) != null) {
                    results.put(value, results.get(value) + 1);
                } else {
                    results.put(value, 1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> v : results.entrySet()) {
            System.err.println(v.getKey() + " -> " + v.getValue());
        }
    }


    private boolean reachesLimit(int value) {
        for(int i = 0; i < size; i++) {
            if(content[0][i] == value || content[size-1][i] == value) return true;
        }
        for(int i = 0; i < size; i++) {
            if(content[i][0] == value || content[i][size-1] == value) return true;
        }
        return false;
    }


    public void fillGrid(int limit) {
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(isInitialCoordinate(x, y)) continue;

                int totalDistance = 0;
                for(Coordinate c : coordinateList) {
                    totalDistance += Math.abs(x-c.xPos) + Math.abs(y-c.yPos);
                }

                content[x][y] = (totalDistance >= limit) ? -2 : -1;
            }
        }
    }

    public Integer gatherValuesForPartTwo() {
        int result = 0;
        int originalInArea = 0;
        for (int y = 0; y < size; y++) {
            int lineResult = 0;
            for(int x = 0; x < size; x++) {
                if(content[x][y] == -1) {
                    lineResult++;
                }
                if(content[x][y] > -1 && isInArea(x,y)) {
                    originalInArea++;
                }

            }
            result += lineResult;
        }

        System.err.println("result: " + result);
        System.err.println("original in area: " + originalInArea);
        System.err.println(">>>> " + (result + originalInArea));
        return result;
    }

    private boolean isInArea(int x, int y) {

        int xMin = (x - 1 < 0) ? 0 : x - 1;
        int xMax = (x + 1 > size - 1) ? x : x + 1;
        return content[xMin][y] == -1 ||
               content[xMax][y] == -1;
    }


//    private Coordinate getTopLeftCoordinate() {
//        Coordinate coordinate = coordinateList.get(0);
//        for(Coordinate c : coordinateList) {
//            if(c == coordinate) continue;
//            if(c.xPos <= coordinate.xPos && c.yPos <= coordinate.yPos) {
//                coordinate = c;
//            }
//        }
//        return coordinate;
//    }
//
//    private Coordinate getTopRightCoordinate() {
//        Coordinate coordinate = coordinateList.get(0);
//        for(Coordinate c : coordinateList) {
//            if(c == coordinate) continue;
//            if(c.xPos >= coordinate.xPos && c.yPos <= coordinate.yPos) {
//                coordinate = c;
//            }
//        }
//        return coordinate;
//    }
//
//    private Coordinate getBottomLeftCoordinate() {
//        Coordinate coordinate = coordinateList.get(0);
//        for(Coordinate c : coordinateList) {
//            if(c == coordinate) continue;
//            if(c.xPos <= coordinate.xPos && c.yPos >= coordinate.yPos) {
//                coordinate = c;
//            }
//        }
//        return coordinate;
//    }
//
//    private Coordinate getBottomRightCoordinate() {
//        Coordinate coordinate = coordinateList.get(0);
//        for(Coordinate c : coordinateList) {
//            if(c == coordinate) continue;
//            if(c.xPos >= coordinate.xPos && c.yPos >= coordinate.yPos) {
//                coordinate = c;
//            }
//        }
//        return coordinate;
//    }


//    private boolean isInteriorCoordinated(Coordinate coordinate) {
//
//        //if(coordinate == topLeft || coordinate == topRight || coordinate == bottomLeft || coordinate == bottomRight) return false;
//
//        boolean topLeft = false;
//        boolean topRight = false;
//        boolean bottomLeft = false;
//        boolean bottomRight = false;
//
//        for(Coordinate c : coordinateList) {
//            if(c == coordinate) continue;
//
////            if(c.xPos - bottomLeft.xPos >= bottomLeft.yPos - c.yPos && c.xPos - topLeft.xPos >= c.yPos - topLeft.yPos) return true;
////            if(bottomRight.xPos - c.xPos >= bottomRight.yPos - c.yPos && topRight.xPos - c.xPos >= c.yPos - topRight.yPos) return true;
////
////            if(c.xPos - topLeft.yPos <= c.yPos - topLeft.yPos && topRight.xPos - c.xPos >= c.yPos - topRight.yPos) return true;
////            if(bottomRight.xPos - c.xPos <= bottomRight.yPos - c.yPos && bottomRight.xPos - c.xPos <= bottomRight.yPos - c.yPos) return true;
//
//
//            if(c.xPos - coordinate.xPos >= c.yPos - coordinate.yPos) topLeft = true;
//            if(c.xPos > coordinate.xPos && c.yPos < coordinate.yPos) topRight = true;
//
//            if(c.xPos < coordinate.xPos && c.yPos > coordinate.yPos) bottomLeft = true;
//            if(c.xPos > coordinate.xPos && c.yPos > coordinate.yPos) bottomRight = true;
//
//            if(topLeft && topRight && bottomLeft && bottomRight) return true;
//        }
//        return false;
//    }

//    public void printInteriorCoordinates() {
//        for(Coordinate c : interiorCoordinates) {
//            System.err.println("(" + c.xPos + "," + c.yPos + ")");
//        }
//    }

//    private boolean isInitialCoordinate(int x, int y) {
//        for(Coordinate c : coordinateList) {
//            if(c.xPos == x && c.yPos == y) {
//                return true;
//            }
//        }
//        return false;
//    }
//


//    public void printInterior() {
//        for(int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                String value = String.valueOf(content[x][y]);
//                System.err.print(StringUtils.leftPad(value, 3, " "));
//            }
//            System.err.println();
//        }
//    }

//    public void gatherValues() {
//        Map<Integer,Integer> results = new HashMap<>();
//        int value;
//        for(int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                value = content[x][y];
//                if(value == -1) continue;
//                if(results.get(value) != null) {
//                    results.put(value, results.get(value) + 1);
//                } else {
//                    results.put(value, 1);
//                }
//            }
//        }
//        for(Map.Entry<Integer,Integer> v : results.entrySet()) {
//
//            System.err.println(v.getKey() + " -> " + v.getValue());
//        }
//    }


//    private int getValueBasedOnManhattanDistance(int x, int y) {
//        int minDistance = 1000;
//        Coordinate coordinate = coordinateList.get(0);
//        int occ = 0;
//        int distance;
//        for(Coordinate c : coordinateList) {
//            distance = Math.abs(x-c.xPos) + Math.abs(y-c.yPos);
//            if(distance < minDistance) {
//                minDistance = distance;
//                coordinate = c;
//                occ = 1;
//            } else if(distance == minDistance) {
//                occ++;
//            }
//        }
//
//        return (occ > 1 && interiorCoordinates.contains(coordinate)) ? -1 : content[coordinate.xPos][coordinate.yPos];
//    }


//
//    public void print() {
//        for(int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                System.err.print(content[x][y]);
//            }
//            System.err.println();
//        }
//    }
//
//    public void gatherValues() {
//        Map<Integer,Integer> results = new HashMap<>();
//        int value;
//        for(int x = 0; x < size; x++) {
//            for (int y = 0; y < size; y++) {
//                value = content[x][y];
//                if(value == -1) continue;
//                if(results.get(value) != null) {
//                    results.put(value, results.get(value) + 1);
//                } else {
//                    results.put(value, 1);
//                }
//            }
//        }
//
//        for(Map.Entry<Integer,Integer> v : results.entrySet()) {
//            System.err.println(v.getKey() + " -> " + v.getValue());
//        }
//    }
//
//    private int getValueBasedOnManhattanDistance(int x, int y) {
//
//        int minDistance = 1000;
//        Coordinate coordinate = coordinateList.get(0);
//        int occ = 0;
//        int distance;
//        for(Coordinate c : coordinateList) {
//            distance = Math.abs(x-c.xPos) + Math.abs(y-c.yPos);
//            if(distance < minDistance) {
//                minDistance = distance;
//                coordinate = c;
//                occ = 1;
//            } else if(distance == minDistance) {
//                occ++;
//            }
//        }
//
//        return (occ > 1 && interiorCoordinates.contains(coordinate)) ? -1 : content[coordinate.xPos][coordinate.yPos];
//    }
//
//    private boolean isInitialCoordinate(int x, int y) {
//        for(Coordinate c : coordinateList) {
//            if(c.xPos == x && c.yPos == y) {
//                return true;
//            }
//        }
//        return false;
//    }

}

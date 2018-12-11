package com.advent2018.day9;

import com.advent2018.day9.Day9Input.Input;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    private static MarbleList marbleList = new MarbleList();
    private static List<Long> scores = new ArrayList<>();
    private static Integer numMarbles;
    private static Integer numPlayers;

    public static void solveProblem() {
//        solvePartOne();
        solvePartTwo();
    }

    private static void solvePartOne() {
        setup(Day9Input.getInputPartOne());

        play();

        //Day 9 - part 1: 408679
        System.err.println("Day 9 - part 1: " + getMaxScore());
    }

    private static void solvePartTwo() {
        setup(Day9Input.getInputPartTwo());

        play();

//        Day 9 - part 2: 3443939356
        System.err.println("Day 9 - part 2: " + getMaxScore());
    }

    private static void setup(Input input) {
        numPlayers = input.numPlayers;
        numMarbles = input.numMarbles;
        scores = new ArrayList<>();
        for(int i = 0; i < numPlayers; i++) {
            scores.add(0L);
        }
    }

    private static Long getMaxScore() {
        Collections.sort(scores, Collections.reverseOrder());
        return scores.get(0);
    }

    public static void play() {
        StopWatch watch = new StopWatch();

        for(int i = 1; i <= numMarbles; i++) {
            int playerIndex = (i%numPlayers);
            scores.set(playerIndex, scores.get(playerIndex) + marbleList.addMarble(i));
        }

        System.err.println("done: "+ watch.getTime());
    }

}

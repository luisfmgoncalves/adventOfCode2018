package com.advent2018.day1;


import java.util.ArrayList;
import java.util.List;

public final class Day1 {

    public static void solveProblem() {
//        solvePart1();
        solvePart2();
    }

    private static void solvePart1() {
        Integer frequency = 0;
        for(Integer i : Day1Input.getNumericInput()) {
            frequency += i;
        }
        System.err.println("Day 1 - part 1: " + frequency);
    }

    private static void solvePart2() {
        List<Integer> input = Day1Input.getNumericInput();
        Integer index = 0;
        Integer frequency = 0;
        List<Integer> knownFrequencies = new ArrayList<>();

        while(!knownFrequencies.contains(frequency)) {
            knownFrequencies.add(frequency);
            frequency += input.get(index);
            index = index == (input.size() - 1) ? 0 : index+1;
        }
        System.err.println("Day 1 - part 2: " + frequency);
    }
}

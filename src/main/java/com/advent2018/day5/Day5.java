package com.advent2018.day5;

import java.util.HashMap;
import java.util.Map;

public final class Day5 {

    public static void solveProblem() {
//        solvePartOne();
        solvePartTwo();
    }

    private static void solvePartOne() {

//        String input = "dabAcCaCBAcCcaDA";
        String input = Day5Input.INPUT;
        System.err.println(react(input));
    }

    private static Integer react(String input) {
        StringBuilder builder = new StringBuilder(input);
        boolean foundResult = true;
        Character current;
        Character next;
        while(foundResult) {
            for(int i = 0; i < builder.length(); i++) {
                current = builder.charAt(i);
                if(i == builder.length() - 1) {
                    foundResult = false;
                    break;
                }
                next = builder.charAt(i + 1);
                if(isCounterPartChar(current, next)) {
                    builder = builder.deleteCharAt(i);
                    builder = builder.deleteCharAt(i);
                    foundResult = true;
                    break;
                }
            }
        }
        return builder.length();
    }

    private static boolean isCounterPartChar(Character one, Character two) {
        return ((Character.isLowerCase(one) && !Character.isLowerCase(two)) || (!Character.isLowerCase(one) && Character.isLowerCase(two))) &&
                (Character.toLowerCase(one) == Character.toLowerCase(two));

    }

    private static void solvePartTwo() {
        Map<Character,Integer> results = new HashMap<>();
//        String input = "dabAcCaCBAcCcaDA";
        String input = Day5Input.INPUT;

        Character c;
        String s;
        for(int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if(results.containsKey(Character.toUpperCase(c)) || results.containsKey(Character.toLowerCase(c))) {
                continue;
            }

            s = input;
            String inputModified = s.replace(c.toString(), "");
            if(Character.isLowerCase(c)) {
                inputModified = inputModified.replace(String.valueOf(Character.toUpperCase(c)),"");
            } else {
                inputModified = inputModified.replace(String.valueOf(Character.toLowerCase(c)),"");
            }
            System.err.println("checking: " + inputModified);

            Integer result = react(inputModified);
            results.put(c, result);
        }

        for(Map.Entry<Character, Integer> entry : results.entrySet()) {
            System.err.println("> " + entry.getKey() + " => " + entry.getValue());
        }

    }
}

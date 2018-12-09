package com.advent2018.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Day2 {

    public static void solveProblem() {
//        solvePart1();
        solvePart2();
    }

    private static void solvePart2() {
        List<String> input = Day2Input.getStringList();

        List<Result> results = new ArrayList<>();

        for(int i = 0; i < input.size(); i++) {
            if(i == input.size() - 1) break;
            List<String> toCompare = input.subList(i + 1, input.size());
            for(String str : toCompare) {
                results.add(compareStrings(input.get(i), str));
            }
        }

        Result lastResult = results.get(0);
        for(Result r : results) {
            if(r.difference < lastResult.difference) {
                lastResult = r;
            }
        }

        System.err.println("result: " + lastResult.result);
    }

    private static Result compareStrings(String stringA, String stringB) {
        char[] charsA = stringA.toCharArray();
        char[] charsB = stringB.toCharArray();

        String result = "";
        int diff = 0;
        for(int i = 0; i < charsA.length; i++) {
            if(charsA[i] == charsB[i]) {
                result += charsA[i];
            } else {
                diff++;
            }
        }
        return new Result(diff, result);
    }

    private static final class Result {
        private int difference;
        private String result;

        public Result(int difference, String result) {
            this.difference = difference;
            this.result = result;
        }

        public int getDifference() {
            return difference;
        }

        public String getResult() {
            return result;
        }
    }


    private static void solvePart1() {

        int duplicates = 0;
        int triplicates = 0;
        for(String str : Day2Input.getStringList()) {
            Map<Character, Integer> map = getOccurances(str);

            boolean hasDuplicate = false;
            boolean hasTriplicate = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if(value == 2 && !hasDuplicate) {
                    hasDuplicate = true;
                } else if(value == 3 && !hasTriplicate) {
                    hasTriplicate = true;
                }

                if(hasDuplicate && hasTriplicate) {
                    break;
                }
            }

            if(hasDuplicate) duplicates++;
            if(hasTriplicate) triplicates++;
        }
        System.err.println("result: " + (duplicates * triplicates));
    }

    private static Map<Character,Integer> getOccurances(String str) {
        Map<Character,Integer> values = new HashMap<>();
        for(Character c : str.toCharArray()) {
            if(!values.containsKey(c)) {
                values.put(c, 1);
            } else {
                values.put(c, values.get(c) + 1);
            }
        }
        return values;
    }


}

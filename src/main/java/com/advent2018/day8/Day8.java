package com.advent2018.day8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Day8 {

    private static List<Integer> input;
    private static Integer metaDataTotal = 0;

    private static Node rootNode;

    public static void solveProblem() {

        input = Arrays.stream(Day8Input.INPUT.split(" "))
                .map(strValue -> Integer.parseInt(strValue))
                .collect(Collectors.toList());

        rootNode = new Node();
        loadTree(0, rootNode);

        printPartOneResult();
        printPartTwoResult();
    }

    private static void printPartOneResult() {
        //Day 8 - part 1: 45868
        System.err.println("Day 8 - part 1: " + metaDataTotal);
    }

    private static void printPartTwoResult() {
        //Day 8 - part 2: 19724
        System.err.println("Day 8 - part 2: " + rootNode.getValue());
    }

    private static int loadTree(int currentIndex, Node parentNode) {
        int numChildren = input.get(currentIndex++);
        int numMetadata = input.get(currentIndex++);

        int i;
        //load children
        for(i = 0; i < numChildren; i++) {
            Node childNode = new Node();
            parentNode.childNodes.add(childNode);
            currentIndex = loadTree(currentIndex, childNode);
        }
        //load metadata
        for(i = 0; i < numMetadata; i++) {
            parentNode.metadata.add(input.get(currentIndex + i));
            metaDataTotal += input.get(currentIndex + i);
        }
        return currentIndex + numMetadata;
    }
}

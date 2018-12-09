package com.advent2018.day7;

import java.util.*;

public final class PartOne {

    private static Map<String,Step> steps;

    public static void run() {
        steps = Day7Input.getStepList();
        runPartOnePuzzle();
    }

    private static void runPartOnePuzzle() {
        String result = "";
        List<String> executedSteps = new ArrayList<>();
        String stepToExecute = getNextStepToExecute(executedSteps);
        while(stepToExecute != null) {
            executeStep(stepToExecute);
            executedSteps.add(stepToExecute);
            result += stepToExecute;
            stepToExecute = getNextStepToExecute(executedSteps);
        }
        //Day 7 - part 1: JRHSBCKUTVWDQAIGYOPXMFNZEL
        System.err.println("Day 7 - part 1: " + result);
    }

    private static String getNextStepToExecute(List<String> executedSteps) {
        List<String> nextSteps = new ArrayList<>();
        for(Map.Entry<String,Step> entry : steps.entrySet()) {
            String stepName = entry.getKey();
            if(!executedSteps.contains(stepName) && !entry.getValue().hasDependencies()) {
                nextSteps.add(stepName);
            }
        }
        Collections.sort(nextSteps);
        return nextSteps.size() == 0 ? null : nextSteps.get(0);
    }

    private static void executeStep(String stepName) {
        for(Map.Entry<String,Step> entry : steps.entrySet()) {
            if(entry.getValue().hasDependencies()) {
                entry.getValue().completeDependency(stepName);
            }
        }
    }
}

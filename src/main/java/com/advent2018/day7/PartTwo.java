package com.advent2018.day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class PartTwo {

    private static Map<String,Step> steps;
    private static List<Worker> workers = new ArrayList<>();
    public static Map<String, Integer> step_values = Day7Input.getInputForPart2();


    public static void run() {
        steps = Day7Input.getStepList();
        for(int i = 1; i < 6; i++) {
            workers.add(new Worker("Worker_" + i));
        }
        runPartTwoPuzzle();
    }

    private static void runPartTwoPuzzle() {
        List<String> executedSteps = new ArrayList<>();
        List<String> nextStepsToExecute = getNextStepsToExecute(executedSteps);
        int unitsOfTime = 0;
        while(nextStepsToExecute.size() > 0) {

            //assign a step to a worker
            for(String stepToExecute : nextStepsToExecute) {
                if(isStepBeingExecuted(stepToExecute)) continue;
                assignStepToWorker(stepToExecute);
            }

            //workers, do your job!
            List<String> completedSteps = executeSteps();
            for(String completedStep : completedSteps) {
                executedSteps.add(completedStep);
                completeStep(completedStep);
            }

            unitsOfTime++;
            nextStepsToExecute = getNextStepsToExecute(executedSteps);
        }

        //JRSBUCHKTVYWDQAOIGPXMFNZEL
        //Day 7 - part 2: 975
        System.err.println("Day 7 - part 2: " + unitsOfTime);
    }

    private static void completeStep(String stepName) {
        for(Map.Entry<String,Step> entry : steps.entrySet()) {
            if(entry.getValue().hasDependencies()) {
                entry.getValue().completeDependency(stepName);
            }
        }
    }

    private static boolean isStepBeingExecuted(String step) {
        for(Worker w : workers) {
            if(w.isBusy() && w.currentExecutingStep.equals(step)) return true;
        }
        return false;
    }

    private static List<String> executeSteps() {
        List<String> completedSteps = new ArrayList<>();
        for(Worker w : workers) {
            if(w.isBusy()) {
                w.executeStep();
                if (!w.isBusy()) {
                    completedSteps.add(w.currentExecutingStep);
                }
            }
        }
        return completedSteps;
    }

    private static void assignStepToWorker(String stepToExecute) {
        for(Worker w : workers) {
            if(!w.isBusy()) {
                w.pickupStep(stepToExecute);
                break;
            }
        }
    }

    private static List<String> getNextStepsToExecute(List<String> executedSteps) {
        List<String> nextSteps = new ArrayList<>();
        for(Map.Entry<String,Step> entry : steps.entrySet()) {
            String stepName = entry.getKey();
            if(!executedSteps.contains(stepName) && !entry.getValue().hasDependencies()) {
                nextSteps.add(stepName);
            }
        }
        Collections.sort(nextSteps);
        return nextSteps;
    }

}

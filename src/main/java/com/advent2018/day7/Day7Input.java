package com.advent2018.day7;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Day7Input {

    private static final Pattern STEP_PATTERN = Pattern.compile("^Step (\\w) must be finished before step (\\w) can begin.$");

    public static Map<String,Step> getStepList() {
        Map<String,Step> steps = new HashMap<>();
        for(String stepString : INPUT.split("\\n")) {
            parseInput(stepString, steps);
        }
        return steps;
    }

    public static Map<String,Integer> getInputForPart2() {
        Map<String,Integer> result = new HashMap<>();
        for(int i = 'A'; i <= 'Z'; i++) {
            result.put("" + (char)i, (i - 'A' + 1));
        }
        return result;
    }

    private static void parseInput(String stepString, Map<String,Step> steps) {
        Matcher matcher = STEP_PATTERN.matcher(stepString);
        if(matcher.matches()) {
            String dependency = matcher.group(1);
            String step = matcher.group(2);

            if(steps.get(dependency) == null) {
                steps.put(dependency, new Step(step));
            }

            Step s = steps.get(step);
            if(s == null) {
                s = new Step(step);
                steps.put(step, s);
            }
            s.addDependency(dependency);
        }
    }

    public static final String INPUT =
                    "Step S must be finished before step B can begin.\n" +
                    "Step B must be finished before step Y can begin.\n" +
                    "Step R must be finished before step E can begin.\n" +
                    "Step H must be finished before step M can begin.\n" +
                    "Step C must be finished before step F can begin.\n" +
                    "Step K must be finished before step A can begin.\n" +
                    "Step V must be finished before step W can begin.\n" +
                    "Step W must be finished before step L can begin.\n" +
                    "Step J must be finished before step L can begin.\n" +
                    "Step Q must be finished before step A can begin.\n" +
                    "Step U must be finished before step L can begin.\n" +
                    "Step Y must be finished before step M can begin.\n" +
                    "Step T must be finished before step F can begin.\n" +
                    "Step D must be finished before step A can begin.\n" +
                    "Step I must be finished before step M can begin.\n" +
                    "Step O must be finished before step P can begin.\n" +
                    "Step A must be finished before step L can begin.\n" +
                    "Step P must be finished before step N can begin.\n" +
                    "Step X must be finished before step Z can begin.\n" +
                    "Step G must be finished before step N can begin.\n" +
                    "Step M must be finished before step F can begin.\n" +
                    "Step N must be finished before step L can begin.\n" +
                    "Step F must be finished before step Z can begin.\n" +
                    "Step Z must be finished before step E can begin.\n" +
                    "Step E must be finished before step L can begin.\n" +
                    "Step O must be finished before step X can begin.\n" +
                    "Step B must be finished before step V can begin.\n" +
                    "Step H must be finished before step Q can begin.\n" +
                    "Step T must be finished before step M can begin.\n" +
                    "Step A must be finished before step G can begin.\n" +
                    "Step R must be finished before step H can begin.\n" +
                    "Step S must be finished before step C can begin.\n" +
                    "Step N must be finished before step Z can begin.\n" +
                    "Step Z must be finished before step L can begin.\n" +
                    "Step Q must be finished before step Z can begin.\n" +
                    "Step R must be finished before step G can begin.\n" +
                    "Step P must be finished before step Z can begin.\n" +
                    "Step U must be finished before step M can begin.\n" +
                    "Step W must be finished before step D can begin.\n" +
                    "Step F must be finished before step L can begin.\n" +
                    "Step D must be finished before step P can begin.\n" +
                    "Step I must be finished before step E can begin.\n" +
                    "Step M must be finished before step E can begin.\n" +
                    "Step H must be finished before step N can begin.\n" +
                    "Step F must be finished before step E can begin.\n" +
                    "Step D must be finished before step L can begin.\n" +
                    "Step C must be finished before step E can begin.\n" +
                    "Step H must be finished before step Z can begin.\n" +
                    "Step W must be finished before step Q can begin.\n" +
                    "Step X must be finished before step E can begin.\n" +
                    "Step G must be finished before step M can begin.\n" +
                    "Step X must be finished before step M can begin.\n" +
                    "Step Y must be finished before step P can begin.\n" +
                    "Step S must be finished before step I can begin.\n" +
                    "Step P must be finished before step X can begin.\n" +
                    "Step S must be finished before step T can begin.\n" +
                    "Step I must be finished before step N can begin.\n" +
                    "Step P must be finished before step L can begin.\n" +
                    "Step C must be finished before step X can begin.\n" +
                    "Step I must be finished before step G can begin.\n" +
                    "Step O must be finished before step F can begin.\n" +
                    "Step I must be finished before step X can begin.\n" +
                    "Step C must be finished before step Z can begin.\n" +
                    "Step B must be finished before step K can begin.\n" +
                    "Step T must be finished before step P can begin.\n" +
                    "Step Q must be finished before step X can begin.\n" +
                    "Step M must be finished before step N can begin.\n" +
                    "Step H must be finished before step O can begin.\n" +
                    "Step Q must be finished before step M can begin.\n" +
                    "Step U must be finished before step F can begin.\n" +
                    "Step Y must be finished before step O can begin.\n" +
                    "Step D must be finished before step O can begin.\n" +
                    "Step R must be finished before step T can begin.\n" +
                    "Step A must be finished before step E can begin.\n" +
                    "Step A must be finished before step M can begin.\n" +
                    "Step C must be finished before step N can begin.\n" +
                    "Step G must be finished before step E can begin.\n" +
                    "Step C must be finished before step Y can begin.\n" +
                    "Step A must be finished before step Z can begin.\n" +
                    "Step S must be finished before step X can begin.\n" +
                    "Step V must be finished before step Z can begin.\n" +
                    "Step Q must be finished before step I can begin.\n" +
                    "Step P must be finished before step E can begin.\n" +
                    "Step D must be finished before step F can begin.\n" +
                    "Step M must be finished before step Z can begin.\n" +
                    "Step U must be finished before step N can begin.\n" +
                    "Step Q must be finished before step L can begin.\n" +
                    "Step O must be finished before step Z can begin.\n" +
                    "Step N must be finished before step E can begin.\n" +
                    "Step S must be finished before step W can begin.\n" +
                    "Step S must be finished before step O can begin.\n" +
                    "Step U must be finished before step T can begin.\n" +
                    "Step A must be finished before step P can begin.\n" +
                    "Step J must be finished before step I can begin.\n" +
                    "Step A must be finished before step F can begin.\n" +
                    "Step U must be finished before step D can begin.\n" +
                    "Step W must be finished before step X can begin.\n" +
                    "Step O must be finished before step L can begin.\n" +
                    "Step J must be finished before step D can begin.\n" +
                    "Step R must be finished before step Z can begin.\n" +
                    "Step O must be finished before step N can begin.";

}

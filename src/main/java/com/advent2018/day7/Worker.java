package com.advent2018.day7;

import static com.advent2018.day7.PartTwo.step_values;

public final class Worker {

    String id;
    String currentExecutingStep;
    Integer remainingSteps;

    public Worker(String id) {
        this.id = id;
        remainingSteps = 0;
    }

    public boolean isBusy() {
        return remainingSteps > 0;
    }

    public void pickupStep(String step) {
        currentExecutingStep = step;
        remainingSteps = 60 + step_values.get(step);
    }

    public void executeStep() {
        remainingSteps--;
    }
}

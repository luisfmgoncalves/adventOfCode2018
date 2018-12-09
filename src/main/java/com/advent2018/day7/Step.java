package com.advent2018.day7;

import java.util.ArrayList;
import java.util.List;

public final class Step {

    private String stepName;
    private List<String> dependencies;

    public Step(String stepName) {
        this.stepName = stepName;
        this.dependencies = new ArrayList<>();
    }

    public boolean hasDependencies() {
        return dependencies.size() > 0;
    }

    public void addDependency(String dependency) {
        if(!dependencies.contains(dependency)) {
            dependencies.add(dependency);
        }
    }

    public boolean hasDependency(String dependency) {
        return dependencies.contains(dependency);
    }

    public void completeDependency(String step) {
        dependencies.remove(step);
    }

    public List<String> getDependencies() {
        return dependencies;
    }
}

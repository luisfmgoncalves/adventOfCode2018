package com.advent2018.day3;

import java.util.List;

public final class Day3 {

    private static final Fabric fabric = new Fabric(1000, 1000);
    private static final List<Claim> claims = Day3Input.getInputClaims();

    public static void solveProblem() {
        solvePartOne();
        solvePartTwo();
    }

    private static void solvePartOne() {
        System.err.println("Found " + claims.size() + " claims.");

        for(Claim c : claims) {
            int maxCols = c.getLefInches() + c.getWidth();
            int maxRows = c.getTopInches() + c.getHeight();
            for(int i = c.getLefInches(); i < maxCols; i++) {
                for(int j = c.getTopInches(); j < maxRows; j++) {
                    fabric.markPosition(i,j,c.getId().toString());
                }
            }
        }

        System.err.println("result: " + fabric.getNumberOfOverlapInches());
    }

    private static void solvePartTwo() {
        int claimId = -1;
        for(Claim c : claims) {
            if(!fabric.isOverlaped(c)) {
                claimId = c.getId();
                break;
            }
        }
        System.err.println("ID of non overlaped: " + claimId);
    }

}

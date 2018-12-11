package com.advent2018.day9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public final class Day9Input {

    public static Input getInputPartOne() {
        return new Input("424 players; last marble is worth 71482 points");
    }

    public static Input getInputPartTwo() {
        return new Input("424 players; last marble is worth 7148200 points");
    }

    public static class Input {

        private final Pattern INPUT_PATTERN = Pattern.compile("^(\\d+) players; last marble is worth (\\d+) points$");

        public Integer numPlayers;
        public Integer numMarbles;

        public Input(String strInput) {
            Matcher matcher = INPUT_PATTERN.matcher(strInput);
            if(matcher.matches()) {
                numPlayers = parseInt(matcher.group(1));
                numMarbles = parseInt(matcher.group(2));
            }
        }
    }

}

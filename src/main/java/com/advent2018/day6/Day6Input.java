package com.advent2018.day6;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public final class Day6Input {

    private static final Pattern COORDINATE_PATTERN = Pattern.compile("^(\\d+), (\\d+)$");

    public static List<Coordinate> getCoordinates() {
        return Arrays.stream(INPUT.split("\\n"))
                .map(line -> generateCoordinate(line))
                .collect(Collectors.toList());
    }

    private static Coordinate generateCoordinate(String coordinateStr) {
        Matcher matcher = COORDINATE_PATTERN.matcher(coordinateStr);
        if(matcher.matches()) {
            return new Coordinate(parseInt(matcher.group(1)), parseInt(matcher.group(2)));
        }
        return null;
    }

    private static final String INPUT =
            "158, 163\n" +
                    "287, 68\n" +
                    "76, 102\n" +
                    "84, 244\n" +
                    "162, 55\n" +
                    "272, 335\n" +
                    "345, 358\n" +
                    "210, 211\n" +
                    "343, 206\n" +
                    "219, 323\n" +
                    "260, 238\n" +
                    "83, 94\n" +
                    "137, 340\n" +
                    "244, 172\n" +
                    "335, 307\n" +
                    "52, 135\n" +
                    "312, 109\n" +
                    "276, 93\n" +
                    "288, 274\n" +
                    "173, 211\n" +
                    "125, 236\n" +
                    "200, 217\n" +
                    "339, 56\n" +
                    "286, 134\n" +
                    "310, 192\n" +
                    "169, 192\n" +
                    "313, 106\n" +
                    "331, 186\n" +
                    "40, 236\n" +
                    "194, 122\n" +
                    "244, 76\n" +
                    "159, 282\n" +
                    "161, 176\n" +
                    "262, 279\n" +
                    "184, 93\n" +
                    "337, 284\n" +
                    "346, 342\n" +
                    "283, 90\n" +
                    "279, 162\n" +
                    "112, 244\n" +
                    "49, 254\n" +
                    "63, 176\n" +
                    "268, 145\n" +
                    "334, 336\n" +
                    "278, 176\n" +
                    "353, 135\n" +
                    "282, 312\n" +
                    "96, 85\n" +
                    "90, 105\n" +
                    "354, 312";

}

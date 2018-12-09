package com.advent2018.day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SleepingMinutesHelper {

    private Map<Integer,Integer> occurences = new HashMap<>();
    public SleepingMinutesHelper() {
        for(int i = 0; i < 60; i++) {
            occurences.put(i,0);
        }
    }

    public void setMinutes(List<Integer> minutes) {
        for(Integer i : minutes) {
//            if(i > 0 && i < 60) {
                occurences.put(i, occurences.get(i) + 1);
//            }
        }
    }

    public int getMaxSleepingMinute() {
        int minute = 1;
        int max = occurences.get(1);
        for(Map.Entry<Integer,Integer> entry : occurences.entrySet()) {

            System.err.println(entry.getKey() + " => " + entry.getValue());

//            if(entry.getValue() > max) {
//                max = entry.getValue();
//                minute = entry.getKey();
//            }
        }
//        System.err.println("> minute: " + minute + ", times: " + max);
        return minute;
    }
}

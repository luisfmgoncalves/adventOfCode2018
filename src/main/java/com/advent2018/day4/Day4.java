package com.advent2018.day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public final class Day4 {

    public static void solveProblem() {
//        solvePartOne();
        solvePartTwo();
    }

    private static void solvePartOne() {
        List<SleepingSchedule> scheduleList = Day4Input.getSleepingSchedules();
        System.err.println("Sleeping schedules: " + scheduleList.size());

        //map containing the minutes sleeping / guard
        Map<String, Integer> map = new HashMap<>();
        for(SleepingSchedule schedule : scheduleList) {
            Integer helper = map.get(schedule.getGuard());
            Integer minutesAsleep = schedule.getMinutesSleeping().size();
            if(helper == null) {
                map.put(schedule.getGuard(), minutesAsleep);
            } else {
                map.put(schedule.getGuard(), map.get(schedule.getGuard()) + minutesAsleep);
            }
        }

        //guard with more minutes sleeping
        int max = 0;
        String sleepingGuard = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                sleepingGuard = entry.getKey();
            }
        }

        System.err.println("sleeping guard: " + sleepingGuard);

        SleepingMinutesHelper helper = new SleepingMinutesHelper();
        for(SleepingSchedule s : scheduleList) {
            if(s.getGuard().equals(sleepingGuard)) {
                helper.setMinutes(s.getMinutesSleeping());
            }
        }

        System.err.println(helper.getMaxSleepingMinute() * parseInt(sleepingGuard));
    }

    private static void solvePartTwo() {
        List<SleepingSchedule> scheduleList = Day4Input.getSleepingSchedules();

        Map<String, SleepingMinutesHelper> map = new HashMap<>();

        for(SleepingSchedule schedule : scheduleList) {

            if(schedule.getMinutesSleeping().size() > 0) {
                SleepingMinutesHelper helper = map.get(schedule.getGuard());
                if(helper == null) {
                    helper = new SleepingMinutesHelper();
                    map.put(schedule.getGuard(), helper);
                }
                helper.setMinutes(schedule.getMinutesSleeping());
            }
        }

        for(Map.Entry<String, SleepingMinutesHelper> entry : map.entrySet()) {
            System.err.println(entry.getKey() + " : ");
            entry.getValue().getMaxSleepingMinute();
        }

    }

}

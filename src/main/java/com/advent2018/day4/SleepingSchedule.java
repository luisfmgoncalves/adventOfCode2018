package com.advent2018.day4;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class SleepingSchedule implements Comparable<DateTime>{

    private String guard;
    private DateTime date;
    private int minuteStartSleeping;
    private List<Integer> minutesSleeping = new ArrayList<>();

    public SleepingSchedule() {
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public String getGuard() {
        return guard;
    }

    public void setDateTime(DateTime date) {
        this.date = date;
    }

    public DateTime getDate() {
        return this.date;
    }

    public void setMinuteStartSleeping(int startSleeping) {
        this.minuteStartSleeping = startSleeping;
    }

    public void setMinuteWakesUp(int minuteWakesUp) {
        for(int i = minuteStartSleeping; i < minuteWakesUp; i++) {
            minutesSleeping.add(i);
        }
    }

    public List<Integer> getMinutesSleeping() {
        return minutesSleeping;
    }

    @Override
    public int compareTo(DateTime o) {
        return o.compareTo(date);
    }
}

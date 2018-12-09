package com.advent2018.day4;

import com.advent2018.day4.Day4Input.ActionType;
import org.joda.time.DateTime;

import java.util.Comparator;

public class Action{

    private DateTime actionDate;
    private String actionString;
    private ActionType actionType;

    public Action(DateTime actionDate, String actionString, ActionType actionType) {
        this.actionDate = actionDate;
        this.actionString = actionString;
        this.actionType = actionType;
    }

    public DateTime getActionDate() {
        return actionDate;
    }

    public String getActionString() {
        return actionString;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public static class ActionComparator implements Comparator<Action> {
        @Override
        public int compare(Action o1, Action o2) {
            return o1.getActionDate().compareTo(o2.getActionDate());
        }
    }
}

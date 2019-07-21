package com.example.anif.onduty.models;

/**
 * Created by tomek on 28.09.2017.
 */

public class OnDuties {
    private Student mFirstOnDuty;
    private Student mSecondOnDuty;
    private String mInformation;
    private int mWeekNumber;

    public OnDuties(Student firstOnDuty, Student secondOnDuty, String information, int weekNumber) {
        this.mFirstOnDuty = firstOnDuty;
        this.mSecondOnDuty = secondOnDuty;
        this.mInformation = information;
        this.mWeekNumber = weekNumber;
    }

    public Student getFirstOnDuty() {
        return mFirstOnDuty;
    }

    public void setFirstOnDuty(Student firstOnDuty) {
        this.mFirstOnDuty = firstOnDuty;
    }

    public String getInformation() {
        return mInformation;
    }

    public int getWeekNumber() {
        return mWeekNumber;
    }

    public Student getSecondOnDuty() {
        return mSecondOnDuty;
    }

    public void setSecondOnDuty(Student secondOnDuty) {
        this.mSecondOnDuty = secondOnDuty;
    }
}

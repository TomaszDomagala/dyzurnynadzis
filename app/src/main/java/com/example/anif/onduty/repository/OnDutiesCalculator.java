package com.example.anif.onduty.repository;

/**
 * Created by tomek on 28.09.2017.
 * This class is created for student list indexed from 1 not 0 ;-)
 */


public class OnDutiesCalculator extends WeekCalculator{

    private int mNumberOfStudents;

    OnDutiesCalculator(int numberOfStudents) {
        this.mNumberOfStudents = numberOfStudents;
    }

    int getFirstOnDutyNumber() {
        int schoolWeekNumber = getSchoolWeekNumber();
        int firstNumber = (schoolWeekNumber * 2 - 1) % mNumberOfStudents;
        if (firstNumber == 0) {
            firstNumber = mNumberOfStudents;
        }
        return firstNumber;
    }

    int getFirstOnDutyNumber(int weekNumber) {
        int firstNumber = (weekNumber * 2 - 1) % mNumberOfStudents;
        if (firstNumber == 0) {
            firstNumber = mNumberOfStudents;
        }
        return firstNumber;
    }

    int getSecondOnDutyNumber() {
        int schoolWeekNumber = getSchoolWeekNumber();
        return (schoolWeekNumber * 2) % mNumberOfStudents;
    }

    int getSecondOnDutyNumber(int weekNumber) {
        return (weekNumber * 2) % mNumberOfStudents;
    }




}

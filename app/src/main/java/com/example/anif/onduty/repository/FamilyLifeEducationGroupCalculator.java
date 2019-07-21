package com.example.anif.onduty.repository;

/**
 * Created by tomek on 12.10.2017.
 */

public class FamilyLifeEducationGroupCalculator extends WeekCalculator {

    private final int NUMBER_OF_GROUPS = 3;

    public int getGroupNumber() {
        int weekNumber = getSchoolWeekNumber();
        int groupNumber;
        groupNumber = (weekNumber - 1) % NUMBER_OF_GROUPS;

        if (groupNumber == 0)
            groupNumber = 3;

        return groupNumber;
    }

}

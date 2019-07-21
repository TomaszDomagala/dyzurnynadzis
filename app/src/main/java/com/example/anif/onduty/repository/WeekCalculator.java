package com.example.anif.onduty.repository;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tomek on 12.10.2017.
 */

class WeekCalculator {
    int getSchoolWeekNumber() {
        long millisInWeek = 7 * 24 * 60 * 60 * 1000L;
        long firstSchoolDayInMillis = new GregorianCalendar(2017, 8, 4).getTimeInMillis();
        long currentTimeInMillis = new Date().getTime();
        long currentSchoolWeek = (currentTimeInMillis - firstSchoolDayInMillis) / millisInWeek;
        return (int) currentSchoolWeek + 1;
    }
}

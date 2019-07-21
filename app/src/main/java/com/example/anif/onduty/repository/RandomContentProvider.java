package com.example.anif.onduty.repository;


import android.content.Context;
import android.util.Log;

import com.example.anif.onduty.R;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by tomek on 28.09.2017.
 */

public class RandomContentProvider {
    private Random mRandom;
    private List<String> mOnDutiesIntroductions;
    private List<String> mWeekendTexts;
    private Calendar mCalendar;

    RandomContentProvider(Context context) {
        mCalendar = Calendar.getInstance();
        mRandom = new Random();
        mOnDutiesIntroductions = Arrays.asList(context.getResources().getStringArray(R.array.on_duties_introductions));
        mWeekendTexts = Arrays.asList(context.getResources().getStringArray(R.array.weekend_texts));
    }


    String getRandomIntroduction() {
        return mOnDutiesIntroductions.get( getNumberBasedOnDate() %  mOnDutiesIntroductions.size());
    }

    String getRandomWeekendText() {
        return mWeekendTexts.get((int) (getNumberBasedOnDate() % (long) mWeekendTexts.size()));
    }

    private int getNumberBasedOnDate() {
        return (int)( mCalendar.getTimeInMillis() / (1000 * 60 * 60 / 4));
    }
}

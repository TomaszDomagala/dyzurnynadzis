package com.example.anif.onduty.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.anif.onduty.models.OnDuties;
import com.example.anif.onduty.models.Student;
import java.util.List;

/**
 * Created by tomek on 28.09.2017.
 */

public class OnDutiesRepository {
    private List<Student> mStudents;
    private OnDutiesCalculator mOnDutiesCalculator;
    private RandomContentProvider mRandomContentProvider;

    public OnDutiesRepository(Context context) {
        mStudents = HardcodeStudents.getStudents();
        mOnDutiesCalculator = new OnDutiesCalculator(getNumberOfStudents());
        mRandomContentProvider = new RandomContentProvider(context);
    }

    public LiveData<OnDuties> getOnDuties() {
        final MutableLiveData<OnDuties> data = new MutableLiveData<>();
        int firstNumber = mOnDutiesCalculator.getFirstOnDutyNumber();
        int secondNumber = mOnDutiesCalculator.getSecondOnDutyNumber();
        Student firstOnDuty = getStudent(firstNumber);
        Student secondOnDuty = getStudent(secondNumber);
        OnDuties onDuties = new OnDuties(firstOnDuty, secondOnDuty, mRandomContentProvider.getRandomIntroduction(), mOnDutiesCalculator.getSchoolWeekNumber());
        data.setValue(onDuties);
        return data;
    }

    public LiveData<OnDuties> getNextOnDuties() {
        final MutableLiveData<OnDuties> data = new MutableLiveData<>();
        int nextWeekNumber = mOnDutiesCalculator.getSchoolWeekNumber() + 1;
        int firstNumber = mOnDutiesCalculator.getFirstOnDutyNumber(nextWeekNumber);
        int secondNumber = mOnDutiesCalculator.getSecondOnDutyNumber(nextWeekNumber);
        Student firstOnDuty = getStudent(firstNumber);
        Student secondOnDuty = getStudent(secondNumber);
        OnDuties onDuties = new OnDuties(firstOnDuty, secondOnDuty, mRandomContentProvider.getRandomWeekendText(), nextWeekNumber);
        data.setValue(onDuties);
        return data;
    }


    private Student getStudent(int number) {
        for (Student student : mStudents) {
            if (student.getNumber() == number) {
                return student;
            }
        }
        return new Student("Error", "Student", -1,-1);
    }

    private int getNumberOfStudents() {
        return mStudents.size();
    }




}

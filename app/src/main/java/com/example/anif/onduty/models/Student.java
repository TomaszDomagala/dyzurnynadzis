package com.example.anif.onduty.models;

import android.support.annotation.NonNull;

/**
 * Created by tomek on 28.09.2017.
 */

public class Student implements Comparable<Student> {
    private int mNumber;
    private String mName;
    private String mSurname;
    private int mFamilyLifeEducationGroup;

    public Student(String name, String surname, int number,int familyLifeEducationGroup) {
        this.mName = name;
        this.mSurname = surname;
        this.mNumber = number;
        this.mFamilyLifeEducationGroup = familyLifeEducationGroup;
    }

    public String getName() {
        return mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public String getFullName() {
        return mName + " " + mSurname;
    }

    public int getNumber() {
        return mNumber;
    }

    public int getFamilyLifeEducationGroup() {
        return mFamilyLifeEducationGroup;
    }

    @Override
    public int compareTo(@NonNull Student compareStudent) {
        String compareSurname = compareStudent.getSurname();
        return this.getSurname().compareTo(compareSurname);
    }
}

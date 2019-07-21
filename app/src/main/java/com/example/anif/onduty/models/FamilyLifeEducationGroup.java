package com.example.anif.onduty.models;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by tomek on 12.10.2017.
 */

public class FamilyLifeEducationGroup {

    private List<Student> mGroupOfStudents;
    private Integer mGroupNumber;

    public FamilyLifeEducationGroup(List<Student> group, Integer groupNumber){
        this.mGroupOfStudents = group;
        this.mGroupNumber = groupNumber;
    }

    public FamilyLifeEducationGroup(){

    }

    public List<Student> getGroupOfStudents() {
        return mGroupOfStudents;
    }

    public void setGroupOfStudents(List<Student> groupOfStudents) {
        this.mGroupOfStudents = mGroupOfStudents;
    }
    public Integer getGroupNumber() {
        return mGroupNumber;
    }

    public void setGroupNumber(Integer mGroupNumber) {
        this.mGroupNumber = mGroupNumber;
    }
}

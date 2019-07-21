package com.example.anif.onduty.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.anif.onduty.models.FamilyLifeEducationGroup;
import com.example.anif.onduty.models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tomek on 12.10.2017.
 */

public class FamilyLifeEducationGroupRepository {
    private FamilyLifeEducationGroupCalculator mCalculator;

    public FamilyLifeEducationGroupRepository() {
        mCalculator = new FamilyLifeEducationGroupCalculator();

    }

    public LiveData<FamilyLifeEducationGroup> getGroup() {
        MutableLiveData<FamilyLifeEducationGroup> data = new MutableLiveData<>();
        Integer groupNumber = mCalculator.getGroupNumber();
        FamilyLifeEducationGroup group = new FamilyLifeEducationGroup(getGroupStudents(), groupNumber);
        data.setValue(group);
        return data;
    }

    private List<Student> getGroupStudents() {
        List<Student> group = new ArrayList<>();
        for (Student student : HardcodeStudents.getStudents()) {
            if (student.getFamilyLifeEducationGroup() == mCalculator.getGroupNumber()) {
                group.add(student);
            }
        }
        Collections.sort(group);
        return group;
    }
}

package com.example.anif.onduty.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.anif.onduty.repository.FamilyLifeEducationGroupRepository;

/**
 * Created by tomek on 12.10.2017.
 */

public class FamilyLifeEducationGroupViewModel extends ViewModel {
    private LiveData<FamilyLifeEducationGroup> mGroup;
    private FamilyLifeEducationGroupRepository mRepository;

    public FamilyLifeEducationGroupViewModel() {
        this.mRepository = new FamilyLifeEducationGroupRepository();
    }

    public void init() {
        if(this.mGroup == null){
            mGroup = mRepository.getGroup();
        }
    }

    public LiveData<FamilyLifeEducationGroup> getGroup(){
        return mGroup;
    }


}

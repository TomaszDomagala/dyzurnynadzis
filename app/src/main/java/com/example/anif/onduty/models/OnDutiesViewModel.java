package com.example.anif.onduty.models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.anif.onduty.repository.OnDutiesRepository;

/**
 * Created by tomek on 28.09.2017.
 */

public class OnDutiesViewModel extends AndroidViewModel {
    private LiveData<OnDuties> mOnDuties;
    private OnDutiesRepository mOnDutiesRepository;

    public OnDutiesViewModel(Application application) {
        super(application);
        this.mOnDutiesRepository = new OnDutiesRepository(getApplication().getApplicationContext());
    }

    public void init() {
        if (this.mOnDuties == null) {
            mOnDuties = mOnDutiesRepository.getOnDuties();
        }
    }

    public LiveData<OnDuties> getOnDuties() {
        return mOnDuties;
    }
}

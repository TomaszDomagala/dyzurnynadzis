package com.example.anif.onduty.content;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anif.onduty.R;
import com.example.anif.onduty.models.OnDutiesViewModel;

/**
 * Created by tomek on 29.09.2017.
 */

public class WorkingDayFragment extends Fragment {
    private OnDutiesViewModel vmViewModel;
    private TextView mOnDutiesIntroduction;
    private TextView mFirstOnDutyName;
    private TextView mSecondOnDutyName;
    private TextView mCurrentSchoolWeekNumber;

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOnDutiesIntroduction = getView().findViewById(R.id.on_duties_introduction);
        mFirstOnDutyName = getView().findViewById(R.id.onduty_first_name);
        mSecondOnDutyName = getView().findViewById(R.id.on_duty_second_name);
        mCurrentSchoolWeekNumber = getView().findViewById(R.id.current_school_week_number);

        vmViewModel = ViewModelProviders.of(this).get(OnDutiesViewModel.class);
        vmViewModel.init();
        vmViewModel.getOnDuties().observe(this, onDuties -> {
            mOnDutiesIntroduction.setText(onDuties.getInformation());
            mFirstOnDutyName.setText(onDuties.getFirstOnDuty().getFullName());
            mSecondOnDutyName.setText(onDuties.getSecondOnDuty().getFullName());
            mCurrentSchoolWeekNumber.setText(String.valueOf(onDuties.getWeekNumber()));
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.working_day_fragment, container, false);
    }

}

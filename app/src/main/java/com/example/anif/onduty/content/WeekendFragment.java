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
import com.example.anif.onduty.models.NextWeekOnDutiesViewModel;

/**
 * Created by tomek on 29.09.2017.
 */

public class WeekendFragment extends Fragment {
    private TextView mBottomText;
    private TextView mFirstOnDutyName;
    private TextView mSecondOnDutyName;
    private NextWeekOnDutiesViewModel mViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBottomText = getView().findViewById(R.id.weekend_bottom_text);
        mFirstOnDutyName = getView().findViewById(R.id.weekend_on_duty_first_name);
        mSecondOnDutyName = getView().findViewById(R.id.weekend_on_duty_second_name);

        mViewModel = ViewModelProviders.of(this).get(NextWeekOnDutiesViewModel.class);
        mViewModel.init();
        mViewModel.getOnDuties().observe(this, onDuties -> {
            mBottomText.setText(onDuties.getInformation());
            mFirstOnDutyName.setText(onDuties.getFirstOnDuty().getFullName());
            mSecondOnDutyName.setText(onDuties.getSecondOnDuty().getFullName());
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weekend_fragment, container, false);
    }


}





package com.example.anif.onduty.content;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anif.onduty.R;
import com.example.anif.onduty.EasterEggActivity;
import com.example.anif.onduty.models.FamilyLifeEducationGroupViewModel;
import com.example.anif.onduty.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomek on 30.09.2017.
 */

public class FamilyLifeEducationGroupFragment extends Fragment {
    private ArrayAdapter<String> mAdapter;
    private ListView mListView;
    private FamilyLifeEducationGroupViewModel mViewModel;
    private View mGroupHeader;
    private TextView mHeaderText;

    private Integer mSecretClickCount = 0;
    private final Integer SECRET_TRIGGER_VALUE = 7;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGroupHeader = getLayoutInflater().inflate(R.layout.fle_group_header, null);
        mListView = getView().findViewById(R.id.fle_students_list);
        mHeaderText = mGroupHeader.findViewById(R.id.fle_header_text);
        mGroupHeader.setOnClickListener(view -> {
            mSecretClickCount++;
            if (mSecretClickCount == SECRET_TRIGGER_VALUE) {
                mSecretClickCount = 0;
                Intent intent = new Intent(getActivity().getApplicationContext(), EasterEggActivity.class);
                startActivity(intent);
            }
        });
        mViewModel = ViewModelProviders.of(this).get(FamilyLifeEducationGroupViewModel.class);
        mViewModel.init();

        mViewModel.getGroup().observe(this, familyLifeEducationGroup -> {
            List<String> studentNames = new ArrayList<>();
            for (Student student : familyLifeEducationGroup.getGroupOfStudents()) {
                studentNames.add(student.getFullName());
            }
            mAdapter = new ArrayAdapter<>(getContext(), R.layout.fle_list_item, studentNames);

            mHeaderText.setText(getResources().getString(R.string.group_introduction) + " " + familyLifeEducationGroup.getGroupNumber());
            mListView.addHeaderView(mGroupHeader);
            mListView.setAdapter(mAdapter);
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        mSecretClickCount = 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fle_fragment, container, false);
    }


}

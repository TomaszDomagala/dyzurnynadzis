package com.example.anif.onduty;

import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;


import com.example.anif.onduty.content.FamilyLifeEducationGroupFragment;
import com.example.anif.onduty.content.ThirdFragment;
import com.example.anif.onduty.content.WeekendFragment;
import com.example.anif.onduty.content.WorkingDayFragment;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private BottomNavigationView mBottomNavigationMenuView;
    private Toolbar mToolbar;

    private Fragment mOnDutiesFragment;
    private FamilyLifeEducationGroupFragment mFamilyLifeEducationGroupFragment;
    private ThirdFragment mThirdFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        mBottomNavigationMenuView = findViewById(R.id.bottom_navigation);
        mBottomNavigationMenuView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mFragmentManager = getSupportFragmentManager();
        setUpContentFragments();
        setFragment(mOnDutiesFragment);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.bottom_navigation_on_duties_item:
                setFragment(mOnDutiesFragment);
                break;
            case R.id.bottom_navigation_second_item:
                setFragment(mFamilyLifeEducationGroupFragment);
                break;
//            case R.id.bottom_navigation_third_item:
//                setFragment(mThirdFragment);
//                break;
        }
        return true;
    };

    private void setFragment(Fragment fragment) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.main_content, fragment);
        mFragmentTransaction.commit();
    }

    private void setUpContentFragments() {
        mFamilyLifeEducationGroupFragment = new FamilyLifeEducationGroupFragment();
        mThirdFragment = new ThirdFragment();
        setUpOnDutiesFragment();
    }

    private void setUpOnDutiesFragment() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
            mOnDutiesFragment = new WeekendFragment();
        } else {
            mOnDutiesFragment = new WorkingDayFragment();
        }
    }

    private void setUpToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);

        setSupportActionBar(mToolbar);
    }

}

package com.cs.blogger.Activities.Timetables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.Results.ResultsViewPagerAdapter;
import com.cs.blogger.Fragments.SobResults;
import com.cs.blogger.Fragments.SoeResults;
import com.cs.blogger.Fragments.SoictResults;
import com.cs.blogger.Fragments.SomResults;
import com.cs.blogger.Fragments.timetableCseFriday;
import com.cs.blogger.Fragments.timetableCseMonday;
import com.cs.blogger.Fragments.timetableCseSaturday;
import com.cs.blogger.Fragments.timetableCseThursday;
import com.cs.blogger.Fragments.timetableCseTuesday;
import com.cs.blogger.Fragments.timetableCseWednesday;
import com.cs.blogger.R;
import com.google.android.material.tabs.TabLayout;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class Timetable extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ResultsViewPagerAdapter resultsViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_timetable);

        tabLayout = findViewById(R.id.tablayout_timetable);
        viewPager = findViewById(R.id.viewpager_timetable);
        resultsViewPagerAdapter = new ResultsViewPagerAdapter(getSupportFragmentManager());
        // Adding Fragments

        resultsViewPagerAdapter.AddFragment(new timetableCseMonday(),"MON");
        resultsViewPagerAdapter.AddFragment(new timetableCseTuesday(),"TUES");
        resultsViewPagerAdapter.AddFragment(new timetableCseWednesday(),"WED");
        resultsViewPagerAdapter.AddFragment(new timetableCseThursday(),"THUR");
        resultsViewPagerAdapter.AddFragment(new timetableCseFriday(),"FRI");
        resultsViewPagerAdapter.AddFragment(new timetableCseSaturday(),"SAT");


        viewPager.setAdapter(resultsViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}

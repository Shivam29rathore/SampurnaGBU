package com.cs.blogger.Activities.Results;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.Results.ResultsViewPagerAdapter;
import com.cs.blogger.Fragments.SobResults;
import com.cs.blogger.Fragments.SoeResults;
import com.cs.blogger.Fragments.SoictResults;
import com.cs.blogger.Fragments.SomResults;
import com.cs.blogger.R;
import com.google.android.material.tabs.TabLayout;

public class Results extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ResultsViewPagerAdapter resultsViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_results);

        tabLayout = findViewById(R.id.tablayout_results);
        viewPager = findViewById(R.id.viewpager_results);
        resultsViewPagerAdapter = new ResultsViewPagerAdapter(getSupportFragmentManager());
        // Adding Fragments

        resultsViewPagerAdapter.AddFragment(new SoictResults(),"SOICT");
        resultsViewPagerAdapter.AddFragment(new SoeResults(),"SOE");
        resultsViewPagerAdapter.AddFragment(new SobResults(),"SOICT");
        resultsViewPagerAdapter.AddFragment(new SomResults(),"SOM");


        viewPager.setAdapter(resultsViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}

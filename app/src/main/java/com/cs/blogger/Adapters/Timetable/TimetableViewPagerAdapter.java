package com.cs.blogger.Adapters.Timetable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimetableViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragments = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();


    public TimetableViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragments.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles.get(position);
    }


    public void AddFragment(Fragment fragment,String title)
    {
        lstFragments.add(fragment);
        lstTitles.add(title);
    }
}

package com.cs.blogger.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Adapters.Timetable.SoictCse4thtimetableRecylerAdapter;
import com.cs.blogger.Model.TimetableHelper;
import com.cs.blogger.R;

import java.util.ArrayList;
import java.util.List;

/*
Created by Shivam Singh Rathore
25/05/2020
 */

public class timetableCseMonday extends Fragment {

    private RecyclerView timetable_monday_cse4th_recylerview;
    private ArrayList<TimetableHelper> montimetable;



    View v;

    public timetableCseMonday(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.timetable_cse_monday_fragment,container,false);

        timetable_monday_cse4th_recylerview = v.findViewById(R.id.recyclerview_timetable_cse_monday);
        SoictCse4thtimetableRecylerAdapter recylerAdapter = new SoictCse4thtimetableRecylerAdapter(getContext(),montimetable);
        timetable_monday_cse4th_recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        timetable_monday_cse4th_recylerview.setAdapter(recylerAdapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        montimetable = new ArrayList<>();
        montimetable.add(new TimetableHelper("SoftComputing Techniques","Dr. Anurag Singh Baghel","10-11 am","IL205"));
        montimetable.add(new TimetableHelper("Simulation and Modelling","Dr. Archana Sharma","11-12 noon","IL204"));
        montimetable.add(new TimetableHelper("Knowledge Engineering","Mr.Kishan Punia","12-1 pm","IL202"));
        montimetable.add(new TimetableHelper("Machine Translation and Learning","Mr. Vipin Rai","2-3 pm","IL204"));
        montimetable.add(new TimetableHelper("Introduction to Embedded system","Mr. Jatin Kakran","3-4 pm","IL201"));
    }
}

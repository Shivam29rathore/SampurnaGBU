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

import com.cs.blogger.Adapters.Results.soictResultsAdapter;
import com.cs.blogger.Model.ResultsHelper;
import com.cs.blogger.Model.TimetableHelper;
import com.cs.blogger.R;

import java.util.ArrayList;
import java.util.Date;

/*
Created by Shivam Singh Rathore
25/05/2020
 */

public class SoictResults extends Fragment {

    private RecyclerView results_soict_recylerview;
    private ArrayList<ResultsHelper> results_soict;

    View v;

    public SoictResults(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.result_soict_fragment,container,false);

        results_soict_recylerview = v.findViewById(R.id.recycler_result_soict);
        soictResultsAdapter recyleradapter = new soictResultsAdapter(results_soict, getContext());
      results_soict_recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        results_soict_recylerview.setAdapter(recyleradapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        results_soict = new ArrayList<>();
        results_soict.add(new ResultsHelper("Midterm Results","Results for CSE declared","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));
        results_soict.add(new ResultsHelper("EndTerm Results","Results for ECE declared","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));

    }
}

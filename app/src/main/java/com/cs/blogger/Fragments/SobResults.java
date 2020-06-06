package com.cs.blogger.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cs.blogger.R;

/*
Created by Shivam Singh Rathore
25/05/2020
 */

public class SobResults extends Fragment {

    View v;
    public SobResults(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.result_sob_fragment,container,false);
        return v;
    }





}

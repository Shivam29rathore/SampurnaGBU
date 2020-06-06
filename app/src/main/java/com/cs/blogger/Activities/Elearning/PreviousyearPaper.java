package com.cs.blogger.Activities.Elearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.NoticeBoard.NoticeboardViewAllAdapter;
import com.cs.blogger.Adapters.eLearning.previousyearPapersAdapter;
import com.cs.blogger.Model.Noticeboard;
import com.cs.blogger.Model.eLearningHelper;
import com.cs.blogger.R;

import java.util.ArrayList;

public class PreviousyearPaper extends AppCompatActivity {

    RecyclerView papersRecyler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_previousyear_paper);

        papersRecyler = findViewById(R.id.recylerview_previousyearpaper);

        papersRecyler.setHasFixedSize(true);
        papersRecyler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final ArrayList<eLearningHelper> paperlist = new ArrayList<>();

        paperlist.add(new eLearningHelper("SoftComputing","2019 papers","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));
        paperlist.add(new eLearningHelper("Machine Translation","2018 papers","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));
        paperlist.add(new eLearningHelper("Knowlege Engineering","2017 papers","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));
        paperlist.add(new eLearningHelper("Engineering Mathematics","2016 papers","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));
        paperlist.add(new eLearningHelper("Operations Research","2005 papers","https://firebasestorage.googleapis.com/v0/b/fir-5e25b.appspot.com/o/Results%2FSOICT?alt=media&token=76aa120a-dad3-403d-93d3-6df7f4a6b8ce"));
        adapter = new previousyearPapersAdapter(paperlist,getApplicationContext());
        papersRecyler.setAdapter(adapter);


    }


}
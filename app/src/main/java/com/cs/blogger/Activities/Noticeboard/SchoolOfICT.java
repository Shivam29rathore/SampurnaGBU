package com.cs.blogger.Activities.Noticeboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.NoticeBoard.ICTDeadlinesAdapter;
import com.cs.blogger.Adapters.NoticeBoard.ICTannouncementsAdapter;
import com.cs.blogger.Adapters.NoticeBoard.ICTupcomingAdapter;
import com.cs.blogger.Model.NoticeBoardICt;
import com.cs.blogger.R;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class SchoolOfICT extends AppCompatActivity {

    RecyclerView upcomingRecycler,announcementsRecycler,deadlineRecyler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_school_of_i_c_t);

        upcomingRecycler = findViewById(R.id.recycler_notice_ict_upcomingevents);
        announcementsRecycler = findViewById(R.id.recycler_notice_ict_Announcements);
        deadlineRecyler = findViewById(R.id.recycler_notice_ict_Deadlines);


        upcomingRecyclerview();
        deadlineRecylerView();
        announcementsRecyclerView();
    }

    private void upcomingRecyclerview() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});


        ArrayList<NoticeBoardICt> upcomingevents = new ArrayList<>();
        upcomingevents.add(new NoticeBoardICt("Workshop on Python","Interested students can join at IL 202 tomorrow at 4pm.", gradient1));
        upcomingevents.add(new NoticeBoardICt("Webinar on AI","Interested students can join at IL 201 (22/05/20) at 4pm", gradient2));
        upcomingevents.add(new NoticeBoardICt("Student councilling ","A councilling session will be orgranised in the conference hall today" ,gradient4));
        upcomingevents.add(new NoticeBoardICt("Workshop on Java","Inform CRs if interested", gradient5));




        upcomingRecycler.setHasFixedSize(true);
        adapter = new ICTupcomingAdapter(this, upcomingevents);
        upcomingRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        upcomingRecycler.setAdapter(adapter);


    }

    private void deadlineRecylerView() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});


        ArrayList<NoticeBoardICt> deadlines = new ArrayList<>();
        deadlines.add(new NoticeBoardICt("Major Project Evaluaution","Last Date of Submission of PPT,Report is 26/05/20 ", gradient1));
        deadlines.add(new NoticeBoardICt("Internals","Last Date of Internals Submission is 15/05/2020", gradient2));
        deadlines.add(new NoticeBoardICt("Councilling ","Last Date of councilling is 28/05/2020" ,gradient4));
        deadlines.add(new NoticeBoardICt("Seminar","Last date of seminar report submission is 30/05/2020", gradient5));




        deadlineRecyler.setHasFixedSize(true);
        adapter = new ICTDeadlinesAdapter(this, deadlines);
        deadlineRecyler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        deadlineRecyler.setAdapter(adapter);


    }

    private void announcementsRecyclerView() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});


        ArrayList<NoticeBoardICt> annoucements = new ArrayList<>();
        annoucements.add(new NoticeBoardICt("Project Evaluaution","Last Date of Submission of PPT,Report is 26/05/20 ", gradient1));
        annoucements.add(new NoticeBoardICt("Internals","Last Date of Internals Submission is 15/05/2020", gradient2));
        annoucements.add(new NoticeBoardICt("Councilling ","Last Date of councilling is 28/05/2020" ,gradient4));
        annoucements.add(new NoticeBoardICt("Seminar","Last date of seminar report submission is 30/05/2020", gradient5));




        deadlineRecyler.setHasFixedSize(true);
        adapter = new ICTannouncementsAdapter(this, annoucements);
        announcementsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        announcementsRecycler.setAdapter(adapter);


    }



}


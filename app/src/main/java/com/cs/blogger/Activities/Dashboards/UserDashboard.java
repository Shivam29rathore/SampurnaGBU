package com.cs.blogger.Activities.Dashboards;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Activities.Categories.CategoriesViewAll;
import com.cs.blogger.Activities.Courses.CoursesStructure;
import com.cs.blogger.Activities.Grievances.Grievances;
import com.cs.blogger.Activities.Internals.Internals;
import com.cs.blogger.Activities.Login.Login;
import com.cs.blogger.Activities.Noticeboard.NoticeboardViewAll;
import com.cs.blogger.Activities.Timetables.DepartmentsTimetable;
import com.cs.blogger.Activities.Timetables.Timetable;
import com.cs.blogger.Adapters.Categories.CategoriesAdapter;
import com.cs.blogger.Adapters.Categories.MostViewedAdpater;
import com.cs.blogger.Adapters.Categories.NoticeboardAdapter;
import com.cs.blogger.Model.Categories;
import com.cs.blogger.Model.MostViewed;
import com.cs.blogger.Model.Noticeboard;
import com.cs.blogger.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 */

public class UserDashboard extends AppCompatActivity {

    RecyclerView noticeboardRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;
    private FirebaseAuth mAuth;
    private FirebaseUser mUSer;
    private AlertDialog.Builder alertDialog;
    private ImageView signout;
    private ImageView courses, timetable, internals, grievance;
    private TextView viewall_cat,noticeboard_viewall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        noticeboardRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        signout = findViewById(R.id.signout);
        courses = findViewById(R.id.courses_btn);
        timetable = findViewById(R.id.timetables_btn);
        internals = findViewById(R.id.internals_btn);
        grievance = findViewById(R.id.grievances_btn);
        viewall_cat = findViewById(R.id.viewall_categories);
        noticeboard_viewall = findViewById(R.id.notice_board_viewall);

        noticeboard_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NoticeboardViewAll.class));
            }
        });

        viewall_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CategoriesViewAll.class));
            }
        });




        // Getting current user
        mAuth = FirebaseAuth.getInstance();
        mUSer = mAuth.getCurrentUser();

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show the Actual Alert Dialog
                alertDialog = new AlertDialog.Builder(UserDashboard.this);

                // Adding title of AlertDialog

                alertDialog.setTitle(getResources().getString(R.string.ttile));

                // Adding message to AlertDialog

                alertDialog.setMessage(getResources().getString(R.string.message));


                //Setting negation condition

                alertDialog.setCancelable(false);

                //Setting positive condition

                alertDialog.setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (mUSer != null && mAuth != null) {
                                    mAuth.signOut();
                                    startActivity(new Intent(getApplicationContext(), Login.class));
                                    finish();


                                }


                            }
                        });


                // Setting negative condition

                alertDialog.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                // Creating actual Dialog

                AlertDialog dialog = alertDialog.create();

                // Showing dialog

                dialog.show();


            }
        });

        internals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Internals.class));
            }
        });

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CoursesStructure.class));
            }
        });


        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DepartmentsTimetable.class));
            }
        });

        grievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Grievances.class));
            }
        });


        //Functions will be executed automatically when this activity will be created
        noticeBoardRecycler();
        mostViewedRecycler();
        categoriesRecycler();

    }

    private void categoriesRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});


        ArrayList<Categories> categories = new ArrayList<>();
        categories.add(new Categories(gradient1, R.drawable.school_image, "E-Learning"));
        categories.add(new Categories(gradient2, R.drawable.hospital_image, "Emergency Services"));
        categories.add(new Categories(gradient3, R.drawable.restaurant_image, "Eatery"));
        categories.add(new Categories(gradient1, R.drawable.transport_image, "Conveyance"));
        categories.add(new Categories(gradient5, R.drawable.results, "Results"));


        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(this, categories);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewed> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewed(R.drawable.soe, "School of Engineering"));
        mostViewedLocations.add(new MostViewed(R.drawable.sobiotech, "School of Law and Justice"));
        mostViewedLocations.add(new MostViewed(R.drawable.soict, "School of ICT"));
        mostViewedLocations.add(new MostViewed(R.drawable.somanagement, "School of Managment"));

        adapter = new MostViewedAdpater(mostViewedLocations, this);
        mostViewedRecycler.setAdapter(adapter);

    }

    private void noticeBoardRecycler() {

        noticeboardRecycler.setHasFixedSize(true);
        noticeboardRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<Noticeboard> noticeboardArrayList = new ArrayList<>();

        noticeboardArrayList.add(new Noticeboard(R.drawable.soict, "School of ICT", "No of Notices: \nPhone: 0120 234 4200 "));
        noticeboardArrayList.add(new Noticeboard(R.drawable.soe, "School of Engineering", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.somanagement, "School of Management", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.sobiotech, "School of Biotechnology", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.solaw, "School of Law and Justice", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.sovocational, "School of Vocational studies", "No of Notices:\nPhone: 0120 234 4200"));

        adapter = new NoticeboardAdapter(noticeboardArrayList, this);
        noticeboardRecycler.setAdapter(adapter);


    }



}


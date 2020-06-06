package com.cs.blogger.Activities.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.cs.blogger.Activities.Courses.CoursesStructure;
import com.cs.blogger.Activities.Dashboards.UserDashboard;
import com.cs.blogger.Activities.Elearning.Elearning;
import com.cs.blogger.Activities.Grievances.Grievances;
import com.cs.blogger.Activities.Internals.Internals;
import com.cs.blogger.Activities.Noticeboard.NoticeboardViewAll;
import com.cs.blogger.Activities.Results.Results;
import com.cs.blogger.R;

public class CategoriesViewAll extends AppCompatActivity {

    public Button emergencyServices_expandall,eatery_expandall,grievances_expandall,conveyance_expandall,
            elearning_expandall,results_expandall,internals_expandall,noticeboard_expandall,coursestructure;

    private ImageView backpresser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_view_all);

        emergencyServices_expandall = findViewById(R.id.expandall_emergencyservices);
        eatery_expandall = findViewById(R.id.expandall_eatery);
        grievances_expandall = findViewById(R.id.expandall_grievances);
        conveyance_expandall = findViewById(R.id.expandall_conveyance);
        elearning_expandall = findViewById(R.id.expandall_elearning);
        results_expandall = findViewById(R.id.expandall_results);
        internals_expandall = findViewById(R.id.expandall_internals);
        noticeboard_expandall = findViewById(R.id.expandall_noticeboard);
        coursestructure = findViewById(R.id.expandall_coursestructure);
        backpresser = findViewById(R.id.back_presser_catviewall);

        emergencyServices_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EmergencyServices.class));


            }
        });

        eatery_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Eatery.class));


            }
        });

        grievances_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Grievances.class));


            }
        });

        conveyance_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ConvenceInCampus.class));

            }
        });

        elearning_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Elearning.class));

            }
        });

        results_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Results.class));

            }
        });



        internals_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Internals.class));

            }
        });

        noticeboard_expandall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NoticeboardViewAll.class));

            }
        });


        coursestructure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CoursesStructure.class));

            }
        });


        backpresser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));

            }
        });





    }
}

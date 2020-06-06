package com.cs.blogger.Activities.Timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cs.blogger.R;

public class DepartmentsTimetable extends AppCompatActivity {

    private TextView soict_timetable_cse4th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_departments_timetable);

        soict_timetable_cse4th = findViewById(R.id.timtable_Soict_cse4th);

        soict_timetable_cse4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Timetable.class));
            }
        });
    }
}
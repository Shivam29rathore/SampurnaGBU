package com.cs.blogger.Activities.Grievances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cs.blogger.R;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */


public class Grievances extends AppCompatActivity {

    ImageView hostel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_grievances);

        hostel= findViewById(R.id.grievances_hostel);

        hostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddGrievances.class));
            }
        });
    }
}

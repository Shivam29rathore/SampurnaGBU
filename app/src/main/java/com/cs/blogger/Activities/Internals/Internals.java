package com.cs.blogger.Activities.Internals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.cs.blogger.Activities.Courses.CoursesStructure;
import com.cs.blogger.Activities.Dashboards.AddPostActivity;
import com.cs.blogger.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */


public class Internals extends AppCompatActivity {

    private TextInputLayout course,branch,rollno;
    private Button addfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_internals);

        //Hooks
        addfile = findViewById(R.id.add_file);
        course = findViewById(R.id.text_input_course);
        branch = findViewById(R.id.text_input_branch);
        rollno = findViewById(R.id.text_input_rollno);


        addfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UploadInternals.class));
            }
        });



    }


}

package com.cs.blogger.Activities.Noticeboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.R;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class SchoolOfEngineering extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_school_of_engineering);
    }
}

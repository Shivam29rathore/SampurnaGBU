package com.cs.blogger.Activities.Elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cs.blogger.R;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */


public class Elearning extends AppCompatActivity {

    private TextView ebooks,previousyearpapers,enotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_elearning);

        previousyearpapers = findViewById(R.id.previous_year_papers);
        ebooks = findViewById(R.id.ebooks);
        enotes = findViewById(R.id.eNotes);


        previousyearpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PreviousyearPaper.class));
            }
        });


        ebooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),eBooks.class));
            }
        });

        enotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),eNotes.class));
            }
        });


    }
}

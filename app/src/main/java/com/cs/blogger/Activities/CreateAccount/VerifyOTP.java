package com.cs.blogger.Activities.CreateAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import com.chaos.view.PinView;
import com.cs.blogger.R;

public class VerifyOTP extends AppCompatActivity {

    PinView pinView;
    Button verify;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);

        pinView = findViewById(R.id.pinview_verify);
        verify = findViewById(R.id.verify_otp_btn);
        progressBar = findViewById(R.id.progressBar_verifyphoneno);
        



    }
}
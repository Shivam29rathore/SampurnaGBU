package com.cs.blogger.Activities.CreateAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.cs.blogger.Activities.Dashboards.UserDashboard;
import com.cs.blogger.Activities.Login.Login;
import com.cs.blogger.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class VerifyOTP extends AppCompatActivity {

    String verificationCodebySystem;
    PinView pinView;
    Button verifybtn;
    ProgressBar progressBar;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);

        pinView = findViewById(R.id.pinview_verify);
        verifybtn = findViewById(R.id.verify_otp_btn);
        progressBar = findViewById(R.id.progressBar_verifyphoneno);


        //Database initialisation (Firebase)
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();



        String phoneNo = getIntent().getStringExtra("phoneNo");
        String emailID = getIntent().getStringExtra("emailId");
        String username = getIntent().getStringExtra("username");
        String fullname = getIntent().getStringExtra("fullname");
        String password = getIntent().getStringExtra("password");

        sendVerificationCodetoUser(phoneNo);

        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code = pinView.getText().toString();

                if (code.isEmpty() || code.length() < 6) {
                    pinView.setError("Wrong OTP...");
                    pinView.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }
        });


    }

    private void sendVerificationCodetoUser(String phoneNo) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + phoneNo,        // Phone number to verify and Adding Indian country code.
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD, // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        //This function will execute everytime, it is for the manual entry of the code.
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationCodebySystem = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            // This method is for automatic entry of code.
            String code = phoneAuthCredential.getSmsCode();

            if (code != null) {

                pinView.setText(code);
                progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }

        }



        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    private void signInUserByCredentials(PhoneAuthCredential credential) {

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(VerifyOTP.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "Account created successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(VerifyOTP.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void verifyCode(String codeByuser) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCodebySystem, codeByuser);
        signInUserByCredentials(credential);

    }


}
package com.cs.blogger.Activities.Login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cs.blogger.Activities.CreateAccount.CreateAccount;
import com.cs.blogger.Activities.Dashboards.UserDashboard;
import com.cs.blogger.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Shivam Singh Rathore on 10/05/20
 *
 */

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser muser;
    private Button loginButton;
    private TextInputLayout emailfield;
    private TextInputLayout passwordField;
    private Button createButton;
    private ImageView image;
    private TextView logoText;
    private TextView SloganText;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        //UI design connection

        loginButton = findViewById(R.id.loginbutton);
        createButton = findViewById(R.id.create_account);
        emailfield = findViewById(R.id.text_input_email);
        passwordField = findViewById(R.id.text_input_password);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        SloganText = findViewById(R.id.slogan_name);
        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);


        // Login Authantication via Email and password

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                muser = firebaseAuth.getCurrentUser();
                if(muser != null){
                    startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                    finish();
                }

            }
        };

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateEmailId() | !validatePassword()) {
                    return;
                }

                mProgressBar.setVisibility(View.VISIBLE);
                String userEnteredEmail = emailfield.getEditText().getText().toString().trim();
                String userEnteredPassword = passwordField.getEditText().getText().toString().trim();

                login(userEnteredEmail, userEnteredPassword);


            }
        });


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, CreateAccount.class);

                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoText, "logo_text");
                pairs[2] = new Pair<View, String>(SloganText, "logo_desc");
                pairs[3] = new Pair<View, String>(emailfield, "logo_email");
                pairs[4] = new Pair<View, String>(passwordField, "password_tran");
                pairs[5] = new Pair<View, String>(loginButton, "go_tran");
                pairs[6] = new Pair<View, String>(createButton, "login_createAccount_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());


                }


            }
        });


    }



    private Boolean validateEmailId() {

        String val = emailfield.getEditText().getText().toString();


        if (val.isEmpty()) {
            emailfield.setError("Field can't be empty");
            return false;
        } else {
            emailfield.setError(null);
            emailfield.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePassword() {

        String val = passwordField.getEditText().getText().toString();

        if (val.isEmpty()) {
            passwordField.setError("Field can't be empty");
            return false;
        } else {
            passwordField.setError(null);
            passwordField.setErrorEnabled(false);
            return true;
        }

    }


    private void login(String emailID, String pwd) {


        mAuth.signInWithEmailAndPassword(emailID, pwd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            mProgressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                            finish();
                        } else {
                            Toast.makeText(Login.this,"Invalid  credentials", Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }

                    }
                });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    // To avoid users to enter into a loop of reauthanication
    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}


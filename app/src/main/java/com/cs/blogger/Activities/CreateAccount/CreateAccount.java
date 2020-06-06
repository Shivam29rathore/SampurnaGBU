package com.cs.blogger.Activities.CreateAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.cs.blogger.Model.Users;
import com.cs.blogger.Activities.Login.Login;
import com.cs.blogger.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class CreateAccount extends AppCompatActivity {

    private Button createAccount, backTologin;
    private TextInputLayout emailField, Fullname, Username, Phoneno, passwordField;
    private ImageView image;
    private TextView logoName, SloganName;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private ProgressBar mProgressbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_account);

        image = findViewById(R.id.logo_imageC);
        logoName = findViewById(R.id.logo_nameC);
        SloganName = findViewById(R.id.slogan_nameC);
        emailField = findViewById(R.id.text_input_emailC);
        passwordField = findViewById(R.id.text_input_passwordC);
        Fullname = findViewById(R.id.full_name);
        Username = findViewById(R.id.userName);
        Phoneno = findViewById(R.id.phoneNo);
        backTologin = findViewById(R.id.back_to_login);
        createAccount = findViewById(R.id.createAccountC);
        mProgressbar = findViewById(R.id.progressbar3);

        //Database initialisation (Firebase)
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();


        backTologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CreateAccount.this, Login.class);


                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(logoName, "logo_text");
                pairs[2] = new Pair<View, String>(SloganName, "logo_desc");
                pairs[3] = new Pair<View, String>(Username, "logo_username");
                pairs[4] = new Pair<View, String>(passwordField, "password_tran");
                pairs[5] = new Pair<View, String>(backTologin, "go_tran");
                pairs[6] = new Pair<View, String>(createAccount, "login_createAccount_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(CreateAccount.this, pairs);
                    startActivity(intent, options.toBundle());


                }

            }
        });


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailString = emailField.getEditText().getText().toString();
                final String pwd = passwordField.getEditText().getText().toString();
                final String username = Username.getEditText().getText().toString();
                final String fullname = Fullname.getEditText().getText().toString();
                final String phoneNo = Phoneno.getEditText().getText().toString();

                if (!validateName() | !validatePassword() | !validatePhoneno() | !validateEmail() | !validateUsername()) {
                    return;
                }

                mProgressbar.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(emailString, pwd)
                        .addOnCompleteListener(CreateAccount.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                    Toast.makeText(CreateAccount.this, "Account creation failed!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(CreateAccount.this, "Account created!", Toast.LENGTH_SHORT).show();

                                    mProgressbar.setVisibility(View.GONE);
                                    // Saving Data to Firebase / Writing to DB
                                    Users users = new Users(fullname, username, emailString, pwd, phoneNo);
                                    databaseReference.child(username).setValue(users);

                                    //Send users to Login Screen
                                    startActivity(new Intent(getApplicationContext(),Login.class));
                                    finish();


                                }
                            }
                        });


            }
        });
    }


    private Boolean validateName() {

        String val = Fullname.getEditText().getText().toString();

        if (val.isEmpty()) {
            Fullname.setError("Field can't be empty");
            return false;
        } else {
            Fullname.setError(null);
            Fullname.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateUsername() {

        String val = Username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            Username.setError("Field can't be empty");
            return false;
        } else if (val.length() >= 15) {
            Username.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            Username.setError("White spaces not allowed");
            return false;
        } else {
            Username.setError(null);
            Username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {

        String val = emailField.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            emailField.setError("Field can't be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            emailField.setError("Invalid EmailID");
            return false;
        } else {
            emailField.setError(null);
            emailField.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePhoneno() {

        String val = Phoneno.getEditText().getText().toString();

        if (val.isEmpty()) {
            Phoneno.setError("Field can't be empty");
            return false;
        } else {
            Phoneno.setError(null);
            Phoneno.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePassword() {

        String val = passwordField.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            passwordField.setError("Field can't be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            passwordField.setError("Password too weak");
            return false;
        } else {
            passwordField.setError(null);
            passwordField.setErrorEnabled(false);
            return true;
        }

    }


}


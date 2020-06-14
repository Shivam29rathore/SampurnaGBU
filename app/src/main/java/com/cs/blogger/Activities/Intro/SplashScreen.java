package com.cs.blogger.Activities.Intro;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cs.blogger.Activities.Login.Login;
import com.cs.blogger.R;

/**
 * Created by Shivam Singh Rathore on 10/05/20
 *
 */
public class SplashScreen extends AppCompatActivity {

    private static int PROGRESS_TIME= 2000;
    private static int SPLASH_SCREEN = 5000;
    SharedPreferences sliderIntro;
    ProgressBar mprogressbar;

    //Variables

    Animation topanim, bottomanim;
    ImageView icon;
    TextView logo,slogan,poweredSlogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding status bar/Notification Area
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Animation

        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);


        //Hooks

        icon = findViewById(R.id.iconImageview);
        logo = findViewById(R.id.logotv);
        slogan = findViewById(R.id.slogantv);
        poweredSlogan = findViewById(R.id.powered);
        mprogressbar = findViewById(R.id.progressBarSplash);
        mprogressbar.setVisibility(View.INVISIBLE);

        icon.setAnimation(topanim);
        logo.setAnimation(bottomanim);
        slogan.setAnimation(bottomanim);
        poweredSlogan.setAnimation(bottomanim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sliderIntro = getSharedPreferences("sliderIntro", MODE_PRIVATE);
                boolean isFirstTime = sliderIntro.getBoolean("firstTime", true);

                if (isFirstTime) {

                    SharedPreferences.Editor editor = sliderIntro.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(SplashScreen.this, SliderIntro.class);
                    startActivity(intent);
                    finish();

                } else {

                    Intent intent = new Intent(SplashScreen.this, Login.class);

                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View, String>(icon, "logo_image");
                    pairs[1] = new Pair<View, String>(logo, "logo_text");

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                        startActivity(intent, options.toBundle());



                    }


                }

            }
        }, SPLASH_SCREEN);


        // Task to display the ProgressBar
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mprogressbar.setVisibility(View.VISIBLE);


            }


        }, PROGRESS_TIME);



    }


}

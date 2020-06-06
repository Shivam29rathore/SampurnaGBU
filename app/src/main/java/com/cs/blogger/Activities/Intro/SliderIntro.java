package com.cs.blogger.Activities.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cs.blogger.Adapters.IntroSlider.SliderAdapter;
import com.cs.blogger.Activities.Login.Login;
import com.cs.blogger.R;
/**
 * Created by Shivam Singh Rathore on 10/05/20
 *
 */

public class SliderIntro extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted;
    Animation animation;
    int currentpos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding status bar/Notification Area
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slider_intro);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);

        //Call Adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);




    }


    private void addDots(int position){

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0; i<dots.length ; i++){

            dots[i]  =new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);

        }

        if(dots.length > 0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));

        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentpos = position;

            if(position == 0){
                letsGetStarted.setVisibility(View.INVISIBLE);

            }

            else if (position == 1){
                letsGetStarted.setVisibility(View.INVISIBLE);

            }

            else if(position ==2){
                letsGetStarted.setVisibility(View.INVISIBLE);

            }

            else{

                animation = AnimationUtils.loadAnimation(SliderIntro.this,R.anim.bottom_animation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);

            }



        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    public void skip(View view){
        startActivity(new Intent(this, Login.class));
        finish();
    }


    public void next(View view){

        viewPager.setCurrentItem(currentpos +1 );

    }

    public void movetoLogin(View view){

        startActivity(new Intent(this,Login.class));
        finish();
    }

}

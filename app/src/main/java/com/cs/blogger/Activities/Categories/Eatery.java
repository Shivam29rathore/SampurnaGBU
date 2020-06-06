package com.cs.blogger.Activities.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.Categories.CategoriesAdapter;
import com.cs.blogger.Adapters.Categories.ConveyanceAdapter;
import com.cs.blogger.Model.Categories;
import com.cs.blogger.R;

import java.util.ArrayList;

public class Eatery extends AppCompatActivity {

    RecyclerView eateryRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_eatery);


        eateryRecycler = findViewById(R.id.recycler_eatery);
        eateryRecycler();
    }

    private void eateryRecycler() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});


        ArrayList<Categories> eatery = new ArrayList<>();
        eatery.add(new Categories(gradient1, R.drawable.mess, "Mess"));
        eatery.add(new Categories(gradient2, R.drawable.complex, "Complex"));
        eatery.add(new Categories(gradient3, R.drawable.motherdairy, "Mother Dairy"));
        eatery.add(new Categories(gradient4, R.drawable.buddhacafe, "Buddha Cafe"));



        eateryRecycler.setHasFixedSize(true);
        adapter = new ConveyanceAdapter(this, eatery);
        eateryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        eateryRecycler.setAdapter(adapter);


    }
}

package com.cs.blogger.Activities.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.Categories.ConveyanceAdapter;
import com.cs.blogger.Model.Categories;
import com.cs.blogger.R;

import java.util.ArrayList;

public class ConvenceInCampus extends AppCompatActivity {

    RecyclerView conveyanceRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4, gradient5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_convence_in_campus);

        conveyanceRecycler = findViewById(R.id.recycler_conveyance);
        convenceRecyclerview();
    }

    private void convenceRecyclerview() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});
        gradient5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});


        ArrayList<Categories> conveyance= new ArrayList<>();
        conveyance.add(new Categories(gradient1, R.drawable.hexi, "Hexi Cycle"));
        conveyance.add(new Categories(gradient2, R.drawable.eriksaw, "E Rikshaw"));



        conveyanceRecycler.setHasFixedSize(true);
        adapter = new ConveyanceAdapter(this, conveyance);
        conveyanceRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        conveyanceRecycler.setAdapter(adapter);



    }
}

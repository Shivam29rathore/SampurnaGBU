package com.cs.blogger.Activities.Grievances;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Activities.Dashboards.AddPostActivity;
import com.cs.blogger.Activities.Login.Login;
import com.cs.blogger.Adapters.BlogRecylerAdapter;
import com.cs.blogger.Model.Blog;
import com.cs.blogger.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shivam Singh Rathore on 14/05/20
 *
 */


public class ViewGrievances extends AppCompatActivity {







    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUSer;
    private RecyclerView recyclerView;
    private BlogRecylerAdapter blogRecylerAdapter;
    private List<Blog> blogList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_post_list);


        //Creating Database
        mDatabase = FirebaseDatabase.getInstance();
        // Creating a separating DB  type scenerio : Blog
        mDatabaseReference = mDatabase.getReference().child("Internals");
        // While using the App we want database to be continously syncrnised in realtime.
        mDatabaseReference.keepSynced(true);

        // Getting current user
        mAuth = FirebaseAuth.getInstance();
        mUSer = mAuth.getCurrentUser();

        //Initialising the list
        blogList=new ArrayList<>();
        //Intialising the recyler view.
        recyclerView=findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                if (mUSer != null && mAuth != null) {
                    startActivity(new Intent(ViewGrievances.this, AddPostActivity.class));
                    finish();
                }
                break;

            case R.id.action_signout:
                if(mUSer != null && mAuth !=null){
                    mAuth.signOut();
                    startActivity(new Intent(ViewGrievances.this, Login.class));
                    finish();
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The reason why we want to code here is that we want that activity is ready in background when called in Oncreate activity.
   mDatabaseReference.addChildEventListener(new ChildEventListener() {
       @Override
       public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
           // Initialising the model
           // When child is added what to do:
           Blog blog= dataSnapshot.getValue(Blog.class);

           blogList.add(blog);
           Collections.reverse(blogList);

           blogRecylerAdapter= new BlogRecylerAdapter(ViewGrievances.this,blogList);
           recyclerView.setAdapter(blogRecylerAdapter);
           blogRecylerAdapter.notifyDataSetChanged();



       }

       @Override
       public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

       }

       @Override
       public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

       }

       @Override
       public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
   });

    }
}


package com.cs.blogger.Activities.Noticeboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.cs.blogger.Activities.Dashboards.PostListActivity;
import com.cs.blogger.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class AddNotices extends AppCompatActivity {

    public ImageButton mPostimage;
    private EditText mPostTitle;
    private EditText mPostDesc;
    private Button msubmitButton;
    private StorageReference mStorage;
    private StorageTask mStorageTask;

    // Unique Resource Identifier : which will store the clear path for the Image
    private Uri mImageuri;

    private DatabaseReference mPostDatabaseRef;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private static final int GALLERY_CODE = 1;

    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_post);
        // Using the ProcessDialog
        mProgressBar = findViewById(R.id.progressBar2);

        mPostimage = findViewById(R.id.addImageButton);
        mPostTitle = findViewById(R.id.postTitle);
        mPostDesc = findViewById(R.id.postDescription);
        msubmitButton = findViewById(R.id.submitPostBt);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mStorage = FirebaseStorage.getInstance().getReference();

        mPostimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                // TO get all types of Image.progressBar
                galleryIntent.setType("*/*");
                startActivityForResult(galleryIntent, GALLERY_CODE);

            }
        });

        mPostDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Internals");

        msubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mStorageTask != null && mStorageTask.isInProgress()) {
                    Toast.makeText(AddNotices.this, "Upload in Progress!", Toast.LENGTH_SHORT).show();

                } else {
                    startPosting();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {


            mImageuri = data.getData();

            Picasso.get().load(mImageuri).fit().into(mPostimage);// 'fit()' resizes the Image according to the size of the ImageView
            //  mPostimage.setImageURI(mImageuri); (Didn't worked)


        }
    }

    private void startPosting() {


        final String titleVal = mPostTitle.getText().toString().trim();
        final String descVal = mPostDesc.getText().toString().trim();

        if (!TextUtils.isEmpty(titleVal) && !TextUtils.isEmpty(descVal)
                && mImageuri != null) {
            //start the uploading...
            //mImageUri.getLastPathSegment() == /image/myphoto.jpeg"

            final StorageReference filepath = mStorage.child("Internals_Files").child(mImageuri.getLastPathSegment());

            mStorageTask = filepath.putFile(mImageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Task<Uri> result = taskSnapshot.getMetadata().getReference().getDownloadUrl();

                    result.addOnSuccessListener(new OnSuccessListener<Uri>() {

                        @Override
                        public void onSuccess(Uri uri) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(0);

                                }
                            }, 500);


                            String link = uri.toString();

                            DatabaseReference newPost = mPostDatabaseRef.push();

                            Map<String, String> dataToSave = new HashMap<>();
                            dataToSave.put("title", titleVal);
                            dataToSave.put("desc", descVal);
                            dataToSave.put("image", link);
                            dataToSave.put("timestamp", String.valueOf(System.currentTimeMillis()));
                            dataToSave.put("userid", mUser.getUid());
                            dataToSave.put("username", mUser.getEmail());

                            newPost.setValue(dataToSave);

                            Toast.makeText(AddNotices.this, "Upload Successful!", Toast.LENGTH_SHORT).show();


                           startActivity(new Intent(AddNotices.this, PostListActivity.class));
                            finish();

                        }
                    });


                }
            })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {

                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar.setProgress((int) progress);

                        }
                    })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(AddNotices.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });


        }
    }


}





package com.cs.blogger.Activities.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cs.blogger.R;

public class EmergencyServices extends AppCompatActivity {

    private ImageView hostelAdminCall, AdminCall, FireservicesCall, HealthservicesCall, SecuritiesCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_emergencyservices);

        hostelAdminCall = findViewById(R.id.call_hostelAdmin);
        AdminCall = findViewById(R.id.call_admin);
        FireservicesCall = findViewById(R.id.call_Fireservices);
        HealthservicesCall = findViewById(R.id.call_healthservices);
        SecuritiesCall = findViewById(R.id.call_securities);


        hostelAdminCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + getString(R.string.hostel_admin_no);
                i.setData(Uri.parse(p));
                startActivity(i);
        }
    });

        FireservicesCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + getString(R.string.fire_services_no);
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });


        AdminCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + getString(R.string.gbu_admin_no);
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

        HealthservicesCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + getString(R.string.health_services_no);
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });

       SecuritiesCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + getString(R.string.Securities_no );
                i.setData(Uri.parse(p));
                startActivity(i);
            }
        });



    }
}

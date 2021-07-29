package com.example.quepee.User.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quepee.R;
import com.example.quepee.User.Model.QuepeeModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class UserMainActivity extends AppCompatActivity {
    SupportMapFragment supportMapFragment;

    FusedLocationProviderClient fusedLocationProviderClient;

    private ImageView imageViewSetting,imageViewPersonalQueepee;

    ArrayList<QuepeeModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        initialize();

        setArray();

        setMap();

        imageViewPersonalQueepee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMainActivity.this,PersonalQueepeeActivity.class));
            }
        });

        imageViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMainActivity.this,SettingUserActivity.class));
            }
        });

    }

    private void setMap() {
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng liveLocation = new LatLng(18.5130266, 73.9397871);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(liveLocation, 15f));

                for (int i = 0; i < arrayList.size(); i++) {
                    LatLng latLng = new LatLng(arrayList.get(i).getLatitude(), arrayList.get(i).getLongitutde());
                    MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(arrayList.get(i).getName());
                    googleMap.addMarker(markerOptions).showInfoWindow();

                    Log.e("arrayList : " + i,arrayList.get(i).getName());
                }
            }
        });
    }

    private void setArray() {
        arrayList.add(new QuepeeModel(18.5130266, 73.9307871, "home 2"));
        arrayList.add(new QuepeeModel(18.5296266, 73.9387871, "House 1"));
        arrayList.add(new QuepeeModel(18.5235266, 73.9332871, "Aspire Home"));
        arrayList.add(new QuepeeModel(18.5090266, 73.9342871, "home"));
        arrayList.add(new QuepeeModel(18.5190266, 73.9346871, "New Quepee"));
        arrayList.add(new QuepeeModel(18.5220266, 73.9344871, "Queepee aspire"));

        // longitude +- 0.08
        // latitude +- 0.01
    }

    private void initialize() {
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_CitizenMapAccountActivity);

        imageViewPersonalQueepee = findViewById(R.id.Iv_UserMainActivity_PersonalQueepee);
        imageViewSetting = findViewById(R.id.Iv_UserMainActivity_Setting);
    }
}


package com.example.doctornearus;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class PatientRequirement extends AppCompatActivity {
    private GoogleMap mMap;
    EditText etl, ets;
    TextView out;
    Button search;
    String a1,a2;

    Double lat11,lon11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_requirement);
        etl = findViewById(R.id.etl);
        ets = findViewById(R.id.ets);
        search = findViewById(R.id.search);


        Geocoder g = new Geocoder(getApplicationContext(), Locale.getDefault());

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a1 = etl.getText().toString();
                a2 = ets.getText().toString();

                List<Address> a = null;
                try {
                    a = g.getFromLocationName(a1, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Address add = a.get(0);
                lat11= add.getLatitude();
                lon11 = add.getLongitude();
                String str2=lon11.toString();
                String str1=lat11.toString();

                Intent i = new Intent(getApplicationContext(), DoctorList.class);
                i.putExtra("lat",str1);
                i.putExtra("lon",str2);
                i.putExtra("sp",a2);
                startActivity(i);

            }
        });


    }
}
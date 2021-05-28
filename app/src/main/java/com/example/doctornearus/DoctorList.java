package com.example.doctornearus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DoctorList extends AppCompatActivity {
    TextView text,doctextlat;
    Double lat1,lon1,lat2,lon2;
    FirebaseDatabase db;
    DatabaseReference ref;


    ListView listview;
    ArrayList<String> arraylist =new ArrayList<>();
    ArrayAdapter<String> arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        text = findViewById(R.id.textlat);
        doctextlat=findViewById(R.id.doctextlat);
        listview=findViewById(R.id.listviewtext);
        arrayadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraylist);
        listview.setAdapter(arrayadapter);

        Geocoder g = new Geocoder(getApplicationContext(), Locale.getDefault());

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("lat");
        String str2 = intent.getStringExtra("lon");
        String str3=intent.getStringExtra("sp");

        lat1=Double.valueOf(str1);
        lon1=Double.valueOf(str2);

        ref=FirebaseDatabase.getInstance().getReference("Doctor");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    String speciality = data.child("speciality").getValue().toString();
                    if (str3.equals(speciality)) {

                        String pl = data.child("presentAddress").getValue().toString();

                        List<Address> b = null;
                        try {
                            b = g.getFromLocationName(pl, 1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Address add1 = b.get(0);
                        lat2 = add1.getLatitude();
                        lon2 = add1.getLongitude();

//                        lon1 = Math.toRadians(lon1);
//                        lon2 = Math.toRadians(lon2);
//                        lat1 = Math.toRadians(lat1);
//                        lat2 = Math.toRadians(lat2);
//
//                        double dlon = lon2 - lon1;
//                        double dlat = lat2 - lat1;
//                        double a = Math.pow(Math.sin(dlat / 2), 2)
//                                + Math.cos(lat1) * Math.cos(lat2)
//                                * Math.pow(Math.sin(dlon / 2), 2);
//
//                        double c = 2 * Math.asin(Math.sqrt(a));
//                        double r = 6378;
//                        double distance = c * r;
//                        Log.d("distance1", String.valueOf(distance));
//                        int distance1= (int) (distance*1000);
//                        Log.d("distance1", String.valueOf(distance1));
 //                      distance= distance1/1000.0;
//                        Log.d("distance1", String.valueOf(distance));

                    Location startPoint=new Location("");
                    startPoint.setLatitude(lat1);
                    startPoint.setLongitude(lon1);

                    Location endPoint=new Location("");
                    endPoint.setLatitude(lat2);
                    endPoint.setLongitude(lon2);

                    double distance=startPoint.distanceTo(endPoint);
                    int distance1= (int) (distance);
                    distance= distance1/1000.0;


                        //Log.d("distance", String.valueOf(distance));
                       // doctextlat.setText("Distance is "+ distance + "km");

                       // DoctorUsers doctor1 = new DoctorUsers(distance);

                        String value = String.valueOf(data.getValue(DoctorUsers.class));

                        arraylist.add(value);
                        arraylist.add("Distance from your location to Doctors location is : "+String.valueOf(distance)+"km"+"\n");
                        arrayadapter.notifyDataSetChanged();
                    }

                }
            }


            @Override
            public void onCancelled(DatabaseError error) {

            }
        });





        // List<Address> b = null;
//                    try {
//                        b = g.getFromLocationName(value, 1);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    Address add = b.get(0);
//                    lat2= add.getLatitude();
//                    lon2 = add.getLongitude();
//
//                    String str1=lat2.toString();
//                    String str2=lon2.toString();
//
//                    Log.d("Lat",str1);


    }


}
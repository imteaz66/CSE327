package com.example.doctornearus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterDoctorActivity extends AppCompatActivity {

    String FullName, EmailAddress, PhoneNumber, PresentAddress, Speciality, BMDC, Password;
    Button reg;

    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
        reg=findViewById(R.id.btnd);
        EditText editText1=findViewById(R.id.editText1d);
        EditText editText2=findViewById(R.id.editText2d);
        EditText editText3=findViewById(R.id.editText3d);
        EditText editText4=findViewById(R.id.editText4d);
        EditText editText5=findViewById(R.id.editText5d);
        EditText editText6=findViewById(R.id.editText6d);
        EditText editText7=findViewById(R.id.editText7d);

        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FullName=editText1.getText().toString();
                EmailAddress=editText2.getText().toString();
                PhoneNumber=editText3.getText().toString();
                PresentAddress=editText4.getText().toString();
                Speciality =editText5.getText().toString();
                BMDC=editText6.getText().toString();
                Password=editText7.getText().toString();
                if(!FullName.isEmpty() && !EmailAddress.isEmpty() && !PhoneNumber.isEmpty() && !PresentAddress.isEmpty() && !Password.isEmpty() && !Speciality.isEmpty() && !BMDC.isEmpty() ) {
                    DoctorUsers doctor = new DoctorUsers(FullName,EmailAddress,PhoneNumber,PresentAddress,Speciality,BMDC,Password);
                    db=FirebaseDatabase.getInstance();
                    ref=db.getReference("Doctor");
                    //ref.push().setValue("dd");
                    ref.child(PhoneNumber).setValue(doctor);
                    Toast.makeText(getBaseContext(), " Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent l = new Intent(getApplicationContext(), LogiDoctor.class);
                    startActivity(l);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Text filled can't be empty, Registration Failed",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
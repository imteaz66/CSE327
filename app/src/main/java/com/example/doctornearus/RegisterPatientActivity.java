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

public class RegisterPatientActivity extends AppCompatActivity {
    String FullName, EmailAddress, PhoneNumber, PresentAddress, Password;
    Button reg;

    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);
        reg=findViewById(R.id.btn1);
        EditText editText1=findViewById(R.id.editText1);
        EditText editText2=findViewById(R.id.editText2);
        EditText editText3=findViewById(R.id.editText3);
        EditText editText4=findViewById(R.id.editText4);
        EditText editText5=findViewById(R.id.editText5);

        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FullName=editText1.getText().toString();
                EmailAddress=editText2.getText().toString();
                PhoneNumber=editText3.getText().toString();
                PresentAddress=editText4.getText().toString();
                Password=editText5.getText().toString();
                if(!FullName.isEmpty() && !EmailAddress.isEmpty() && !PhoneNumber.isEmpty() && !PresentAddress.isEmpty() && !Password.isEmpty()) {
                    PatientUsers patient = new PatientUsers(FullName,EmailAddress,PhoneNumber,PresentAddress,Password);
                    db=FirebaseDatabase.getInstance();
                    ref=db.getReference("patient");
                    //ref.push().setValue("dd");
                    ref.child(PhoneNumber).setValue(patient);
                    Toast.makeText(getBaseContext(), " Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent k = new Intent(getApplicationContext(), LoginPatient.class);
                    startActivity(k);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Text filled can't be empty, Registration Failed",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
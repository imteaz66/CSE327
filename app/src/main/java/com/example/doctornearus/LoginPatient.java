package com.example.doctornearus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginPatient extends AppCompatActivity {
    String phonenumber,password;

    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);
        EditText editTextlph=findViewById(R.id.editTextlph);
        EditText editTextlp=findViewById(R.id.editTextlp);
        Button btnl=findViewById(R.id.btnl);

        //PatientUsers user;

        btnl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phonenumber = editTextlph.getText().toString();
                password = editTextlp.getText().toString();

                ref=FirebaseDatabase.getInstance().getReference("patient");

                ref.child(phonenumber).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(task.isSuccessful())
                        {
                            if(task.getResult().exists()){
                                DataSnapshot data=task.getResult();
                                String pass=data.child("password").getValue().toString();

                                if(password.equals(pass))
                                {
                                    Intent l = new Intent(getApplicationContext(), PatientRequirement.class);
                                    startActivity(l);
                                    Toast.makeText(getApplicationContext(),"Successfully Logged in",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                   Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"User does not register yet",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"failed to read data",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

           }
        });


    }
}
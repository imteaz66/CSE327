package com.example.doctornearus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogiDoctor extends AppCompatActivity {
    String phonenumber,password,bmdc;

    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logi_doctor);
        EditText editTextlph=findViewById(R.id.editTextlphd);
        EditText editTextlp=findViewById(R.id.editTextlpd);
        EditText editTextlbd=findViewById(R.id.editTextlbd);
        Button btnld=findViewById(R.id.btnld);

        //PatientUsers user;

        btnld.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                phonenumber = editTextlph.getText().toString();
                password = editTextlp.getText().toString();
                bmdc=editTextlbd.getText().toString();

                ref=FirebaseDatabase.getInstance().getReference("Doctor");

                ref.child(phonenumber).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(task.isSuccessful())
                        {
                            if(task.getResult().exists()){
                                DataSnapshot data=task.getResult();
                                String pass=data.child("password").getValue().toString();
                                String bm=data.child("bmdc").getValue().toString();

                                if(password.equals(pass) && bmdc.equals(bm))
                                {
                                    Intent j = new Intent(getApplicationContext(), DoctorPage.class);
                                    startActivity(j);
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
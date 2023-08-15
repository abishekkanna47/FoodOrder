package com.example.studentfb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity {
DatabaseReference dr= FirebaseDatabase.getInstance().getReferenceFromUrl("https://studentfb-c33ad-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText e1,e2,e3,e4,e5;
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.ph);
        e3=findViewById(R.id.un2);
        e4=findViewById(R.id.pas2);
        e5=findViewById(R.id.conf);
        Button b1=findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
            }});
        Button b2=findViewById(R.id.reg);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               String n=e1.getText().toString();
               String ph=e2.getText().toString();
                String un=e3.getText().toString();
                String pas=e4.getText().toString();
                String cpas=e5.getText().toString();
                if(n.isEmpty() && ph.isEmpty() && un.isEmpty() && pas.isEmpty() && cpas.isEmpty() )
                    Toast.makeText(signup.this,"Fill all fields",Toast.LENGTH_SHORT).show();
                else if(!pas.equals(cpas))
                Toast.makeText(signup.this,"Passwords doesnt match",Toast.LENGTH_SHORT).show();
else
                {
dr.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if(snapshot.hasChild(n))
            Toast.makeText(signup.this,"User already exists",Toast.LENGTH_SHORT).show();
        else
        {
            dr.child("users").child(n).child("Phone").setValue(ph);
            dr.child("users").child(n).child("Username").setValue(un);
            dr.child("users").child(n).child("Password").setValue(pas);
            Toast.makeText(signup.this,"Registered successfully",Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});





                }

            }});

    }
}
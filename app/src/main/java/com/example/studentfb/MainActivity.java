package com.example.studentfb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    DatabaseReference dr= FirebaseDatabase.getInstance().getReferenceFromUrl("https://studentfb-c33ad-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.log);
        EditText un = findViewById(R.id.un);
        EditText pasw = findViewById(R.id.pas);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = un.getText().toString();
                String pas = pasw.getText().toString();
                if (uname.isEmpty() && pas.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter name or password", Toast.LENGTH_SHORT).show();

                } else {
dr.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if (snapshot.hasChild(uname)) {
            String getpass = snapshot.child(uname).child("Password").getValue(String.class);
            if (getpass.equals(pas)) {

                Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle b=new Bundle();
                b.putString("name",uname);
                intent.putExtras(b);
                startActivity(intent);


            } else
                Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();

        }
        else
        Toast.makeText(MainActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
    }

        @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});


                }
            }
        });


        Button b2 = findViewById(R.id.sign);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });
    }
}

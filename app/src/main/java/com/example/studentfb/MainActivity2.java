package com.example.studentfb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
Intent i=getIntent();
Bundle bu=i.getExtras();
String nm=bu.getString("name");
        TextView t=findViewById(R.id.tv2);
        t.setText("Hello "+nm.toUpperCase());

        CheckBox cp,cb,cf;
        cp=findViewById(R.id.piz);
        cb=findViewById(R.id.bur);
        cf=findViewById(R.id.fry);
EditText pq,bq,fq;
pq=findViewById(R.id.qp);
        bq=findViewById(R.id.qb);
        fq=findViewById(R.id.qf);
        Button b=findViewById(R.id.ord);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Boolean p,b,f;
                    p=cp.isChecked();
                    b=cb.isChecked();
                    f=cf.isChecked();
                    String pqq,bqq,fqq;
                    pqq=pq.getText().toString();
                    bqq=bq.getText().toString();
                    fqq=fq.getText().toString();


                    Bundle bundle = new Bundle();
                    bundle.putBoolean("piz", p);
                    bundle.putBoolean("bur", b);
                    bundle.putBoolean("fry", f);
                    bundle.putString("qp",pqq);
                    bundle.putString("qb",bqq);
                    bundle.putString("qf",fqq);
                    Intent intent = new Intent(MainActivity2.this, OrderDetailsActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity2.this,e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
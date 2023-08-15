package com.example.studentfb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailsActivity extends AppCompatActivity {

    private EditText etFoodName;
    private Spinner spQuantity;
    private CheckBox cbPizza;
    private CheckBox cbBurger;
    private CheckBox cbFries;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        TextView t=findViewById(R.id.tv);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        Boolean cp,cb,cf;
        String qqp,qqb,qqf;
        cp=b.getBoolean("piz");
        cb=b.getBoolean("bur");
        cf=b.getBoolean("fry");
        qqp=b.getString("qp");
        qqb=b.getString("qb");
        qqf=b.getString("qf");
String ord="";
if(cp)
    ord+="Pizza -"+qqp+"-$"+Integer.parseInt(qqp)*10+"\n";
            if(cb)
            ord+="Burger -"+qqb+"-$"+Integer.parseInt(qqb)*20+"\n";

         if(cf)
            ord+="Fries -"+qqf+"-$"+Integer.parseInt(qqf)*15+"\n";

         ord+="Total : $"+(Integer.parseInt(qqp)*10+Integer.parseInt(qqb)*20+Integer.parseInt(qqf)*15);
        t.setText(ord);

        Button btnOrder=findViewById(R.id.ord);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(OrderDetailsActivity.this,"Order placed",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OrderDetailsActivity.this, MainActivity4.class);
                startActivity(intent);

            }
        });
    }
}

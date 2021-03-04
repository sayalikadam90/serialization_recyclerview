package com.example.serialization_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtname,txtemail,txtmobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtname=findViewById(R.id.txtname);
        txtemail=findViewById(R.id.txtemail);
        txtmobile=findViewById(R.id.txtmobile);


        model model=(model)getIntent().getSerializableExtra("show");
        txtname.setText(model.getName());
        txtemail.setText(model.getEmail());
        txtmobile.setText(model.getMobile());


    }
}
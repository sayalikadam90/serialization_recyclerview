package com.example.serialization_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity1 extends AppCompatActivity {

    EditText edtname,edtemail,edtmobile;
    Button btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        edtname=findViewById(R.id.name);
        edtemail=findViewById(R.id.email);
        edtmobile=findViewById(R.id.mobile);

        btnadd=findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity1.this,MainActivity.class);
                String name1=edtname.getText().toString().trim();
                String email1=edtemail.getText().toString().trim();
                String mobile1=edtmobile.getText().toString().trim();

                intent.putExtra("name",name1);
                setResult(Activity.RESULT_OK,intent);
                intent.putExtra("email",email1);
                intent.putExtra("mobile",mobile1);
                finish();
            }
        });













    }


}
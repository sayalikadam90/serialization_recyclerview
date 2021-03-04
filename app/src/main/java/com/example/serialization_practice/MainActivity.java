package com.example.serialization_practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnnext;
    RecyclerView recyclerView;
    List<model> NameList;

    model model;
    AdapterName adapterName;
    static final int REQUEST_CODE=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnext=findViewById(R.id.btnnext);
        recyclerView=findViewById(R.id.recycleview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setHasFixedSize(true);
        NameList=new ArrayList<>();
        adapterName=new AdapterName(this,NameList);
        recyclerView.setAdapter(adapterName);


        btnnext.setOnClickListener(new btnnextClickListener());



    }

    class btnnextClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,MainActivity1.class);
            startActivityForResult(intent,REQUEST_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_CODE==requestCode){
            if(Activity.RESULT_OK==resultCode){
                String name=data.getStringExtra("name");
                String email=data.getStringExtra("email");
                String mobile=data.getStringExtra("mobile");

                model=new model();
                model.setName(name);
                model.setEmail(email);
                model.setMobile(mobile);

                NameList.add(model);
                adapterName.notifyDataSetChanged();
            }
        }
    }
}

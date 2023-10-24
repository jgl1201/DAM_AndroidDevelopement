package com.example.a022_recyclerdelete;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button myButton01;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Country> list = Country.fillArray(getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter miAdaptador = new MyAdapter(list);
        recyclerView.setAdapter(miAdaptador);

        myButton01 = findViewById(R.id.button);
        myButton01.setOnClickListener(view -> onClickDelete(view));
    }

    public void onClickDelete(View view) {
        
    }
}
package com.example.a015_inflatinglayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button left, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = findViewById(R.id.buttonLeft);
        left.setOnClickListener(view -> leftClick(view));

    }

    public void leftClick(View view){
        setContentView(R.layout.activity_main2);
        right = findViewById(R.id.buttonRight);
        right.setOnClickListener(v -> rightClick(view));
    }

    public void rightClick(View view){
        setContentView(R.layout.activity_main);
        left = findViewById(R.id.buttonLeft);
        left.setOnClickListener(v -> leftClick(view));
    }
}
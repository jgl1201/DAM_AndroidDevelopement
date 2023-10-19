package com.example.a009_activityswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSwitchActivity(View view) {
        // .class para lanzar la actividad, no para compilarla
        // en este package, landar esa actividad
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
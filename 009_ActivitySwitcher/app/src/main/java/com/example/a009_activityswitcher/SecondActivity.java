package com.example.a009_activityswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClickClose(View view) {
        /* Cierra solo la actividad que lo llama y pone en primer
        plano la última, en este caso, la que la llama */
        finish();
    }

    public void onClickSwitch(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
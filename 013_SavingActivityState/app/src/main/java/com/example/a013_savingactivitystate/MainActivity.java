package com.example.a013_savingactivitystate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "COUNTER";
    private int numCounter = 0;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // METHOD TO ADD A NUMBER WHEN CLICKING THE BUTTON
    public void contador(View view) {
        numCounter++;

        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Contador: " + Integer.toString(numCounter));
    }

    // METHOD TO SAVE VALUES
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, numCounter);
    }

    // METHOD TO GET VALUES BACK WHEN ROTATING THE DEVICE
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numCounter = savedInstanceState.getInt(KEY_COUNTER);
        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Contador: " + Integer.toString(numCounter));
    }
}
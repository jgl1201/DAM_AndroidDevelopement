package com.example.a026_timeclock;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextClock textClock;
    TextView textViewTime;
    EditText editTextTime;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock = findViewById(R.id.textClock);
        button = findViewById(R.id.button);

        textClock.setOnClickListener(view -> onClickGetHour());
        button.setOnClickListener(view -> onClickButton());
    }

   public void onClickGetHour() {
        String time = textClock.getText().toString();

        textViewTime = findViewById(R.id.textViewTime);
        textViewTime.setText("Son las " + time);
   }

   public void onClickButton() {
       editTextTime = findViewById(R.id.editTextTime);
       textViewTime = findViewById(R.id.textViewTime);
       String time = editTextTime.getText().toString();

       textViewTime.setText("Son las " + time);
       textClock.setText(time);
   }

}
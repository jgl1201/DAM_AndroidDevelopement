package com.example.a026_timeclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextClock textClock;
    TextView textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock = findViewById(R.id.textClock);
        textClock.setOnClickListener(view -> onClickGetHour());
    }

   public void onClickGetHour() {
        String time = textClock.getText().toString();

        textViewTime = findViewById(R.id.textViewTime);
        textViewTime.setText("Son las " + time);
   }

}
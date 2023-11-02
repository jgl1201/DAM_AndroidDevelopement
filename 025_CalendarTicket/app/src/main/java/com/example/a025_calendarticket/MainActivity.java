package com.example.a025_calendarticket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CalendarView.OnDateChangeListener {

    CalendarView calendarView;
    TextView textViewDate;
    EditText editTextDate;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener((view, year, month, day) ->
                onSelectedDayChange(view, year, month, day));

        button = findViewById(R.id.buttonDate);
        button.setOnClickListener(view -> onClick());
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
        textViewDate = findViewById(R.id.textViewDate);
        // Month's Array, so you need to add 1 to get the right number
        String date = day + " - " + (month + 1) + " - " + year;
        textViewDate.setText(date);
    }

    public void onClick() {
        editTextDate = findViewById(R.id.editTextDate);
        String date = editTextDate.getText().toString();
    }
}
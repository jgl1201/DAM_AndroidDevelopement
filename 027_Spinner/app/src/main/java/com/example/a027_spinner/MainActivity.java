package com.example.a027_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textViewResult;

    static ArrayList<String> fillSpinner() {
       ArrayList<String> list = new ArrayList<>();
       list.add("VALLADARES");
       list.add("CHANDEBRITO");
       list.add("CHENLO");
       list.add("ZAMANES");
       list.add("MATAMA");

       return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, fillSpinner());
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textViewResult = findViewById(R.id.textViewResult);
                textViewResult.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

  /*  @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
/*
    private AdapterView.OnItemClickListener messageClicked = (parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(), "You've got an event", Toast.LENGTH_LONG).show();
    };*/
}
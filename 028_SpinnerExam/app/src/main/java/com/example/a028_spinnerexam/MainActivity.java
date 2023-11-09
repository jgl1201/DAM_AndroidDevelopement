package com.example.a028_spinnerexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView textViewName;
    ImageView imageViewLogo;
    ArrayList<Team> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        list = (ArrayList<Team>) Team.createTeam();

        spinner.setAdapter(new SpinnerAdapter(getApplicationContext(), R.layout.item, list));
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        textViewName = findViewById(R.id.textViewName);
        imageViewLogo = findViewById(R.id.imageViewLogo);

        Team team = (Team) parent.getItemAtPosition(position);
        textViewName.setText(team.getName().toString());
        imageViewLogo.setImageResource(team.getImg());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
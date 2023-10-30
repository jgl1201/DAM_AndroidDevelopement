package com.example.a023_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener((radioGroup1, i) -> onCheckedChanged(radioGroup1, i));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        //Toast.makeText(this, "HAS PICADO " + i, Toast.LENGTH_LONG).show();

        TextView textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
        if (i == R.id.Button1)
            textViewAnswer.setText("El Coruxo me come el Cartucho");
        else if (i == R.id.Button2)
            textViewAnswer.setText("Valladares tierra de narcos");
        else if(i == R.id.Button3)
            textViewAnswer.setText("Rapido de Bouzas, lentos de pelotas");
        else if (i == R.id.Button4 )
            textViewAnswer.setText("Coia me chupa la poia");
    }
}
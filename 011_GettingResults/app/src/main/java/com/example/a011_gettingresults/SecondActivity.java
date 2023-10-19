package com.example.a011_gettingresults;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.llegado);
        button = findViewById(R.id.volver);

        text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        textView.setText(text);

        button.setOnClickListener(view -> volver(view));
    }

    public void volver(View view) {
        Intent returnIntent = new Intent(this, MainActivity.class);
        // Pareja clave valor
        returnIntent.putExtra(MainActivity.REQUEST_RESULT, text.toUpperCase());
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}
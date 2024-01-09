package com.example.a042_storagepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String NAME = "NAME";
    private EditText mEditTextName;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textViewResult);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        String name = sharedPreferences.getString(NAME, null);
        if (name == null) textView.setText("HOLA");
        else textView.setText("Bienvenido de nuevo, " + name + "!");

        mEditTextName = findViewById(R.id.editTextInput);

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(view -> saveName(view));

    }

    private void saveName(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME, mEditTextName.getText().toString());
        editor.commit();

    }
}
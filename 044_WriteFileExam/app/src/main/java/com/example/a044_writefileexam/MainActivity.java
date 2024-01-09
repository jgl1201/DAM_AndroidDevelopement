package com.example.a044_writefileexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private String FILENAME;
    EditText editTextFileName;
    EditText editTextText;
    Button buttonWrite;
    Button buttonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = (EditText) findViewById(R.id.editTextFileName);
        editTextText = (EditText) findViewById(R.id.editTextText);
        buttonWrite = findViewById(R.id.buttonWrite);
        buttonRead = findViewById(R.id.buttonRead);

        String nameOfFile = editTextFileName.getText().toString();
        FILENAME = nameOfFile;

        buttonRead.setOnClickListener(view -> readFile(view));
        buttonWrite.setOnClickListener(view -> writeFile(view));
    }

    private void writeFile(View view) {
        String nameOfFile = editTextFileName.getText().toString();
        FILENAME = nameOfFile;
        try {
            FileOutputStream fileOutputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fileOutputStream.write(editTextText.getText().toString().getBytes());
            fileOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(View view) {
        String nameOfFile = editTextFileName.getText().toString();
        FILENAME = nameOfFile;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = openFileInput(FILENAME);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(newLine + "\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        editTextText.setText(stringBuilder);
    }
}
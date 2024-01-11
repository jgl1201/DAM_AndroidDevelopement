package com.example.a045_externalstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    // MODIFY MANIFEST
    final String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
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

    public boolean isExternalStorageWritable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    public void checkStoragePermission() {
        int permission = ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, 101);
        }
    }

    public void writeFile(View view) {
        if (isExternalStorageWritable()) {
            checkStoragePermission();
            try {
                FILENAME = "Documents/" + editTextFileName.getText().toString();
                File textFile = new File(Environment.getExternalStorageDirectory(), FILENAME);
                FileOutputStream fileOutputStream = new FileOutputStream(textFile);
                fileOutputStream.write(editTextText.getText().toString().getBytes());
                fileOutputStream.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error writing file", Toast.LENGTH_LONG).show();
            }
        } else
            Toast.makeText(this, "Cannot write to External Storage", Toast.LENGTH_LONG).show();
    } // writeFile

    public void readFile(View view) {
        if (isExternalStorageReadable()) {
            checkStoragePermission();
            StringBuilder stringBuilder = new StringBuilder();
            try {
                FILENAME = "Documents/" + editTextFileName.getText().toString();
                File textFile = new File(Environment.getExternalStorageDirectory(), FILENAME);
                FileInputStream fileInputStream = new FileInputStream(textFile);
                if (fileInputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String newLine = null;
                    while ((newLine = bufferedReader.readLine()) != null) {
                        stringBuilder.append(newLine + "\n");
                    }
                    fileInputStream.close();
                }
                editTextText.setText(stringBuilder);
            } catch (java.io.IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error reading file", Toast.LENGTH_LONG).show();
            }
        } else
            Toast.makeText(this, "Cannot read External Storage", Toast.LENGTH_LONG).show();
    } // readFile

}
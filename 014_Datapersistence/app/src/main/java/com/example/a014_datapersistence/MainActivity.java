package com.example.a014_datapersistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "COUNTER";
    static final String KEY_NAME = "NAME";
    private int numCounter = 0;
    String text = "";
    TextView textViewResult;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // CODE TO RECOVER A VALUE FROM A PREFERENCES' FILE
        SharedPreferences mine = getSharedPreferences("myFile", MODE_PRIVATE);
        int defaultCounter = 0;
        numCounter = mine.getInt(KEY_COUNTER, defaultCounter);
        String defaltText = "Manolo";
        text = mine.getString(KEY_NAME, defaltText);
        editText1 = findViewById(R.id.editText1);
        editText1.setText(text);
        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Contador: " + Integer.toString(numCounter));

    }

    public void contador(View view) {
        numCounter++;

        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Contador: " + Integer.toString(numCounter));
    }

    // METHOD TO SAVE VALUES
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, numCounter);
    }

    // METHOD TO GET VALUES BACK WHEN ROTATING THE DEVICE
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numCounter = savedInstanceState.getInt(KEY_COUNTER);
        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText("Contador: " + Integer.toString(numCounter));
    }

    // PREFERENCES SAVING
    @Override
    protected void onPause() {
        super.onPause();
      //  SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences myPreferences = getSharedPreferences("myFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreferences.edit();
        editor.putInt(KEY_COUNTER, numCounter);

        editText1 = findViewById(R.id.editText1);
        text = editText1.getText().toString();
        editor.putString(KEY_NAME, text);

        // ONLY WRITES WITH COMMIT
        editor.commit();
    }
}
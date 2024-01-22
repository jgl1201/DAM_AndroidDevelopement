package com.example.a047_assets;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    Button buttonRead;
    Button buttonLoadImg;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        buttonRead = findViewById(R.id.buttonRead);
        buttonRead.setOnClickListener(view -> readAsset(view));

        buttonLoadImg = findViewById(R.id.buttonImg);
        buttonLoadImg.setOnClickListener(view -> readImg(view));
    }

    private void readImg(View view) {
        try {
            InputStream ins = this.getAssets().open("asset.png");
            Drawable d = Drawable.createFromStream(ins, null);
            imageView.setImageDrawable(d);
        } catch (IOException e){
            return;
        }
    }

    private String getText(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {;
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(newLine+"\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private void readAsset(View view) {
        mEditText = findViewById(R.id.editTextText);

        try {
            mEditText.setText(getText(this.getAssets().open("mitexto.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
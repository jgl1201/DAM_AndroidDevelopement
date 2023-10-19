package com.example.a010_senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.a010_senddata.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // pillo el careto
        imageButton = findViewById(R.id.imageButton);
        // le asigno una funcion
        imageButton.setOnClickListener(view -> onClickSwitch(view));
    }

    public void onClickSwitch(View view) {

        //transfer data
        editText = (EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();
        editText2 = (EditText)findViewById(R.id.editTextPassword);
        String password = editText2.getText().toString();

        Bundle extras = new Bundle();
        extras.putString("user", text);
        extras.putString("password", password);

        // add the text as an extra for the intent
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtras(extras);
        startActivity(intent);
    }

}
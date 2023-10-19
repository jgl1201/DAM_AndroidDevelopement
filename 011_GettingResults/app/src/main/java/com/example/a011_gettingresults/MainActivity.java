package com.example.a011_gettingresults;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String REQUEST_RESULT = "REQUEST_RESULT";
    public Button button;
    public EditText editText;
    public TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(view -> onClickSwitch(view));
    }

    public void onClickSwitch (View view) {
        editText = findViewById(R.id.cajita);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        startActivityForResult(intent, 1);
    }

    // DATOS DE REGRESO DE UNA DETERMINADA ACTIVIDAD CON CODIGO
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            textView = findViewById(R.id.resultado);
            String text = data.getStringExtra(REQUEST_RESULT);

            //String text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(text);
        }
    }
}
package com.example.a012_operacionesaritmeticas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String REQUEST_RESULT = "REQUEST_RESULT";

    Button button;
    EditText numero1;
    EditText numero2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.boton);
        button.setOnClickListener(view -> onClickSwitch(view));
    }

    public void onClickSwitch(View view) {
        numero1 = findViewById(R.id.numero1);
        String text1 = numero1.getText().toString();
        numero2 = findViewById(R.id.numero2);
        String text2 = numero2.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("n1", text1);
        bundle.putString("n2", text2);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);

        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            result = findViewById(R.id.resultado);
            String res = data.getStringExtra(REQUEST_RESULT);
            result.setText(res);
        }
    }
}
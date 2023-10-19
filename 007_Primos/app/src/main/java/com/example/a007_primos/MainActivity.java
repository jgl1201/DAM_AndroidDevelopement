package com.example.a007_primos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.numero);
        mTextView = findViewById(R.id.resultado);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int getPrimeByPosition(int position) {
        int count = 0;
        int number = 2;

        while (count < position) {
            if (isPrime(number)) {
                count++;
            }
            number++;
        }

        return number - 1; //xq el num se incrementa despues de comprobar si es primo
    }

    public void calculaPrimo(View view) {
        mEditText = findViewById(R.id.numero);
        mTextView = findViewById(R.id.resultado);

        // recoger la posicion del primo
        Integer number = Integer.parseInt(String.valueOf(mEditText.getText()));

        // settear el resultado
        mTextView.setText(getPrimeByPosition(number));
    }
}
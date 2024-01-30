package com.example.a054_sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextTfno;
    EditText editTextText;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(v -> EnviarSMS(v));
    }

    public void EnviarSMS(View v) {
        editTextTfno = (EditText) findViewById(R.id.txtTelefono);
        editTextText = (EditText) findViewById(R.id.editTextText);

        Log.i("OJO", "Enviando SMS ...");
        String telefono = editTextTfno.getText().toString();
        String message = editTextText.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefono, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS enviado", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS no enviado, por favor, inténtalo otra vez.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
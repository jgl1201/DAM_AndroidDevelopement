package com.example.a054_sendsms;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SMSActivity extends AppCompatActivity implements ReceptorSMS.onRecibeSMS {

    public final String tag = "DemoSMS";
    ReceptorSMS receptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos y registramos el receptor de sms's de manera dinámica
        // EN LUGAR DE DECLARARLO COMO RECEIVER EN EL MANIFEST
        receptor = new ReceptorSMS();
        registerReceiver(receptor, new IntentFilter
                ("android.provider.Telephony.SMS_RECEIVED"));
        receptor.setOnRecibeSMSListener(this);

        Button buttonSend = findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(view -> EnviarSMS(view));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receptor); // para que no haya pérdidas de memoria
        receptor = null;
    }

    //Método callback para pulsar el botón public
    void EnviarSMS(View view) {
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        EditText editTextText = findViewById(R.id.editTextText);
        EnviaSMS(txtTelefono.getText().toString(), editTextText.getText().toString());
    }


    public void EnviaSMS(String telefono,String mensaje) {
        try {
            SmsManager smsManager = SmsManager.getDefault ();
            smsManager.sendTextMessage(telefono, null, mensaje, null, null );
            Toast.makeText(getApplicationContext( ),
                    "SMS enviado." ,Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText( getApplicationContext(),
                    "SMS no enviado, por favor, inténtalo otra vez.", Toast.LENGTH_LONG) .show();
            e.printStackTrace( );
        }
    }

    @Override
    public void onRecibeSMS (String origen, String mensaje){
        EditText editTextTelefono = findViewById(R.id.txtTelefono);
        editTextTelefono.setText(origen);

        EditText editTextText = findViewById(R.id.editTextText);
        editTextText.setText(mensaje);
        }

    }

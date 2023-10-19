package com.example.a008_activitystarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a008_activitystarter.R;

public class MainActivity extends AppCompatActivity {

    Button miBoton;
    Button miBoton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton = findViewById(R.id.botton);

        miBoton.setOnClickListener(view-> lanzarActivida(view));

        miBoton2 = findViewById(R.id.boton2);

        miBoton2.setOnClickListener(view-> mandarMensaje(view));
    }

    public  void  lanzarActivida(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse( "https://www.cebem.net"));
        startActivity(intent);

    }

    public void  mandarMensaje(View view){
        // Create the text message with a string
        CharSequence textMessage="esto es un mensaje";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        // NO funciono
        //sendIntent.putExtra(Intent.ACTION_SENDTO,"1234");
        // Hace lo que se pretendia antes pero funciona
       /* sendIntent.putExtra("address","123456789");
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");*/

        // Esto tb funciona
        Uri sms_uri = Uri.parse("smsto:+" + "987654321");
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
        sms_intent.putExtra("sms_body", "Hola me qué tal?");
        startActivity(sms_intent);
/*
// Verify that the intent will resolve to an activity Solo para el resto de casos. Para el
// Ultimo no se usa, no funciona.
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }*/
    }
}
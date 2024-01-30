package com.example.a052_imgdownloadasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText editTextURL;
    Button buttonDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextURL = findViewById(R.id.editTextURL);
        imageView = findViewById(R.id.imageView);
        buttonDownload = findViewById(R.id.buttonDownload);

        buttonDownload.setOnClickListener(view -> descargar(view));

    }

    public void descargar(View view) {
        String url = editTextURL.getText().toString();

        CargaImagenes cargaImagenes = new CargaImagenes();
        cargaImagenes.execute(url);
    }

    private Bitmap descargarImagen(String imageHttpAddress) {
        URL imageUrl = null;
        Bitmap imagen = null;
        try {
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return imagen;
    }

    private class CargaImagenes extends AsyncTask<String, Void, Bitmap> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Cargando Imagen");
            pDialog.setCancelable(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();

        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // Delete Toast -> Needs a foreground and is executing in background
            //Toast.makeText(MainActivity.this, "Entra en doInBackground", Toast.LENGTH_SHORT).show();
            String url = params[0];
            Bitmap imagen = descargarImagen(url);
            return imagen;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            imageView.setImageBitmap(result);
            pDialog.dismiss();
        }
    }
    // CargarImagen
}
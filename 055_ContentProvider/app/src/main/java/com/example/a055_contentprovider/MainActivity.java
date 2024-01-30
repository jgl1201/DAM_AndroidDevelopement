package com.example.a055_contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    ListView listView;
    private final String tag = "SMS:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lstContactos);
        listView.setOnItemLongClickListener(this);
    }

    @SuppressLint("Range")
    public void buscar(View v) {
        EditText editTextName = (EditText) findViewById(R.id.txtContacto);

        String[] proyeccion = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER,
                ContactsContract.Contacts.PHOTO_ID};

        String filtro = ContactsContract.Contacts.DISPLAY_NAME + " like ?";
        String[] args_filtro = {"%" + editTextName.getText().toString() + "%"};

        List<String> lista_contactos = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                proyeccion, filtro, args_filtro, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String id = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range") String name = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                    lista_contactos.add(name);
            }
        }

        cursor.close();

        ListView l = (ListView) findViewById(R.id.lstContactos);
        l.setAdapter(new ArrayAdapter<String>(this, R.layout.fila_lista, lista_contactos));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        TextView t = (TextView) view;
        String nombreContacto = t.getText().toString();

        String[] proyeccion = {ContactsContract.Contacts._ID};
        String filtro = ContactsContract.Contacts.DISPLAY_NAME + "?";
        String[] args_filtro = {nombreContacto};

        List<String> lista_contactos = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                proyeccion, filtro, args_filtro, null);

        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                @SuppressLint("Range") String identificator = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts._ID) );
                enviarSMS(identificator);
            }
        }
        cur.close();

        return true;
    }

    private void enviarSMS(String identificador) {
        ContentResolver cr = getContentResolver();
        SmsManager smsManager = SmsManager.getDefault();

        String mensaje = ( (EditText) findViewById(R.id.txtSMS) ).getText().toString();

        Cursor cursorTelefono = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Phone._ID + "=?" ,
                new String[] {identificador}, null);

        while (cursorTelefono.moveToNext()) {
                @SuppressLint("Range") String telefono = cursorTelefono.getString(
                        cursorTelefono.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.DATA) );
                try {
                    smsManager.sendTextMessage(telefono, null, mensaje, null, null);
                    Log.d(tag, "SMS ENVIADO");
                } catch (Exception e) {
                    Log.d(tag, "NO SE PUDO ENVIAR SMS");
                    e.printStackTrace();
                }
        }
        cursorTelefono.close();
    }
}
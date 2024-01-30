package com.example.a053_demobroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receptor extends BroadcastReceiver {

    private final String SMS_RECIEVED = "android.provider.Telephony.SMS_RECIEVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECIEVED))
            Toast.makeText(context, "SMS Recibido", Toast.LENGTH_SHORT).show();
    }
}

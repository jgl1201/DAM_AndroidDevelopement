package com.example.a039_pupupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonRevert;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonRevert = findViewById(R.id.imageButtonRevert);
        imageButtonRevert.setOnClickListener(v -> showPopupMenu(v));
    }

    private PopupMenu.OnMenuItemClickListener myOnMenuClickListener =
            new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                   int id = item.getItemId();

                   if (id == R.id.menu_reply) {
                       Toast.makeText(MainActivity.this, "Reply", Toast.LENGTH_LONG).show();
                       return true;
                   }
                   if (id == R.id.menu_reply_all) {
                       Toast.makeText(MainActivity.this, "Reply All", Toast.LENGTH_LONG).show();
                       return true;
                   }
                   if (id == R.id.menu_forward) {
                       Toast.makeText(MainActivity.this, "Forward", Toast.LENGTH_LONG).show();
                       return true;
                   }

                   return false;
                }
            };

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(myOnMenuClickListener);
        popupMenu.show();
    }
}
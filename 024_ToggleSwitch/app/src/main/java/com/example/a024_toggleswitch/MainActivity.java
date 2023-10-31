package com.example.a024_toggleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements ToggleButton.OnCheckedChangeListener{

    ToggleButton toggleButton;
    Switch aSwitch;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChanged(buttonView, isChecked));

        aSwitch = findViewById(R.id.switch2);
        aSwitch.setOnCheckedChangeListener((button, checked) -> manolito((Switch) button, checked));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        imageView = findViewById(R.id.imageView);

        if (isChecked)
            imageView.setImageResource(R.drawable.avatar_1);
        else
            imageView.setImageResource(R.drawable.avatar_3);
    }

    public void manolito(Switch compoundButton, boolean checked) {
        imageView = findViewById(R.id.imageView);

        if (checked)
            imageView.setImageResource(R.drawable.avatar_2);
        else
            imageView.setImageResource(R.drawable.avatar_4);
    }
}
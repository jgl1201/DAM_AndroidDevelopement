package com.example.a033_runtimewidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.mainLayout);

        DatePicker datePicker = new DatePicker(this);
        datePicker.setId(View.generateViewId());
        mainLayout.addView(datePicker);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainLayout);
        constraintSet.centerHorizontally(datePicker.getId(), ConstraintSet.PARENT_ID);
        constraintSet.centerVertically(datePicker.getId(), ConstraintSet.PARENT_ID);

        constraintSet.applyTo(mainLayout);
    }
}
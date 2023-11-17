package com.example.a032_buttonsgridlayout;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        addChild();
    }

    @SuppressLint("Range")
    public void rerun() {
        View v;
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            v = gridLayout.getChildAt(i);
            Button b = (Button) v;
            b.setBackgroundColor(rgb(0xff, 0xff, 0xff));
        }
    }

    @SuppressLint("ResourceType")
    public void addChild() {
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        Button button;

        for (int i = 0; i < 17; i++) {
            button = new Button(this);

            // Adjust width and height to wrap_content
            button.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));

            button.setText("Button " + i);
            button.setId(View.generateViewId());
            button.setOnClickListener(this);
            gridLayout.addView(button, i);
        }

        button = new Button(this);
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        button.setText("SET");
        button.setId(18);
        button.setOnClickListener(this);
        gridLayout.addView(button);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        if (view.getClass().getSimpleName().equals("Button") && b.getId() != 18) {
            Random r1 = new Random();

            b.setBackgroundColor(rgb(
                    r1.nextInt(255), r1.nextInt(255), r1.nextInt(255)) );
        } else rerun();
    }
}
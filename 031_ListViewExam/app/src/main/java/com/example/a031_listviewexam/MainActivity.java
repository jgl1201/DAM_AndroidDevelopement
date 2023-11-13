package com.example.a031_listviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<Team> list;
    TextView textViewName;
    ImageView imageViewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        list = (ArrayList<Team>) Team.createTeam();

        listView.setAdapter(new ListViewAdapter(getApplicationContext(), R.layout.elemento, list));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        textViewName = findViewById(R.id.textViewName);
        imageViewLogo = findViewById(R.id.imageViewLogo);

        Team team = (Team) adapterView.getItemAtPosition(i);
        textViewName.setText(team.getName().toString());
        imageViewLogo.setImageResource(team.getImg());
    }
}
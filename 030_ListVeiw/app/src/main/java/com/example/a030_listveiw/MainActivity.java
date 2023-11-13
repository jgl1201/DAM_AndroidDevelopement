package com.example.a030_listveiw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    TextView textViewSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // OS resource
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, fillList());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public static List<String> fillList() {
        List<String> clubsList = new ArrayList<>();

        clubsList.add("Celta de Vigo");
        clubsList.add("Arenteiro");
        clubsList.add("Deportivo de la Coruña");
        clubsList.add("Lugo");
        clubsList.add("Zelta B");
        clubsList.add("Valladares FC");

        return clubsList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        textViewSelection = findViewById(R.id.textViewSelection);
        textViewSelection.setText(adapterView.getItemAtPosition(i).toString());
    }
}
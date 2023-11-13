package com.example.a031_listviewexam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Team> {

    LayoutInflater layoutInflater;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<Team> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return fillView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return fillView(position, convertView, parent);
    }

    public View fillView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.elemento, null, true);

        Team team = getItem(position);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView =
                (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageResource(team.getImg());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView name =
                (TextView) convertView.findViewById(R.id.name);
        name.setText(team.getName());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView city =
                (TextView) convertView.findViewById(R.id.city);
        city.setText(team.getCity());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView country =
                (TextView) convertView.findViewById(R.id.country);
        country.setText(team.getCountry());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView year =
                (TextView) convertView.findViewById(R.id.year);
        year.setText(team.getYear());

        return convertView;
    }

}

package com.example.a028_spinnerexam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Team> {

    LayoutInflater layoutInflater;

    public SpinnerAdapter(@NonNull Context context, int resource, List<Team> objects) {
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
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        Team team = getItem(position);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView =
                (ImageView) view.findViewById(R.id.imageViewLogo);
        imageView.setImageResource(team.getImg());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView name =
                (TextView) view.findViewById(R.id.name);
        name.setText(team.getName());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView city =
                (TextView) view.findViewById(R.id.city);
        city.setText(team.getCity());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView country =
                (TextView) view.findViewById(R.id.country);
        country.setText(team.getCountry());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView year =
                (TextView) view.findViewById(R.id.year);
        year.setText(team.getYear());

        return view;
    }

}

package com.example.a022_recyclerdelete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Country> nameList;
    public MyAdapter(List<Country> list) {
        nameList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.elemento, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Country country = nameList.get(position);
        holder.country.setText(country.getName());
        holder.details.setText(country.getDetail());
    }

    @Override
    public int getItemCount() {
        if(nameList == null) return 0;
        return nameList.size();
    }

    // clase INTERNA para manipular elemento.xml
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView country;
        public TextView details;

        public MyViewHolder(View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.texto);
            details = itemView.findViewById(R.id.details);
        }
    }
}

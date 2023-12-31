package com.example.a022_recyclerdelete;

import android.annotation.SuppressLint;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Country> nameList;
    public MyAdapter(List<Country> list) {
        nameList = list;
    }

    public void add(){
        Country country = new Country("Pais extra", "descripcion extra", 0);
        nameList.add(country);
        notifyDataSetChanged();
    }

    private void delete(int position) {
        nameList.remove(position);
        // Notifies that the data has changed. Used for delete, add...
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.elemento, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    // add a clickListener
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Country country = nameList.get(position);
        holder.country.setText(country.getName());
        holder.details.setText(country.getDetail());
        holder.imageView.setImageResource(country.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(position);
            }
        });
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
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.texto);
            details = itemView.findViewById(R.id.details);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}

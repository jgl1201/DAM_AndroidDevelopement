package com.example.a038_contextualrecview;

import android.annotation.SuppressLint;
import android.media.Image;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements SelectMode {

    private List<Country> nameList = null;
    private SparseArray<Boolean> selectedList = new SparseArray<>();
    holder.onItemSelectedListener mListener;

    public MyAdapter(List<Country> list) {
        nameList = list;
    }

    private void remove(int position) {
        nameList.remove(position);
        notifyDataSetChanged();
    }

    // when click at deleteAll menu
    public void deleteAllSelected() {
        if (selectedList.size() == 0) return;
        for (int i = nameList.size() - 1; i >= 0; i--) {
            if (selectedList.get(i, false)) remove(i);
        }
        selectedList.clear();
    }

    @Override
    public void onSelect() {
        if (mListener != null) mListener.onSelect();
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Country country = nameList.get(position);
        holder.country.setText(country.getName());
        holder.details.setText(country.getDetail());
        holder.image.setImageResource(country.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemView.setSelected(!holder.itemView.isSelected());
                if (holder.itemView.isSelected()) selectedList.put(position, true);
                else selectedList.remove(position);
                onSelect();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (nameList == null) return 0;
        return nameList.size();
    }


    // clase INTERNA para manipular elemento.xml
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView country;
        public TextView details;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.texto);
            details = itemView.findViewById(R.id.details);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}

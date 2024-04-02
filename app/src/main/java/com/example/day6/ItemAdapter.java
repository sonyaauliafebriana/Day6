package com.example.day6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<ModelItem> modelItem;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener =listener;
    }

    public ItemAdapter(ArrayList<ModelItem> modelItem) {
        this.modelItem = modelItem;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        holder.namaBarang.setText(modelItem.get(position).getNamaBarang());
        holder.deskripsi.setText(modelItem.get(position).getDeskripsi());
        holder.hargaBarang.setText(modelItem.get(position).getHarga());
        holder.gambarBrang.setImageResource(modelItem.get(position).getGambarBarang());
    }

    @Override
    public int getItemCount() {
        return modelItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaBarang, deskripsi, hargaBarang;
        ImageView gambarBrang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaBarang = itemView.findViewById(R.id.nama_barang);
            deskripsi = itemView.findViewById(R.id.detail_deskripsi_barang);
            hargaBarang = itemView.findViewById(R.id.detail_harga_barang);
            gambarBrang = itemView.findViewById(R.id.gambar_barang);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && mListener != null) {
                        mListener.onItemClick(position);
                    }
                }
            });

        }
    }
}

package com.example.day6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private ArrayList<ModelItem> modelItem;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.recycleview);
        itemAdapter = new ItemAdapter(modelItem);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);

        itemAdapter.setOnItemClickListener(this);
    }

    private void getData() {
        modelItem = new ArrayList<>();
        modelItem.add(new ModelItem("Parfume","Dior Parfume Cd Poison Woman Edp 100Ml Original Parfume Wanita", "Rp. 678.000", R.drawable.dior1));
        modelItem.add(new ModelItem("Parfume","Dior Prfume Pria Sauvage Edp With Box Tutup Margnet 100Ml", "Rp. 320.000", R.drawable.dior2));
        modelItem.add(new ModelItem("Parfume","Dior Parfume Rose Kabuki Unisex Edp 125Ml Original Parfume", "Rp. 684.000", R.drawable.dior3));
        modelItem.add(new ModelItem("Parfume","Dior Miss (2012) Edp 100Ml For Women (Dus Segel)", "Rp. 1.930.400", R.drawable.dior4));
        modelItem.add(new ModelItem("Parfume","Dior Christian Poison EDP 5ml", "Rp. 85.000", R.drawable.dior5));
        modelItem.add(new ModelItem("Sneakers and Heels","Christian Dior B23 Skater Sneaker Cream Obliqu Jacquard", "Rp. 15.408.000", R.drawable.dior6));
        modelItem.add(new ModelItem("Sneakers and Heels","Christian Dior Slingback Pumps Heels Transparent Mesh Embroidere Black", "Rp. 15.515.000", R.drawable.dior7));
        modelItem.add(new ModelItem("Sneakers and Heels","Sepatu Christian Dior doll pump shoes", "Rp. 2.700.000", R.drawable.dior8));
        modelItem.add(new ModelItem("Sneakers and Heels","CHRISTIAN DIOR Jadior slingback pump 100mm satin Black", "Rp. 12.900.000", R.drawable.dior9));
        modelItem.add(new ModelItem("Sneakers and Heels","Sepatu sneakers wanita Dior", "Rp. 2.400.000", R.drawable.dior10));
        modelItem.add(new ModelItem("Tas","Christian Dior Medium D Bobby Bag Oblique Jacquard Blue", "Rp. 62.042.000", R.drawable.dior11));
        modelItem.add(new ModelItem("Tas","Tas Dior Bobby, berbentuk klasik, menyerupai stengah lingkaran oval, dengan logo CD pada bagian penutupnya", "Rp. 20.750.000", R.drawable.dior12));
        modelItem.add(new ModelItem("Tas","Fast Sale Preloved Dior Bobby Small Camel Calf Leather Ghw sz 18 x 14 x 5 cm With bag and strap", "Rp. 22.750.000", R.drawable.dior13));
        modelItem.add(new ModelItem("Tas","JTF664-khaki Tas Ransel Import Wanita Elegan Fashion Terbaru", "Rp. 96.000", R.drawable.dior14));
        modelItem.add(new ModelItem("Tas","CHRISTIAN DIOR Romantic Trotter Leather Handbag Beige Ladies", "Rp. 40.055.000", R.drawable.dior15));
    }

    @Override
    public void onItemClick(int position) {
        ModelItem clickedItem = modelItem.get(position);

        Intent intent= new Intent(MainActivity.this, DetailActivity.class);

        intent.putExtra("nama_barang", clickedItem.getNamaBarang());

        intent.putExtra("deskripsi", clickedItem.getDeskripsi());

        intent.putExtra("harga_barang", clickedItem.getHarga());

        intent.putExtra("gambar_barang", clickedItem.getGambarBarang());

        startActivity(intent);
    }

}
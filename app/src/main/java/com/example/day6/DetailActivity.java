package com.example.day6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null) {
            String namaBarang = intent.getStringExtra("nama_barang");
            String Deskripsi = intent.getStringExtra("deskripsi");
            String hargaBarang = intent.getStringExtra("harga_barang");
            int gambarBarang = intent.getIntExtra("gambar_barang", 0);

            TextView detailNamaBarang = findViewById(R.id.detail_nama_barang);
            detailNamaBarang.setText(namaBarang);

            TextView deskripsi = findViewById(R.id.detail_deskripsi_barang);
            deskripsi.setText(Deskripsi);

            TextView hargabarang = findViewById(R.id.detail_harga_barang);
            hargabarang.setText(hargaBarang);

            ImageView detailGambarBarang = findViewById(R.id.detail_gambar_barang);
            detailGambarBarang.setImageResource(gambarBarang);

            Button btnShare = findViewById(R.id.btn_share);
            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shareItem(namaBarang, Deskripsi, hargaBarang);
                }
            });
        }
    }

    private void shareItem(String namaBarang, String deskripsi, String hargaBarang) {
        String shareText = "Check out this item:\n" +
                "Nama Barang: " + namaBarang + "\n" +
                "Deskripsi: " + deskripsi + "\n" +
                "Harga: " + hargaBarang;

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

}

package com.example.day6;

public class ModelItem {
    private String namaBarang;

    private String deskripsi;
    private String harga;
    private int gambarBarang;

    public ModelItem(String namaBarang, String deskripsi, String harga, int gambarBarang) {
        this.namaBarang = namaBarang;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.gambarBarang = gambarBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getGambarBarang() {
        return gambarBarang;
    }

    public void setGambarBarang(int gambarBarang) {
        this.gambarBarang = gambarBarang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}

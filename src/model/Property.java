/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aloysius
 */
public class Property {
    private int kodeProperty;
    private String alamat;
    private String deskripsiBangunan;
    private StatusJualSewa statusJualSewa;
    private int harga;
    private int tipeProperty;
    private int luasBangunan;
    private boolean verifikasi;
    private int jumlahKamar;
    private int luasTanah;
    
    public Property(int kodeProperty, String alamat, String deskripsiBangunan, StatusJualSewa statusJualSewa, int harga, int tipeProperty, int luasBangunan, boolean verifikasi, int jumlahKamar, int luasTanah) {
        this.kodeProperty = kodeProperty;
        this.alamat = alamat;
        this.deskripsiBangunan = deskripsiBangunan;
        this.statusJualSewa = statusJualSewa;
        this.harga = harga;
        this.tipeProperty = tipeProperty;
        this.luasBangunan = luasBangunan;
        this.verifikasi = verifikasi;
        this.jumlahKamar = jumlahKamar;
        this.luasTanah = luasTanah;
    }

    public int getLuasTanah() {
        return luasTanah;
    }

    public void setLuasTanah(int luasTanah) {
        this.luasTanah = luasTanah;
    }

    public int getKodeProperty() {
        return kodeProperty;
    }

    public void setKodeProperty(int kodeProperty) {
        this.kodeProperty = kodeProperty;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsiBangunan() {
        return deskripsiBangunan;
    }

    public void setDeskripsiBangunan(String deskripsiBangunan) {
        this.deskripsiBangunan = deskripsiBangunan;
    }

    public StatusJualSewa getStatusJualSewa() {
        return statusJualSewa;
    }

    public void setStatusJualSewa(StatusJualSewa statusJualSewa) {
        this.statusJualSewa = statusJualSewa;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTipeProperty() {
        return tipeProperty;
    }

    public void setTipeProperty(int tipeProperty) {
        this.tipeProperty = tipeProperty;
    }

    public int getLuasBangunan() {
        return luasBangunan;
    }

    public void setLuasBangunan(int luasBangunan) {
        this.luasBangunan = luasBangunan;
    }

    public boolean isVerifikasi() {
        return verifikasi;
    }

    public void setVerifikasi(boolean verifikasi) {
        this.verifikasi = verifikasi;
    }

    public int getJumlahKamar() {
        return jumlahKamar;
    }

    public void setJumlahKamar(int jumlahKamar) {
        this.jumlahKamar = jumlahKamar;
    }
    
    public String printDataProperty(){
        return "Kode Property\t\t: " + kodeProperty +
                "\nAlamat\t\t\t: " + alamat +
                "\nDeskripsi Bangunan\t: " + deskripsiBangunan + 
                "\nStatus\t\t\t: " + statusJualSewa +
                "\nHarga\t\t\t: " + harga +
                "\nTipe property\t\t: " + tipeProperty + 
                "\nLuas Bangunan\t\t: " + luasBangunan + 
                //verifikasi ga di print kan ?? cuma buat admin doang ??
                "\nJumlah Kamar\t\t: " + jumlahKamar + 
                "\nLuas Tanah\t\t: " + luasTanah;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigInteger;

/**
 *
 * @author Aloysius
 */
public class Property {
    private Daerah daerah;
    private String alamat;
    private String deskripsiBangunan;
    private StatusJualSewa statusJualSewa;
    private BigInteger harga;
    private int tipeProperty;
    private int luasBangunan;
    private int luasTanah;
    private int jumlahKamar;
    private boolean verifikasi;

    public Property(Daerah daerah, String alamat, String deskripsiBangunan, StatusJualSewa statusJualSewa, BigInteger harga, int tipeProperty, int luasBangunan, int luasTanah, int jumlahKamar, boolean verifikasi) {
        this.daerah = daerah;
        this.alamat = alamat;
        this.deskripsiBangunan = deskripsiBangunan;
        this.statusJualSewa = statusJualSewa;
        this.harga = harga;
        this.tipeProperty = tipeProperty;
        this.luasBangunan = luasBangunan;
        this.luasTanah = luasTanah;
        this.jumlahKamar = jumlahKamar;
        this.verifikasi = verifikasi;
    }
    
    public Daerah getDaerah() {
        return daerah;
    }

    public void setDaerah(Daerah daerah) {
        this.daerah = daerah;
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

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
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

    public int getLuasTanah() {
        return luasTanah;
    }

    public void setLuasTanah(int luasTanah) {
        this.luasTanah = luasTanah;
    }

    public int getJumlahKamar() {
        return jumlahKamar;
    }

    public void setJumlahKamar(int jumlahKamar) {
        this.jumlahKamar = jumlahKamar;
    }

    public boolean isVerifikasi() {
        return verifikasi;
    }

    public void setVerifikasi(boolean verifikasi) {
        this.verifikasi = verifikasi;
    }
    
    @Override
    public String toString(){
        return "Daerah\t\t\t: " + daerah.getKota() + ", " + daerah.getProvinsi() +
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

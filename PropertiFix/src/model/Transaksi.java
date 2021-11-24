/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class Transaksi {
    private int idTransaksi;
    private int idPengguna;
    private int idProperty;
    private JenisPembayaran jenispembayaran;
    private Status_Pembayaran statuspembayaran;
    
    public Transaksi(int idTransaksi,int idPengguna, int idProperty,JenisPembayaran jenispembayaran,Status_Pembayaran statuspembayaran){
        this.jenispembayaran = jenispembayaran;
        this.statuspembayaran = statuspembayaran;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public int getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }
    
    public JenisPembayaran getJenispembayaran(){
        return jenispembayaran;
    }
    
    public Status_Pembayaran getStatuspembayaran(){
        return statuspembayaran;
    }
    
    public void setJenisPembayaran(JenisPembayaran jenispembayaran){
        this.jenispembayaran = jenispembayaran;
    }
    
    public void setStatuspembayaran(Status_Pembayaran statuspembayaran){
        this.statuspembayaran = statuspembayaran;
    }
}

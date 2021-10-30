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
    private JenisPembayaran jenispembayaran;
    private Status_Pembayaran statuspembayaran;
    
    Transaksi(JenisPembayaran jenispembayaran,Status_Pembayaran statuspembayaran){
        this.jenispembayaran = jenispembayaran;
        this.statuspembayaran = statuspembayaran;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jason
 */
public class Wilayah extends Daerah{
    private String deskripsiWilayah;

    public Wilayah(String deskripsiWilayah, String provinsi, String kota) {
        super(provinsi, kota);
        this.deskripsiWilayah = deskripsiWilayah;
    }

    public String getDeskripsiWilayah() {
        return deskripsiWilayah;
    }

    public void setDeskripsiWilayah(String deskripsiWilayah) {
        this.deskripsiWilayah = deskripsiWilayah;
    }
    
}

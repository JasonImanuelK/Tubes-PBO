/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import controller.ControllerProperty;
import java.util.ArrayList;
import javax.swing.JLabel;
import model.Property;

/**
 *
 * @author Aloysius
 */
public class LihatPropertyUser {
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public LihatPropertyUser(){
        frame = new JFrame("Lihat Property");
        frame.setSize(380, 640);
        frame.setLayout(null);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.dispose();
                new MainMenu();
            }
        });
        
        int x = 10;
        ArrayList<Property> listProperty = controllerProperty.getListPropertyUser();
        for (int i = 0; i < listProperty.size(); i++) {
            //print hanya untuk test
            System.out.println(listProperty.get(i).toString());
            Property property = (listProperty.get(i));
            JLabel labelDaerah = new JLabel("Daerah\t: " + property.getDaerah().getKota() + ", " + property.getDaerah().getProvinsi());
            labelDaerah.setBounds(10, x, 100, 20);
            JLabel labelAlamat = new JLabel("Alamat\t: " + property.getAlamat());
            labelAlamat.setBounds(10, x+30, 100, 20);
            JLabel labelDeskrpsi = new JLabel("Deskripsi Bangunan\t: " + property.getDeskripsiBangunan());
            labelDeskrpsi.setBounds(10, x+60, 100, 20);
            JLabel labelStatusJualSewa = new JLabel("Status\t: " + property.getStatusJualSewa().toString());
            labelStatusJualSewa.setBounds(10, x+90, 100, 20);
            JLabel labelHarga = new JLabel("Harga\t: " + property.getHarga());
            labelHarga.setBounds(10, x+120, 100, 20);
            JLabel labelTipeProperty = new JLabel("Tipe Property\t: " + property.getTipeProperty().toString());
            labelTipeProperty.setBounds(10, x+150, 100, 20);
            JLabel labelLuasBangunan = new JLabel("Alamat\t: " + property.getLuasBangunan());
            labelLuasBangunan.setBounds(10, x+180, 100, 20);
            JLabel labelLuasTanah = new JLabel("Alamat\t: " + property.getLuasTanah());
            labelLuasTanah.setBounds(10, x+210, 100, 20);
            JLabel labelJumlahKamar = new JLabel("Alamat\t: " + property.getJumlahKamar());
            labelJumlahKamar.setBounds(10, x+240, 100, 20);
            
            String verifikasi;
            if(property.isVerifikasi()){
                verifikasi = "Sudah terverifikasi";
            }else{
                verifikasi = "Belum terverifikasi";
            }
            JLabel labelVerifikasi = new JLabel("Verifikasi\t: " + verifikasi);
            labelVerifikasi.setBounds(10, x+270, 100, 20);
            
            
            frame.add(labelDaerah);
            frame.add(labelAlamat);
            frame.add(labelDeskrpsi);
            frame.add(labelStatusJualSewa);
            frame.add(labelTipeProperty);
            frame.add(labelLuasBangunan);
            frame.add(labelLuasTanah);
            frame.add(labelJumlahKamar);
            frame.add(labelVerifikasi);
            
            x += 300;
        }
    }
    
}

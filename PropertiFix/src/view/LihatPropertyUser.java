/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import controller.ControllerProperty;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.dispose();
                new MainMenu();
            }
        });
        
        int height = 30;
        ArrayList<Property> listProperty = controllerProperty.getListPropertyUser();
        for (int i = 0; i < listProperty.size(); i++) {
            Property property = (listProperty.get(i));
            JLabel labelDaerah = new JLabel("Daerah : " + property.getDaerah().getKota() + ", " + property.getDaerah().getProvinsi());
            labelDaerah.setBounds(10, height, 300, 20);
            JLabel labelAlamat = new JLabel("Alamat : " + property.getAlamat());
            labelAlamat.setBounds(10, height+20, 300, 20);
            JLabel labelDeskrpsi = new JLabel("Deskripsi Bangunan : " + property.getDeskripsiBangunan());
            labelDeskrpsi.setBounds(10, height+40, 300, 20);
            JLabel labelStatusJualSewa = new JLabel("Status : " + property.getStatusJualSewa().toString());
            labelStatusJualSewa.setBounds(10, height+60, 300, 20);
            JLabel labelHarga = new JLabel("Harga : " + property.getHarga());
            labelHarga.setBounds(10, height+80, 300, 20);
            JLabel labelTipeProperty = new JLabel("Tipe Property : " + property.getTipeProperty().toString());
            labelTipeProperty.setBounds(10, height+100, 300, 20);
            JLabel labelLuasBangunan = new JLabel("Luas Bangunan : " + property.getLuasBangunan());
            labelLuasBangunan.setBounds(10, height+120, 300, 20);
            JLabel labelLuasTanah = new JLabel("Luas Tanah : " + property.getLuasTanah());
            labelLuasTanah.setBounds(10, height+140, 300, 20);
            JLabel labelJumlahKamar = new JLabel("Jumlah Kamar : " + property.getJumlahKamar());
            labelJumlahKamar.setBounds(10, height+160, 300, 20);
            
            String verifikasi;
            if(property.isVerifikasi()){
                verifikasi = "Sudah terverifikasi";
            }else{
                verifikasi = "Belum terverifikasi";
            }
            JLabel labelVerifikasi = new JLabel("Verifikasi : " + verifikasi);
            labelVerifikasi.setBounds(10, height+180, 300, 20);
            
            JButton edit = new JButton("Edit");
            edit.setBounds(250, height+85, 80, 40);
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new FormProperty(property);
                }
            });
            
            frame.add(labelDaerah);
            frame.add(labelAlamat);
            frame.add(labelDeskrpsi);
            frame.add(labelStatusJualSewa);
            frame.add(labelHarga);
            frame.add(labelTipeProperty);
            frame.add(labelLuasBangunan);
            frame.add(labelLuasTanah);
            frame.add(labelJumlahKamar);
            frame.add(labelVerifikasi);
            frame.add(edit);
            height += 220;
        }
        
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 80, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });
        
        frame.add(back);
    }
    
}

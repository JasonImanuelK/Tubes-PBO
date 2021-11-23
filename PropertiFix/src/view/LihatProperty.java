/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Admin;
import model.Property;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author Aloysius
 */
public class LihatProperty {
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public LihatProperty(ArrayList<Property> listProperty){ //sebelum kesini query dulu pake getListPropertyUseFilter()
        frame = new JFrame("Verifikasi Property");
        frame.setSize(440, 640);
        frame.setLayout(null);
        frame.setVisible(true);
        
        if(UserSingeltonManager.getInstance().getPerson() instanceof User){
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    frame.dispose();
                    new MainMenu();
                }
            });
        }else{
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    frame.dispose();
                    new MenuAdmin();
                }
            });
        }
        
        int height = 10;
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
            
            User pemilikProperty = property.getUser();
            JLabel labelPemilik = new JLabel("Pemilik : " + pemilikProperty.getNama() + " - " + pemilikProperty.getNoTelp());
            labelPemilik.setBounds(10, height+180, 300, 20);
            
            if(UserSingeltonManager.getInstance().getPerson() instanceof Admin){
                JButton edit = new JButton("Edit");
                edit.setBounds(250, height+85, 80, 40);
                edit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        new FormProperty(property);
                    }
                });
                
                JButton delete = new JButton("Delete");
                delete.setBounds(350, height+85, 80, 40);
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        if(controllerProperty.deleteProperty(property)){
                            JOptionPane.showMessageDialog(null, "Delete berhasil");
                            new VerifikasiProperty();
                        }else{
                            JOptionPane.showMessageDialog(null, "Delete gagal");
                        }
                    }
                });
                
                frame.add(edit);
                frame.add(delete);
            }
            
            frame.add(labelDaerah);
            frame.add(labelAlamat);
            frame.add(labelDeskrpsi);
            frame.add(labelStatusJualSewa);
            frame.add(labelHarga);
            frame.add(labelTipeProperty);
            frame.add(labelLuasBangunan);
            frame.add(labelLuasTanah);
            frame.add(labelJumlahKamar);
            frame.add(labelPemilik);
            height += 220;
        }
        
    }
}

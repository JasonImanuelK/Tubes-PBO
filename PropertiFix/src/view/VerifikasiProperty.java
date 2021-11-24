/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import controller.ControllerProperty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.InterfacePesan;
import model.Property;
import model.UserSingeltonManager;
import model.User;

/**
 *
 * @author Aloysius
 */
public class VerifikasiProperty implements InterfacePesan{
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public VerifikasiProperty(){
        frame = new JFrame("Verifikasi Property");
        frame.setSize(500, 670);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
        int height = 30;
        ArrayList<Property> listProperty = controllerProperty.getListPropertyBelumTerverifikasi();
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
            
            JButton delete = new JButton("Delete");
            delete.setBounds(240, height+85, 80, 40);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    if(controllerProperty.deleteProperty(property)){
                        JOptionPane.showMessageDialog(null, hapusBerhasil);
                        new VerifikasiProperty();
                    }else{
                        JOptionPane.showMessageDialog(null, hapusGagal);
                    }
                }
            });
            
            JButton verifikasi = new JButton("Verifikasi");
            verifikasi.setBounds(330, height+85, 120, 40);
            verifikasi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    if(controllerProperty.verifikasiProperty(property)){
                        JOptionPane.showMessageDialog(null, "Verifikasi berhasil");
                        new VerifikasiProperty();
                    }else{
                        JOptionPane.showMessageDialog(null, "Verifikasi gagal");
                    }
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
            frame.add(verifikasi);
            frame.add(delete);
            height += 220;
        }
        
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 80, 20);
        if(UserSingeltonManager.getInstance().getPerson() instanceof User){
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MainMenu();
                }
            });
        }else{
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MenuAdmin();
                }
            });
        }
        
        frame.add(back);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import controller.MethodTransaksi;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import model.Admin;
import model.InterfacePesan;
import model.Property;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author Aloysius
 */
public class LihatProperty implements InterfacePesan{
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public LihatProperty(ArrayList<Property> listProperty){ //sebelum kesini query dulu pake getListPropertyUseFilter()
        frame = new JFrame("Lihat Property");
        frame.setSize(480, 640);
        frame.setLayout(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(10, 10, 440, 640);
            
        
        int height = 30;
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
                            JOptionPane.showMessageDialog(null, hapusBerhasil);
                            new MenuAdmin();
                        }else{
                            JOptionPane.showMessageDialog(null, hapusGagal);
                        }
                    }
                });
                
                panel.add(edit);
                panel.add(delete);
            } else {
                MethodTransaksi controlTransaksi = new MethodTransaksi();
                if(!pemilikProperty.getNama().equals(UserSingeltonManager.getInstance().getPerson().getNama())&&!pemilikProperty.getNoTelp().equals(UserSingeltonManager.getInstance().getPerson().getNoTelp())&&!controlTransaksi.checkStatusProperty(property)){
                JButton Transaksi = new JButton("Transaksi");
                Transaksi.setBounds(250, height+85, 80, 40);
                Transaksi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        new TransaksiProperty(property);
                    }
                });
                panel.add(Transaksi);
                }
            }
            
            panel.add(labelDaerah);
            panel.add(labelAlamat);
            panel.add(labelDeskrpsi);
            panel.add(labelStatusJualSewa);
            panel.add(labelHarga);
            panel.add(labelTipeProperty);
            panel.add(labelLuasBangunan);
            panel.add(labelLuasTanah);
            panel.add(labelJumlahKamar);
            panel.add(labelPemilik);
            height += 220;
        }
        
        
        //ScrollPane
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setPreferredSize(new Dimension(panel.getComponent(0).getPreferredSize()));
//        scrollPane.setVisible(true);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        frame.add(scrollPane);
        
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
        //not ScrollPane
        frame.add(panel);
    }
}

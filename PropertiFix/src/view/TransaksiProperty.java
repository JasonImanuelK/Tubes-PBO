/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import controller.MethodTransaksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.JenisPembayaran;
import model.Person;
import model.Property;
import model.StatusJualSewa;
import model.TipeProperty;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author patri
 */
public class TransaksiProperty {
    JFrame frameTransaksi;
    JPanel panelTransaksi;
    JLabel alamatProperty,tipeProperty,hargaProperty,statusJualSewa,jenisPembayaran;
    JTextField fieldAlamat,fieldTipe,fieldHarga,fieldStatus;
    JComboBox boxJenisPembayaran;
    
    JButton btnTransaksi,btnBack;
    
    public TransaksiProperty(Property property){
//        Property propertyTransaksi = transaksiGet.getListPropertyUser(idProperty);
//        ControllerProperty control = new ControllerProperty();
//        ArrayList<Property> listProperty = control.getListPropertyUser();
//        Property property = transaksiGet.getPropertyUser(idProperty);
        JenisPembayaran Kredit = JenisPembayaran.Kredit;
        JenisPembayaran Langsung = JenisPembayaran.Langsung;
        String[] listJenisPembayaran = new String[2];
        listJenisPembayaran[0] = Kredit.toString();
        listJenisPembayaran[1] = Langsung.toString();
        
        //ambil instance
        Person person = (User)UserSingeltonManager.getInstance().getPerson();
        
        //frame
        frameTransaksi = new JFrame("Transaksi");
        frameTransaksi.setSize(600, 700);
        frameTransaksi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //panel
        panelTransaksi = new JPanel();
        panelTransaksi.setSize(600,700);
        panelTransaksi.setBackground(new Color(201, 248, 201));
        
        //label
        alamatProperty = new JLabel("Alamat : ");
        alamatProperty.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        alamatProperty.setBounds(50, 90, 200, 40);
        tipeProperty = new JLabel("Tipe : ");
        tipeProperty.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        tipeProperty.setBounds(50, 140, 200, 40);
        hargaProperty = new JLabel("Harga : ");
        hargaProperty.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        hargaProperty.setBounds(50, 190, 200, 40);
        statusJualSewa = new JLabel("Status : ");
        statusJualSewa.setBounds(50, 240, 200, 40);
        statusJualSewa.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        jenisPembayaran = new JLabel("Jenis Pembayaran : ");
        jenisPembayaran.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        jenisPembayaran.setBounds(50, 290, 250, 40);
        
        //field
        fieldAlamat = new JTextField(property.getAlamat());
        fieldAlamat.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        fieldAlamat.setBounds(300, 90, 200, 40);
        fieldAlamat.setEditable(false);
        fieldTipe = new JTextField(property.getTipeProperty().toString());
        fieldTipe.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        fieldTipe.setBounds(300, 140, 200, 40);
        fieldTipe.setEditable(false);
        fieldHarga = new JTextField(property.getHarga().toString());
        fieldHarga.setBounds(300, 190, 200, 40);
        fieldHarga.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        fieldHarga.setEditable(false);
        fieldStatus = new JTextField(property.getStatusJualSewa().toString());
        fieldStatus.setBounds(300, 240, 200, 40);
        fieldStatus.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        fieldStatus.setEditable(false);
        
        //comboBox
        boxJenisPembayaran = new JComboBox(listJenisPembayaran);
        boxJenisPembayaran.setBounds(300, 290, 250, 40);
        
        //button
        btnTransaksi = new JButton("Lakukan Transaksi");
        btnTransaksi.setBounds(50, 340, 250, 40);
        btnBack = new JButton("Back to Main");
        btnBack.setBounds(300, 340, 250, 40);
        
        panelTransaksi.setLayout(null);
        panelTransaksi.add(alamatProperty);
        panelTransaksi.add(tipeProperty);
        panelTransaksi.add(hargaProperty);
        panelTransaksi.add(jenisPembayaran);
        panelTransaksi.add(statusJualSewa);
        
        panelTransaksi.add(fieldAlamat);
        panelTransaksi.add(fieldTipe);
        panelTransaksi.add(fieldHarga);
        panelTransaksi.add(fieldStatus);
        panelTransaksi.add(boxJenisPembayaran);
        panelTransaksi.add(btnTransaksi);
        panelTransaksi.add(btnBack);
        
        frameTransaksi.setLocationRelativeTo(null);
        frameTransaksi.setLayout(null);
        frameTransaksi.add(panelTransaksi);
        frameTransaksi.setVisible(true);
        
        btnTransaksi.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               MethodTransaksi transaksiGet = new MethodTransaksi();
               boolean hasil = transaksiGet.insertTransaksi(property, boxJenisPembayaran.getSelectedItem().toString());
               if(hasil){
                   JOptionPane.showMessageDialog(null,"Berhasil Input");
               } else {
                   JOptionPane.showMessageDialog(null,"GAGAL INPUT","ERROR",JOptionPane.ERROR_MESSAGE);
               }
               frameTransaksi.dispose();
               MainMenu main = new MainMenu();
               main.frameMenu.setVisible(true);
           }
        });
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameTransaksi.dispose();
                MainMenu main = new MainMenu();
                main.frameMenu.setVisible(true);
            }
        });
    }
}

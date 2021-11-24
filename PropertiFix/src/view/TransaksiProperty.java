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
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    JLabel alamatProperty,tipeProperty,hargaProperty,jenisPembayaran;
    JTextField fieldAlamat,fieldTipe,fieldHarga;
    JComboBox boxJenisPembayaran;
    
    public TransaksiProperty(int idProperty){
        idProperty = 6;
        MethodTransaksi transaksiGet = new MethodTransaksi();
//        Property propertyTransaksi = transaksiGet.getListPropertyUser(idProperty);
        ControllerProperty control = new ControllerProperty();
//        ArrayList<Property> listProperty = control.getListPropertyUser();
        Property property = transaksiGet.getPropertyUser(idProperty);
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
        alamatProperty = new JLabel("Nama : ");
        alamatProperty.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        alamatProperty.setBounds(50, 90, 100, 40);
        tipeProperty = new JLabel("Tipe : ");
        tipeProperty.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        tipeProperty.setBounds(50, 140, 100, 40);
        hargaProperty = new JLabel("Harga : ");
        hargaProperty.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        hargaProperty.setBounds(50, 190, 100, 40);
        jenisPembayaran = new JLabel("Jenis Pembayaran : ");
        jenisPembayaran.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        jenisPembayaran.setBounds(50, 240, 100, 40);
        
        //field
        fieldAlamat = new JTextField(property.getAlamat());
        fieldAlamat.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        fieldAlamat.setBounds(150, 90, 100, 40);
        fieldAlamat.setEditable(false);
        fieldTipe = new JTextField(property.getTipeProperty().toString());
        fieldTipe.setFont(new Font("Sans-Serif", Font.BOLD, 25));
        fieldTipe.setBounds(150, 140, 100, 40);
        fieldTipe.setEditable(false);
        fieldHarga = new JTextField(property.getHarga().toString());
        fieldHarga.setBounds(150, 190, 100, 40);
        fieldHarga.setEditable(false);
        
        //comboBox
        boxJenisPembayaran = new JComboBox(listJenisPembayaran);
        boxJenisPembayaran.setBounds(150, 240, 100, 40);
        
        panelTransaksi.setLayout(null);
        panelTransaksi.add(alamatProperty);
        panelTransaksi.add(tipeProperty);
        panelTransaksi.add(hargaProperty);
        panelTransaksi.add(fieldAlamat);
        
        frameTransaksi.setLocationRelativeTo(null);
        frameTransaksi.setLayout(null);
        frameTransaksi.add(panelTransaksi);
        frameTransaksi.setVisible(true);
    }
}

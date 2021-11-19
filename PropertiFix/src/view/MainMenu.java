/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import controller.MethodWilayah;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import model.Daerah;
import model.Property;
import model.StatusJualSewa;
import model.UserSingeltonManager;

/**
 *
 * @author Aloysius
 */
public class MainMenu {
    JFrame frameMenu, frameFormProperty, frameLihatProperty, frameLihatDaerah;
    ControllerProperty controllerProperty = new ControllerProperty();
    MethodWilayah controllerWilayah = new MethodWilayah();
    
    public MainMenu(){
        //Frame
        createFrame();

        //Panel
        JPanel panel = new JPanel();
        panel.setSize(450, 400);
        panel.setBackground(new Color(201, 248, 201));
        
        //Label
        JLabel labelJudul = new JLabel("Main Menu");
        labelJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelJudul.setBounds(130, 30, 200, 40);
        
        
        //Button
//        JButton btnDaerah = new JButton("Lihat Daerah");
//        btnDaerah.setBounds(90, 240, 120, 40);
//        btnDaerah.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frameMenu.setVisible(false);
////                new TampilanWilayah(frameMenu);
//            }
//        });
        
        JButton btnInputProperti = new JButton("Input Properti");
        btnInputProperti.setBounds(220, 240, 120, 40);
        btnInputProperti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.setVisible(false);
                tampilanFormProperty(null);
            }
        });
        
//        JButton btnProperty = new JButton("Lihat Property");
//        btnProperty.setBounds(90, 120, 120, 40);
//        btnProperty.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });
//        
//        JButton btnUser = new JButton("Lihat User");
//        btnUser.setBounds(220, 120, 120, 40);
//        btnUser.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });
//        
//        JButton btnTransaksi = new JButton("Lihat Transaksi");
//        btnTransaksi.setBounds(150, 180, 140, 40);
//        btnTransaksi.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });
//        
//        JButton btnLogOut = new JButton("Log-Out");
//        btnLogOut.setBounds(320, 315, 100, 30);
//        btnLogOut.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//                new Login();
//            }
//        });
        
        panel.setLayout(null);
        panel.setVisible(true);
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setLayout(null);
        frameMenu.setVisible(true);
        
        frameMenu.add(panel);
        panel.add(labelJudul);
        panel.add(btnInputProperti);
//        panel.add(btnDaerah);
//        panel.add(btnInputDaerah);
//        panel.add(btnProperty);
//        panel.add(btnUser);
//        panel.add(btnLogOut);
    }
    
    
    private void createFrame(){
        frameMenu = new JFrame("Main Menu");
        frameMenu.setSize(450, 400);
        frameMenu.setLayout(null);
        frameMenu.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameMenu.dispose();
                UserSingeltonManager.getInstance().setPerson(null);
                new Login();
            }
        });
        
        frameFormProperty = new JFrame("Form Property");
        frameFormProperty.setSize(380, 640);
        frameFormProperty.setLayout(null);
        windowClosingListener(frameFormProperty);
        
    }
    
    void windowClosingListener(JFrame frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.setVisible(false);
                frameMenu.setVisible(true);
            }
        });
    }
    
    private void tampilanFormProperty(Property property){
        frameFormProperty.getContentPane().removeAll();
        frameFormProperty.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setSize(380, 640);
        panel.setLayout(null);
        panel.setBackground(new Color(201, 248, 201));
        
        JLabel labelDaerah = new JLabel("Daerah");
        labelDaerah.setBounds(10, 10, 100, 40);
        
        ArrayList<String> listDaerah = controllerWilayah.getStringDaerah();
        String[] arrayDaerah = new String[listDaerah.size()];
        arrayDaerah = listDaerah.toArray(arrayDaerah);
        JComboBox comboDaerah = new JComboBox(arrayDaerah);
        comboDaerah.setBounds(135, 13, 150, 30);
        
        JLabel labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(10, 60, 100, 40);
        JTextField textAlamat = new JTextField();
        textAlamat.setBounds(135, 63, 150, 30);
        
        JLabel labelDeskripsi = new JLabel("Deskripsi Bangunan");
        labelDeskripsi.setBounds(10, 110, 160, 40);
        JTextArea textDeskripsi = new JTextArea();
        textDeskripsi.setLineWrap(true);
        textDeskripsi.setBounds(135, 113, 150, 130);
        
        JLabel labelStatusJualSewa = new JLabel("Jual / Sewa");
        labelStatusJualSewa.setBounds(10, 260, 160, 40);
        String[] arrayStatusJualSewa = {StatusJualSewa.JUAL.toString(), StatusJualSewa.SEWA.toString()};
        JComboBox comboStatusJualSewa = new JComboBox(arrayStatusJualSewa);
        comboStatusJualSewa.setBounds(135, 263, 150, 30);
        
        JLabel labelHarga = new JLabel("Harga");
        labelHarga.setBounds(10, 310, 160, 40);
        Long intial = Long.valueOf(0);
        Long min = Long.valueOf(0);
        Long max = Long.MAX_VALUE;
        Long step = Long.valueOf(1000000);
        SpinnerModel modelHarga = new SpinnerNumberModel(intial, min, max, step);
        JSpinner spinnerHarga = new JSpinner(modelHarga);
        spinnerHarga.setBounds(135, 313, 150, 30);
        
        JLabel labelTipeProperty = new JLabel("Tipe Property");
        labelTipeProperty.setBounds(10, 360, 160, 40);
        JRadioButton radioRumah = new JRadioButton("Rumah");
        radioRumah.setBounds(135, 363, 75, 30);
        JRadioButton radioApartemen = new JRadioButton("Apartemen");
        radioApartemen.setBounds(215, 363, 100, 30);
        ButtonGroup groupTipeProperty = new ButtonGroup();
        groupTipeProperty.add(radioRumah);groupTipeProperty.add(radioApartemen);
        
        JLabel labelLuasBangunan = new JLabel("Luas Bangunan");
        labelLuasBangunan.setBounds(10, 410, 160, 40);
        JSpinner spinnerLuasBangunan = new JSpinner(new SpinnerNumberModel(0,0,99999999,1));
        spinnerLuasBangunan.setBounds(135, 413, 150, 30);
        JLabel besaranLuasBangunan = new JLabel("Meter persegi");
        besaranLuasBangunan.setBounds(295, 410, 160, 40);
        besaranLuasBangunan.setFont(new Font("Sans-Serif", Font.ITALIC, 10));
        
        JLabel labelLuasTanah = new JLabel("Luas Tanah");
        labelLuasTanah.setBounds(10, 460, 160, 40);
        JSpinner spinnerLuasTanah = new JSpinner(new SpinnerNumberModel(0,0,99999999,1));
        spinnerLuasTanah.setBounds(135, 463, 150, 30);
        JLabel besaranLuasTanah = new JLabel("Meter persegi");
        besaranLuasTanah.setBounds(295, 460, 160, 40);
        besaranLuasTanah.setFont(new Font("Sans-Serif", Font.ITALIC, 10));
        
        JLabel labelJumlahKamar = new JLabel("Jumlah kamar");
        labelJumlahKamar.setBounds(10, 510, 160, 40);
        JSpinner spinnerJumlahKamar = new JSpinner(new SpinnerNumberModel(0,0,9999,1));
        spinnerJumlahKamar.setBounds(135, 513, 150, 30);
        
        //Button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(50, 560, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textAlamat.getText().isEmpty() && !textDeskripsi.getText().isEmpty() && (radioRumah.isSelected() || radioApartemen.isSelected())){
                    String[] splitDaerah = String.valueOf(comboDaerah.getSelectedItem()).split(", ");
                    Daerah daerah = new Daerah(splitDaerah[1], splitDaerah[0]);
                    String stringStatusJualSewa = String .valueOf(comboStatusJualSewa.getSelectedItem());
                    
                    BigInteger hargaProperty = BigInteger.valueOf((Long) spinnerHarga.getValue());

                    int tipeProperty;
                    if(radioRumah.isSelected()){
                        tipeProperty = 1;
                    }else{
                        tipeProperty = 2;
                    }
                    
                    Property property = new Property(daerah, textAlamat.getText(), textDeskripsi.getText(), StatusJualSewa.valueOf(stringStatusJualSewa), hargaProperty, tipeProperty, (Integer) spinnerLuasBangunan.getValue(), (Integer) spinnerLuasTanah.getValue(), (Integer) spinnerJumlahKamar.getValue(), false);
                    if(controllerProperty.inputProperty(property)){
                        JOptionPane.showMessageDialog(null, "Input berhasil");
                        frameFormProperty.dispose();
                        frameMenu.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Input Gagal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Data belum lengkap");
                }
                
            }
        });
        
        
        if(property != null){
            //untuk update property
        }
        
        
        panel.add(labelDaerah);
        panel.add(comboDaerah);
        panel.add(labelAlamat);
        panel.add(labelDeskripsi);
        panel.add(textAlamat);
        panel.add(textDeskripsi);
        panel.add(labelStatusJualSewa);
        panel.add(comboStatusJualSewa);
        panel.add(btnSubmit);
        panel.add(labelHarga);
        panel.add(spinnerHarga);
        panel.add(labelTipeProperty);
        panel.add(radioRumah);
        panel.add(radioApartemen);
        panel.add(labelLuasBangunan);
        panel.add(spinnerLuasBangunan);
        panel.add(besaranLuasBangunan);
        panel.add(labelLuasTanah);
        panel.add(spinnerLuasTanah);
        panel.add(besaranLuasTanah);
        panel.add(labelJumlahKamar);
        panel.add(spinnerJumlahKamar);
        
        frameFormProperty.add(panel);
    }
    
}

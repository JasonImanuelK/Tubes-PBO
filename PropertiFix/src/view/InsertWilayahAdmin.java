/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Wilayah;
import controller.MethodWilayah;
import javax.swing.JTextArea;

/**
 *
 * @author jason
 */
public class InsertWilayahAdmin {
    JFrame frame;
    JPanel panel;
    JLabel labelJudul,labelProvinsi,labelKota,labelDeskripsi;
    JButton btnSubmit;
    JTextField txtProvinsi,txtKota;
    JTextArea txtDeskripsi;
    
    public InsertWilayahAdmin(){
        MethodWilayah met = new MethodWilayah();
        
        //Frame
        frame = new JFrame("Input Wilayah Baru");
        frame.setSize(330, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        panel = new JPanel();
        panel.setSize(330, 430);
        panel.setBackground(new Color(201, 248, 201));
        
        //Label
        labelJudul = new JLabel("Input Daerah");
        labelJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelJudul.setBounds(50, 30, 200, 40);
        labelProvinsi = new JLabel("Provinsi : ");
        labelProvinsi.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelProvinsi.setBounds(30, 90, 100, 40);
        labelKota = new JLabel("Kota : ");
        labelKota.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelKota.setBounds(30, 140, 100, 40);
        labelDeskripsi = new JLabel("Deskripsi : ");
        labelDeskripsi.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelDeskripsi.setBounds(30, 190, 100, 40);
        
        //TextField
        txtProvinsi = new JTextField();
        txtProvinsi.setBounds(130, 90, 150, 30);
        txtKota = new JTextField();
        txtKota.setBounds(130, 140, 150, 30);
        txtDeskripsi = new JTextArea();
        txtDeskripsi.setLineWrap(true);
        txtDeskripsi.setBounds(130, 190, 150, 130);
        
        //Button
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(50, 340, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtProvinsi.getText().equals("") || !txtKota.getText().equals("")||!txtDeskripsi.getText().equals("")){
                    frame.setVisible(false);
                    Wilayah newWilayah = new Wilayah(txtProvinsi.getText(),txtKota.getText(),txtDeskripsi.getText());
                    boolean hasil = met.insertWilayahBaru(newWilayah);
                    if(hasil){
                        JOptionPane.showMessageDialog(null, "Data sudah diproses.", "Input Wilayah", JOptionPane.INFORMATION_MESSAGE);                                          
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Data gagal dimasukan.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    
                    JOptionPane.showMessageDialog(null, "Tolong isi dulu textfieldnya !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        frame.add(panel);
        panel.add(labelJudul);
        panel.add(labelProvinsi);
        panel.add(labelKota);
        panel.add(labelDeskripsi);
        panel.add(txtProvinsi);
        panel.add(txtKota);
        panel.add(txtDeskripsi);
        panel.add(btnSubmit);
        
    }
}

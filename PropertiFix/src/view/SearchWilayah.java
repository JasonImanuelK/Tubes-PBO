/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MethodLogin;
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

/**
 *
 * @author User
 */
public class SearchWilayah {
    JFrame frame;
    JPanel panel;
    JLabel labelJudul, labelProvinsi, labelKota;
    JTextField txtProvinsi, txtKota;
    JButton btnSearch,btnBack;
    MethodLogin methodLogin = new MethodLogin();
    
    public SearchWilayah(){
        //Frame
        frame = new JFrame("Cari Informasi Wilayah");
        frame.setSize(330, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        panel = new JPanel();
        panel.setSize(330, 430);
        panel.setBackground(new Color(201, 248, 201));
        
        //Label
        labelJudul = new JLabel("Search");
        labelJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelJudul.setBounds(120, 30, 200, 40);
        labelProvinsi = new JLabel("Provinsi : ");
        labelProvinsi.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelProvinsi.setBounds(30, 90, 100, 40);
        labelKota = new JLabel("Kota : ");
        labelKota.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelKota.setBounds(30, 140, 100, 40);
        
        //TextField
        txtProvinsi = new JTextField();
        txtProvinsi.setBounds(130, 98, 150, 30);
        txtKota = new JTextField();
        txtKota.setBounds(130, 148, 150, 30);
        
        //Button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(50, 200, 100, 30);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtProvinsi.getText().isEmpty() && txtKota.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Provinsi atau kota belum diisi !", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    frame.dispose();
                    new TampilanWilayah(txtProvinsi.getText(),txtKota.getText());
                }
            }
        });
        
        //Button
        btnBack = new JButton("Back");
        btnBack.setBounds(170, 200, 100, 30);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
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
        panel.add(txtProvinsi);
        panel.add(txtKota);
        panel.add(btnSearch);
        panel.add(btnBack);
    }
}

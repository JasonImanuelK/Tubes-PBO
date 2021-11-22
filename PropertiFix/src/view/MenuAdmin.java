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

/**
 *
 * @author jason
 */
public class MenuAdmin {
    JFrame frame;
    JPanel panel;
    JLabel labelJudul;
    JButton btnProperty,btnDaerah,btnInputDaerah,btnUser,btnTransaksi, btnLogOut;
    
    public MenuAdmin(){
        
        //Frame
        frame = new JFrame("Menu Admin");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        panel = new JPanel();
        panel.setSize(450, 400);
        panel.setBackground(new Color(201, 248, 201));
        
        //Label
        labelJudul = new JLabel("Menu Admin");
        labelJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelJudul.setBounds(130, 30, 200, 40);
        
        
        //Button
        btnDaerah = new JButton("Lihat Daerah");
        btnDaerah.setBounds(90, 240, 120, 40);
        btnDaerah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new TampilanWilayah(frame);
            }
        });
        
        btnInputDaerah = new JButton("Input Daerah");
        btnInputDaerah.setBounds(220, 240, 120, 40);
        btnInputDaerah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new InsertWilayahAdmin(frame);
            }
        });
        
        btnProperty = new JButton("Lihat Property");
        btnProperty.setBounds(90, 120, 120, 40);
        btnProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        btnUser = new JButton("Lihat User");
        btnUser.setBounds(220, 120, 120, 40);
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new TampilanUser(frame);
            }
        });
        
        btnTransaksi = new JButton("Lihat Transaksi");
        btnTransaksi.setBounds(150, 180, 140, 40);
        btnTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        btnLogOut = new JButton("Log-Out");
        btnLogOut.setBounds(320, 315, 100, 30);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });
        
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        frame.add(panel);
        panel.add(labelJudul);
        panel.add(btnTransaksi);
        panel.add(btnDaerah);
        panel.add(btnInputDaerah);
        panel.add(btnProperty);
        panel.add(btnUser);
        panel.add(btnLogOut);
    }
}

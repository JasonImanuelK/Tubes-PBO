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
import model.TipeProperty;
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
                frameMenu.dispose();
                new FormProperty(null);
            }
        });
        
        JButton btnLihatPropertyUser = new JButton("Lihat Property User");
        btnLihatPropertyUser.setBounds(90, 120, 120, 40);
        btnLihatPropertyUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                new LihatPropertyUser();
            }
        });
//        
        JButton buttonEditProfile = new JButton("Edit Profile");
        buttonEditProfile.setBounds(220, 120, 120, 40);
        buttonEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                new EditProfile();
            }
        });
//        
        JButton btnLihatProperty = new JButton("Lihat Semua Property");
        btnLihatProperty.setBounds(150, 180, 140, 40);
        btnLihatProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                //masuk ke filter
            }
        });
//        
        JButton btnLogOut = new JButton("Log-Out");
        btnLogOut.setBounds(320, 315, 100, 30);
        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                UserSingeltonManager.getInstance().setPerson(null);
                new Login();
            }
        });
        
        panel.setLayout(null);
        panel.setVisible(true);
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setLayout(null);
        frameMenu.setVisible(true);
        
        frameMenu.add(panel);
        panel.add(labelJudul);
        panel.add(btnInputProperti);
//        panel.add(btnDaerah);
        panel.add(btnLihatProperty);
        panel.add(btnLihatPropertyUser);
        panel.add(buttonEditProfile);
        panel.add(btnLogOut);
    }
    
}

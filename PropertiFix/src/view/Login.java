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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author User
 */
public class Login {
    JFrame frame;
    JPanel panel;
    JLabel labelJudul, labelUsername, labelPassword;
    JTextField textFieldUsername;
    JPasswordField passFieldPassword;
    JButton buttonLogin, buttonRegister;
    MethodLogin methodLogin = new MethodLogin();
    
    public Login(){
        //Frame
        frame = new JFrame("Login");
        frame.setSize(330, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        panel = new JPanel();
        panel.setSize(330, 430);
        panel.setBackground(new Color(201, 248, 201));
        
        //Label
        labelJudul = new JLabel("Login");
        labelJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelJudul.setBounds(120, 30, 200, 40);
        labelUsername = new JLabel("Username");
        labelUsername.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelUsername.setBounds(30, 90, 100, 40);
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelPassword.setBounds(30, 140, 100, 40);
        
        //TextField
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(130, 98, 150, 30);
        passFieldPassword = new JPasswordField();
        passFieldPassword.setBounds(130, 148, 150, 30);
        
        //Button
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(50, 200, 100, 30);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldUsername.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Username Belum Diisi!", "Login", JOptionPane.INFORMATION_MESSAGE);
                }else if (passFieldPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Password Belum Diisi!", "Login", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    boolean checkUser = methodLogin.checkUser(textFieldUsername.getText(), new String(passFieldPassword.getPassword()));
                    if (checkUser) {
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, "Login Berhasil", "Login", JOptionPane.INFORMATION_MESSAGE);
                        //Hans inigw masukin menu admin buat coba doang , kl nanti ceknya dr checkUser aja returnnya ganti ke int jangan boolean ty.
                        new MenuAdmin();
                    }else{
                        JOptionPane.showMessageDialog(null, "Username/Password Tidak Ditemukan!", "Login", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Silahkan Melakukan Register Jika Belum Memiliki Akun", "Login", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        
        //Button
        buttonRegister = new JButton("Register");
        buttonRegister.setBounds(170, 200, 100, 30);
        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Registrasi();
            }
        });
        
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        frame.add(panel);
        panel.add(labelJudul); 
        panel.add(labelUsername);
        panel.add(labelPassword);
        panel.add(textFieldUsername);
        panel.add(passFieldPassword);
        panel.add(buttonLogin);
        panel.add(buttonRegister);   
    }
}

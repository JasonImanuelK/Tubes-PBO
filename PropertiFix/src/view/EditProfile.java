/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MethodEditProfile;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.InterfacePesan;
import model.Member;
import model.Person;
import model.StatusPerson;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author User
 */
public class EditProfile implements InterfacePesan{
    JFrame frame;
    JPanel panel;
    JLabel labelJudul, labelNama, labelEmail, labelPassword, labelNomorTelepon;
    JTextField textFieldNama, textFieldEmail, textFieldNomorTelepon;
    JPasswordField passFieldPassword;
    JComboBox comboNamaKategori;
    JButton buttonLogin, buttonBack;
    MethodEditProfile methodEditProfile = new MethodEditProfile();
    
    public EditProfile(){
        //Frame
        frame = new JFrame("Edit Profile");
        frame.setSize(330, 430);
        windowClosingListener(frame);

        //Panel
        panel = new JPanel();
        panel.setSize(330, 430);
        panel.setBackground(new Color(201, 248, 201));
        
        //Label
        labelJudul = new JLabel("Edit Profile");
        labelJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelJudul.setBounds(90, 30, 200, 40);
        labelNama = new JLabel("Nama");
        labelNama.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelNama.setBounds(30, 90, 100, 40);
        labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelEmail.setBounds(30, 140, 100, 40);
        labelNomorTelepon = new JLabel("No. Telepon");
        labelNomorTelepon.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelNomorTelepon.setBounds(30, 190, 100, 40);
        labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        labelPassword.setBounds(30, 240, 100, 40);
        
        //TextField
        textFieldNama = new JTextField(UserSingeltonManager.getInstance().getPerson().getNama());
        textFieldNama.setBounds(130, 98, 150, 30);
        textFieldEmail = new JTextField(UserSingeltonManager.getInstance().getPerson().getEmail());
        textFieldEmail.setBounds(130, 148, 150, 30);
        textFieldNomorTelepon = new JTextField(UserSingeltonManager.getInstance().getPerson().getNoTelp());
        textFieldNomorTelepon.setBounds(130, 198, 150, 30);
        
        //PasswordField
        passFieldPassword = new JPasswordField(UserSingeltonManager.getInstance().getPerson().getPassword());
        passFieldPassword.setBounds(130, 248, 150, 30);
        
        //Button
        buttonLogin = new JButton("Edit Profile");
        buttonLogin.setBounds(50, 340, 100, 30);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkPassword = String.valueOf(passFieldPassword.getPassword());
                if (checkPassword.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password kurang dari 8 huruf!", "Edit Profile", JOptionPane.INFORMATION_MESSAGE);  
                }else{
                    Person person = new User(textFieldNama.getText(), textFieldNomorTelepon.getText(), String.valueOf(passFieldPassword.getPassword()), textFieldEmail.getText(), StatusPerson.USER, Member.BRONZE);                                                                                                   
                    if (methodEditProfile.updateDataUser(person)) {
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, updateBerhasil, "Edit Profile", JOptionPane.INFORMATION_MESSAGE);
                        new MainMenu();
                    }else{
                        JOptionPane.showMessageDialog(null, updateGagal, "Edit Profile", JOptionPane.INFORMATION_MESSAGE);  
                    }
                }
            }
        });
        
        //Button
        buttonBack = new JButton("Back");
        buttonBack.setBounds(170, 340, 100, 30);
        buttonBack.addActionListener(new ActionListener() {
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
        panel.add(labelNama);
        panel.add(labelEmail);
        panel.add(labelNomorTelepon);
        panel.add(labelPassword);
        panel.add(textFieldNama);
        panel.add(textFieldEmail);
        panel.add(textFieldNomorTelepon);
        panel.add(passFieldPassword);
        panel.add(buttonLogin);
        panel.add(buttonBack);
    }
    
    void windowClosingListener(JFrame frame) {
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.dispose();
                new Login();
            }
        });
    }
}

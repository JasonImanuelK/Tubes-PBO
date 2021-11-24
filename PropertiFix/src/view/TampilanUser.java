/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MethodUser;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.InterfacePesan;
import model.Member;
import model.User;

/**
 *
 * @author jason
 */
public class TampilanUser implements InterfacePesan{
    JFrame frame;
    JPanel panelButton;
    JButton btnBack;
    MethodUser met = new MethodUser();
    public TampilanUser(JFrame frameMenu){
        //Frame
        frame = new JFrame("Users");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelButton = new JPanel();
        panelButton.setSize(200, 200);
        panelButton.setBackground(new Color(201, 248, 201));
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameMenu.setVisible(true);
            }
        });
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        ArrayList <User> listUser = met.getSemuaDataUser();
        
        if(listUser.size() == 0){
            
        }
        else{
            for(int i = 0;i < listUser.size();i++){
                JLabel labelNama = new JLabel(listUser.get(i).getNama());
                JLabel labelNoTelp = new JLabel(listUser.get(i).getNoTelp());
                JLabel labelEmail = new JLabel(listUser.get(i).getEmail());
                JLabel labelMember = new JLabel(listUser.get(i).getMember().toString());
                JButton btnUpgrade = new JButton("Upgrade");
                JButton btnDelete = new JButton("Delete");
                btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Boolean hasil = met.deleteUser(labelNama.getText(),labelEmail.getText());
                    if(hasil){
                        JOptionPane.showMessageDialog(null, hapusBerhasil, "Deleted", JOptionPane.INFORMATION_MESSAGE); 
                        btnDelete.setEnabled(false);
                        btnUpgrade.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, hapusGagal, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }});

                
                btnUpgrade.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Boolean hasil = true; //bikin method Update dan rubah text. 
                    int indikator = 2;
                    if(labelMember.getText().equals(Member.BRONZE.toString())){
                        hasil = met.updateData(labelNama.getText(),labelEmail.getText(),Member.SILVER.toString());
                        labelMember.setText(Member.SILVER.toString());
                        indikator = 0;
                    }
                    else if(labelMember.getText().equals(Member.SILVER.toString())){
                        hasil = met.updateData(labelNama.getText(),labelEmail.getText(),Member.GOLD.toString());
                        labelMember.setText(Member.GOLD.toString());
                        indikator = 1;
                    }
                    
                    if(indikator == 2){
                        JOptionPane.showMessageDialog(null, "Member User sudah yang tertinggi.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(hasil){
                        JOptionPane.showMessageDialog(null, updateBerhasil, "Upgraded", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null, updateGagal, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }});
                
                frame.add(new GroupPanelUser(i, labelNama, labelNoTelp, labelEmail, labelMember, btnDelete, btnUpgrade));
            }
        }
        
        
        panelButton.add(btnBack);
        frame.add(panelButton);
        frame.add(Box.createVerticalGlue());
        frame.pack();
        panelButton.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
        
    }
    
}

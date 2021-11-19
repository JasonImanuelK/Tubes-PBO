/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Daerah;
import controller.MethodWilayah;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Wilayah;

/**
 *
 * @author jason
 */
public class TampilanWilayah {
    JFrame frame;
    JPanel panelButton;
    JButton btnBack;
    MethodWilayah met = new MethodWilayah();
    public TampilanWilayah(JFrame frameMenu){
        //Frame
        frame = new JFrame("Deskripsi Wilayah");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelButton = new JPanel();
        panelButton.setSize(200, 200);
        panelButton.setBackground(new Color(201, 248, 251));
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frameMenu.setVisible(true);
            }
        });
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        ArrayList <Wilayah> listWilayah = met.getSemuaWilayah();
        for(int i = 0;i < listWilayah.size();i++){
            JLabel labelProvinsi = new JLabel(listWilayah.get(i).getProvinsi());
            JLabel labelKota = new JLabel(listWilayah.get(i).getKota());
            JLabel labelDeskripsi = new JLabel(listWilayah.get(i).getDeskripsiWilayah());
            JButton btnDelete = new JButton("Delete");
            btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasil = met.deleteWilayah(labelKota.getText());
                if(hasil){
                    JOptionPane.showMessageDialog(null, "Wilayah sudah dihapus.", "Deleted", JOptionPane.INFORMATION_MESSAGE);                                          
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wilayah gagal dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                btnDelete.setEnabled(false);
            }
            });
            frame.add(new GroupPanel(i,labelProvinsi,labelKota,labelDeskripsi,btnDelete));
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

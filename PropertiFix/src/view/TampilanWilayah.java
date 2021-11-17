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
import javax.swing.JButton;

/**
 *
 * @author jason
 */
public class TampilanWilayah {
    JFrame frame;
    JScrollPane sPanel;
    JPanel mainPanel,panelButton;
    JLabel label;
    ArrayList<JPanel> panelDaerah= new ArrayList<>();
    ArrayList<JButton> btnDeleteDaerah= new ArrayList<>();
    ArrayList<JLabel> labelKota= new ArrayList<>();
    ArrayList<JLabel> labelProvinsi = new ArrayList<>();
    ArrayList<JLabel> labelDeskripsi= new ArrayList<>();
    MethodWilayah met = new MethodWilayah();
    public TampilanWilayah(JFrame frameMenu){
        //Frame
        frame = new JFrame("Deskripsi Wilayah");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        mainPanel = new JPanel();
        mainPanel.setSize(400, 600);
        mainPanel.setBackground(new Color(201, 248, 201));
        
        ArrayList <Daerah> listDaerah = met.getSemuaDaerah();
        for(int i = 0;i < listDaerah.size();i++){
            panelDaerah.add(new JPanel());
            panelDaerah.get(panelDaerah.size()-1).setBounds(0,i*200,200,200);
        }
        
        panelButton = new JPanel();
        panelButton.setSize(500, 600);
        panelButton.setBackground(new Color(201, 248, 251));
        
        //label
        label = new JLabel("makan bang.");
        label.setBounds(60,60,60,60);
        
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setVisible(true);
        panelButton.setLayout(null);
        panelButton.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        panelButton.add(label);
        mainPanel.add(panelButton);
        sPanel = new JScrollPane(mainPanel);
        sPanel.setSize(400, 600);
        frame.add(sPanel);
        
    }
    
}

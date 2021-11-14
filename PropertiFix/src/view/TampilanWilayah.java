/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author jason
 */
public class TampilanWilayah {
    JFrame frame;
    JScrollPane sPanel;
    JPanel mainPanel,panel;
    JLabel label;
    public TampilanWilayah(){
        //Frame
        frame = new JFrame("Deskripsi Wilayah");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel
        mainPanel = new JPanel();
        mainPanel.setSize(400, 600);
        mainPanel.setBackground(new Color(201, 248, 201));
        
        panel = new JPanel();
        panel.setSize(200, 800);
        panel.setBackground(new Color(201, 248, 251));
        
        //label
        label = new JLabel("makan bang.");
        label.setBounds(60,60,60,60);
        
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        
        panel.add(label);
        mainPanel.add(panel);
        sPanel = new JScrollPane(mainPanel);
        sPanel.setSize(400, 600);
        frame.add(sPanel);
        
    }
    
}

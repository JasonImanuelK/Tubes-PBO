/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Property;
/**
 *
 * @author patri
 */
public class lihatpropertyUserbarupakeScroll {
    JFrame frame;
    JPanel panel,panelTable,panelButton;
    JTable tableData;
    JScrollPane tableDataScroll;
    ControllerProperty controllerProperty = new ControllerProperty();
    JButton buttonBack;
    
    public lihatpropertyUserbarupakeScroll(ArrayList<Property> listProperty){
        ControllerProperty control = new ControllerProperty();
//        ArrayList<Property> listProperty = control.getListPropertyUser();
        String[] column = {"KodeProperty","Alamat","Deskripsi Bangunan","Status","Harga","Tipe Property","Luas Bangunan","Luas Tanah","Jumlah Kamar"};
        String[][] data = control.getListAllProperty();
        
        frame = new JFrame("Lihat Property");
        frame.setSize(380, 640);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.dispose();
                new MainMenu();
            }
        });
        
        //panel
        panel = new JPanel(new BorderLayout());
        
        //table
        tableData = new JTable(data,column);
        tableData.setSize(400,200);
        tableData.setDefaultEditor(Object.class, null);
        
        //scroll pane
        tableDataScroll = new JScrollPane(tableData);
        tableDataScroll.setBounds(50,300,10,30);
        
        //button
        buttonBack = new JButton("Back");
        
        panelTable = new JPanel();
        panelTable.add(tableDataScroll,BorderLayout.CENTER);
        panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.add(buttonBack);
        
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
        
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainMenu main = new MainMenu();
                main.frameMenu.setVisible(true);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import java.util.ArrayList;
import javax.swing.JFrame;

import model.Property;
/**
 *
 * @author patri
 */
public class lihatpropertyUserbarupakeScroll {
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public lihatpropertyUserbarupakeScroll(ArrayList<Property> listProperty){
        ControllerProperty control = new ControllerProperty();
//        ArrayList<Property> listProperty = control.getListPropertyUser();
        String[] column = {"Provinsi","Kota","Alamat","Deskripsi Bangunan","Status","Harga","Tipe Property","Luas Bangunan","Luas Tanah","Jumlah Kamar"};
        
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
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import controller.MethodTransaksi;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Property;
import model.Transaksi;

/**
 *
 * @author patri
 */
public class LihatTransaksi {
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    public LihatTransaksi(){
        frame = new JFrame("Lihat Transaksi");
        frame.setSize(480, 640);
        frame.setLayout(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(10, 10, 440, 640);
        
        MethodTransaksi methodTransaksi = new MethodTransaksi();
        ArrayList<Transaksi> listTransaksi = methodTransaksi.getListTransaksiUser();
        ControllerProperty controlProperty = new ControllerProperty();
        ArrayList<Property> listProperty = controlProperty.getAllProperty();
        
        int height = 30;
        for (int i = 0; i < listTransaksi.size(); i++) {
            Transaksi transaksi = (listTransaksi.get(i));
            if(transaksi.getIdProperty()==listProperty.get(i).getKodeProperti()){
                JLabel labelAlamat = new JLabel(listProperty.get(i).getAlamat());
                labelAlamat.setBounds(10, height, 300, 20);
                JLabel labelHarga = new JLabel(listProperty.get(i).getDeskripsiBangunan());
                labelHarga.setBounds(10,height+20,300,20);
            }

        }
    }
}

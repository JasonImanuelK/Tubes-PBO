/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProperty;
import controller.MethodTransaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Admin;
import static model.InterfacePesan.hapusBerhasil;
import static model.InterfacePesan.hapusGagal;
import model.Property;
import model.Transaksi;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author patri
 */
public class LihatTransaksiAdmin {
    JFrame frame;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public LihatTransaksiAdmin(){
        frame = new JFrame("Lihat Transaksi");
        frame.setSize(480, 640);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBounds(10, 10, 440, 640);
        
        MethodTransaksi Methodtransaksi = new MethodTransaksi();
        ArrayList<Transaksi> listTransaksi = Methodtransaksi.getListTransaksiAdmin();
        
        int height = 30;
        for (int i = 0; i < listTransaksi.size(); i++) {
            Transaksi transaksi = (listTransaksi.get(i));
            JLabel labelDaerah = new JLabel("id Transaksi : " + transaksi.getIdTransaksi());
            labelDaerah.setBounds(10, height, 300, 20);
            JLabel labelAlamat = new JLabel("id User : " + transaksi.getIdPengguna());
            labelAlamat.setBounds(10, height+20, 300, 20);
            JLabel labelDeskrpsi = new JLabel("id Property : " + transaksi.getIdProperty());
            labelDeskrpsi.setBounds(10, height+40, 300, 20);
            JLabel labelStatusJualSewa = new JLabel("Jenis Pembayaran : " + transaksi.getJenispembayaran());
            labelStatusJualSewa.setBounds(10, height+60, 300, 20);
            JLabel labelHarga = new JLabel("Status pembayaran : " + transaksi.getStatuspembayaran());
            labelHarga.setBounds(10, height+80, 300, 20);
            
//            User pemilikProperty = property.getUser();
//            JLabel labelPemilik = new JLabel("Pemilik : " + pemilikProperty.getNama() + " - " + pemilikProperty.getNoTelp());
//            labelPemilik.setBounds(10, height+180, 300, 20);
            
            if(UserSingeltonManager.getInstance().getPerson() instanceof Admin){
                JButton lunas = new JButton("Lunas");
                lunas.setBounds(250, height+85, 80, 40);
                lunas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        MethodTransaksi methodTransaksi = new MethodTransaksi();
                        if(methodTransaksi.lunasTransaksi(transaksi.getIdTransaksi())){
                            JOptionPane.showMessageDialog(null,"Berhasil");
                            new MenuAdmin();
                        } else {
                            JOptionPane.showMessageDialog(null, "gagal");
                            new LihatTransaksiAdmin();
                        }
                    }
                });
                
//                JButton delete = new JButton("Delete");
//                delete.setBounds(350, height+85, 80, 40);
//                delete.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        frame.dispose();
//                        if(controllerProperty.deleteProperty(property)){
//                            JOptionPane.showMessageDialog(null, hapusBerhasil);
//                            new MenuAdmin();
//                        }else{
//                            JOptionPane.showMessageDialog(null, hapusGagal);
//                        }
//                    }
//                });
                
                panel.add(lunas);
//                panel.add(delete);
//            } else {
//                MethodTransaksi controlTransaksi = new MethodTransaksi();
//                if(!pemilikProperty.getNama().equals(UserSingeltonManager.getInstance().getPerson().getNama())&&!pemilikProperty.getNoTelp().equals(UserSingeltonManager.getInstance().getPerson().getNoTelp())&&!controlTransaksi.checkStatusProperty(property)){
//                JButton Transaksi = new JButton("Transaksi");
//                Transaksi.setBounds(250, height+85, 80, 40);
//                Transaksi.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        frame.dispose();
//                        new TransaksiProperty(property);
//                    }
//                });
//                panel.add(Transaksi);
//                }
            }
            
            panel.add(labelDaerah);
            panel.add(labelAlamat);
            panel.add(labelDeskrpsi);
            panel.add(labelStatusJualSewa);
            panel.add(labelHarga);
//            panel.add(labelTipeProperty);
//            panel.add(labelLuasBangunan);
//            panel.add(labelLuasTanah);
//            panel.add(labelJumlahKamar);
//            panel.add(labelPemilik);
            height += 220;
        }
        
        
        //ScrollPane
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setPreferredSize(new Dimension(panel.getComponent(0).getPreferredSize()));
//        scrollPane.setVisible(true);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        frame.add(scrollPane);
        
        JButton back = new JButton("Back");
        back.setBounds(0, 0, 80, 20);
        if(UserSingeltonManager.getInstance().getPerson() instanceof User){
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MainMenu();
                }
            });
        }else{
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MenuAdmin();
                }
            });
        }
        
        frame.add(back);
        //not ScrollPane
        frame.add(panel);
    }
}
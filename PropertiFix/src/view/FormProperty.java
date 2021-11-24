/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.Property;
import controller.ControllerProperty;
import controller.MethodWilayah;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import model.Daerah;
import model.InterfacePesan;
import model.StatusJualSewa;
import model.TipeProperty;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author Aloysius
 */
public class FormProperty implements InterfacePesan{
    JFrame frame;
    MethodWilayah controllerWilayah = new MethodWilayah();
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public FormProperty(Property property){
        frame = new JFrame("Form Property");
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
        
        JPanel panel = new JPanel();
        panel.setSize(380, 640);
        panel.setLayout(null);
        panel.setBackground(new Color(201, 248, 201));
        
        JLabel labelDaerah = new JLabel("Daerah");
        labelDaerah.setBounds(10, 10, 100, 40);
        
        ArrayList<String> listDaerah = controllerWilayah.getStringDaerah();
        String[] arrayDaerah = new String[listDaerah.size()];
        arrayDaerah = listDaerah.toArray(arrayDaerah);
        JComboBox comboDaerah = new JComboBox(arrayDaerah);
        comboDaerah.setBounds(135, 13, 150, 30);
        
        JLabel labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(10, 60, 100, 40);
        JTextField textAlamat = new JTextField();
        textAlamat.setBounds(135, 63, 150, 30);
        
        JLabel labelDeskripsi = new JLabel("Deskripsi Bangunan");
        labelDeskripsi.setBounds(10, 110, 160, 40);
        JTextArea textDeskripsi = new JTextArea();
        textDeskripsi.setLineWrap(true);
        textDeskripsi.setBounds(135, 113, 150, 130);
        
        JLabel labelStatusJualSewa = new JLabel("Jual / Sewa");
        labelStatusJualSewa.setBounds(10, 260, 160, 40);
        String[] arrayStatusJualSewa = {StatusJualSewa.JUAL.toString(), StatusJualSewa.SEWA.toString()};
        JComboBox comboStatusJualSewa = new JComboBox(arrayStatusJualSewa);
        comboStatusJualSewa.setBounds(135, 263, 150, 30);
        
        JLabel labelHarga = new JLabel("Harga");
        labelHarga.setBounds(10, 310, 160, 40);
        Long intial = Long.valueOf(0);
        Long min = Long.valueOf(0);
        Long max = Long.MAX_VALUE;
        Long step = Long.valueOf(1000000);
        SpinnerModel modelHarga = new SpinnerNumberModel(intial, min, max, step);
        JSpinner spinnerHarga = new JSpinner(modelHarga);
        spinnerHarga.setBounds(135, 313, 150, 30);
        
        JLabel labelTipeProperty = new JLabel("Tipe Property");
        labelTipeProperty.setBounds(10, 360, 160, 40);
        JRadioButton radioRumah = new JRadioButton(TipeProperty.RUMAH.toString());
        radioRumah.setBounds(135, 363, 75, 30);
        JRadioButton radioApartemen = new JRadioButton(TipeProperty.APARTEMEN.toString());
        radioApartemen.setBounds(215, 363, 100, 30);
        ButtonGroup groupTipeProperty = new ButtonGroup();
        groupTipeProperty.add(radioRumah);groupTipeProperty.add(radioApartemen);
        
        JLabel labelLuasBangunan = new JLabel("Luas Bangunan");
        labelLuasBangunan.setBounds(10, 410, 160, 40);
        JSpinner spinnerLuasBangunan = new JSpinner(new SpinnerNumberModel(0,0,99999,1));
        spinnerLuasBangunan.setBounds(135, 413, 150, 30);
        JLabel besaranLuasBangunan = new JLabel("Meter persegi");
        besaranLuasBangunan.setBounds(295, 410, 160, 40);
        besaranLuasBangunan.setFont(new Font("Sans-Serif", Font.ITALIC, 10));
        
        JLabel labelLuasTanah = new JLabel("Luas Tanah");
        labelLuasTanah.setBounds(10, 460, 160, 40);
        JSpinner spinnerLuasTanah = new JSpinner(new SpinnerNumberModel(0,0,99999,1));
        spinnerLuasTanah.setBounds(135, 463, 150, 30);
        JLabel besaranLuasTanah = new JLabel("Meter persegi");
        besaranLuasTanah.setBounds(295, 460, 160, 40);
        besaranLuasTanah.setFont(new Font("Sans-Serif", Font.ITALIC, 10));
        
        JLabel labelJumlahKamar = new JLabel("Jumlah kamar");
        labelJumlahKamar.setBounds(10, 510, 160, 40);
        JSpinner spinnerJumlahKamar = new JSpinner(new SpinnerNumberModel(0,0,1000,1));
        spinnerJumlahKamar.setBounds(135, 513, 150, 30);
        
        //Button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(30, 560, 100, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textAlamat.getText().isEmpty() && !textDeskripsi.getText().isEmpty() && (radioRumah.isSelected() || radioApartemen.isSelected())){
                    String[] splitDaerah = String.valueOf(comboDaerah.getSelectedItem()).split(", ");
                    Daerah daerah = new Daerah(splitDaerah[1], splitDaerah[0]);
                    String stringStatusJualSewa = String .valueOf(comboStatusJualSewa.getSelectedItem());
                    
                    BigInteger hargaProperty = BigInteger.valueOf((Long) spinnerHarga.getValue());

                    TipeProperty tipeProperty;
                    if(radioRumah.isSelected()){
                        tipeProperty = TipeProperty.RUMAH;
                    }else{
                        tipeProperty = TipeProperty.APARTEMEN;
                    }
                    
                    int kodeProperti = controllerProperty.getLastKodeProperti();
                    User user = (User) UserSingeltonManager.getInstance().getPerson();
                    Property property = new Property(kodeProperti, user, daerah, textAlamat.getText(), textDeskripsi.getText(), StatusJualSewa.valueOf(stringStatusJualSewa), hargaProperty, tipeProperty, (Integer) spinnerLuasBangunan.getValue(), (Integer) spinnerLuasTanah.getValue(), (Integer) spinnerJumlahKamar.getValue(), false);
                    if(controllerProperty.inputProperty(property)){
                        JOptionPane.showMessageDialog(null, "Input berhasil");
                        frame.dispose();
                        new MainMenu();
                    }else{
                        JOptionPane.showMessageDialog(null, "Input Gagal");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Data belum lengkap");
                }
                
            }
        });
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(130, 560, 100, 30);
        btnUpdate.setVisible(false);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250, 560, 100, 30);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(30, 560, 100, 30);
        btnDelete.setVisible(false);
        
        if(property != null){
            //untuk update property
            btnSubmit.setVisible(false);
            
            for (int i = 0; i < arrayDaerah.length; i++) {
                if(controllerProperty.getIdDaerah(property.getDaerah()) - 1 == i){
                    comboDaerah.setSelectedIndex(i);
                }
            }
            
            textAlamat.setText(property.getAlamat());
            textDeskripsi.setText(property.getDeskripsiBangunan());
            if(property.getStatusJualSewa() == StatusJualSewa.JUAL){
                comboStatusJualSewa.setSelectedIndex(0);
            }else{
                comboStatusJualSewa.setSelectedIndex(1);
            }
            
            Long harga = property.getHarga().longValue();
            spinnerHarga.setValue(harga);
            
            if(property.getTipeProperty() == TipeProperty.RUMAH){
                radioRumah.setSelected(true);
            }else{
                radioApartemen.setSelected(true);
            }
            
            spinnerLuasBangunan.setValue(property.getLuasBangunan());
            spinnerLuasTanah.setValue(property.getLuasTanah());
            spinnerJumlahKamar.setValue(property.getJumlahKamar());
            
            btnUpdate.setVisible(true);
            btnUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] splitDaerah = String.valueOf(comboDaerah.getSelectedItem()).split(", ");
                    String stringStatusJualSewa = String .valueOf(comboStatusJualSewa.getSelectedItem());
                    BigInteger hargaProperty = BigInteger.valueOf((Long) spinnerHarga.getValue());
                    TipeProperty tipeProperty;
                    if(radioRumah.isSelected()){
                        tipeProperty = TipeProperty.RUMAH;
                    }else{
                        tipeProperty = TipeProperty.APARTEMEN;
                    }
                    
                    property.setDaerah(new Daerah(splitDaerah[1], splitDaerah[0]));
                    property.setAlamat(textAlamat.getText());
                    property.setDeskripsiBangunan(textDeskripsi.getText());
                    property.setStatusJualSewa(StatusJualSewa.valueOf(stringStatusJualSewa));
                    property.setHarga(hargaProperty);
                    property.setTipeProperty(tipeProperty);
                    property.setLuasBangunan((Integer) spinnerLuasBangunan.getValue());
                    property.setLuasTanah((Integer) spinnerLuasTanah.getValue());
                    property.setJumlahKamar((Integer) spinnerJumlahKamar.getValue());
                    
                    if(controllerProperty.updateProperty(property)){
                        JOptionPane.showMessageDialog(null, updateBerhasil);
                    }else{
                        JOptionPane.showMessageDialog(null, updateGagal);
                    }
                }
            });
            
            btnDelete.setVisible(true);
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(controllerProperty.deleteProperty(property)){
                        frame.dispose();
                        JOptionPane.showMessageDialog(null, hapusBerhasil);
                        if(UserSingeltonManager.getInstance().getPerson() instanceof User){
                            new LihatPropertyUser();
                        }else{
                            ArrayList<Property> listProperty = controllerProperty.getAllProperty();
                            new LihatProperty(listProperty);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, hapusGagal);
                    }
                }
            });
            
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    if(UserSingeltonManager.getInstance().getPerson() instanceof User){
                        new LihatPropertyUser();
                    }else{
                        ArrayList<Property> listProperty = controllerProperty.getAllProperty();
                        new LihatProperty(listProperty);
                    }
                }
            });
        }else{
            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MainMenu();
                }
            });
        }
        
        
        panel.add(labelDaerah);
        panel.add(comboDaerah);
        panel.add(labelAlamat);
        panel.add(labelDeskripsi);
        panel.add(textAlamat);
        panel.add(textDeskripsi);
        panel.add(labelStatusJualSewa);
        panel.add(comboStatusJualSewa);
        panel.add(labelHarga);
        panel.add(spinnerHarga);
        panel.add(labelTipeProperty);
        panel.add(radioRumah);
        panel.add(radioApartemen);
        panel.add(labelLuasBangunan);
        panel.add(spinnerLuasBangunan);
        panel.add(besaranLuasBangunan);
        panel.add(labelLuasTanah);
        panel.add(spinnerLuasTanah);
        panel.add(besaranLuasTanah);
        panel.add(labelJumlahKamar);
        panel.add(spinnerJumlahKamar);
        panel.add(btnSubmit);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnBack);
        frame.add(panel);
        
    }
}

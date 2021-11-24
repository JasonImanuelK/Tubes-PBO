/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import model.Property;
import controller.ControllerProperty;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import model.Daerah;
import model.TipeProperty;

/**
 *
 * @author patri
 */
public class FilterProperty {
    JFrame frameFilter;
    JPanel panelFilter;
    JLabel labelSearchJudul,labelDaerah,labelHargaMin,labelHargaMax,labelTipeProperty,labelLuasBangunanMin,labelLuasBangunanMax,
            labelLuasTanahMin,labelLuasTanahMax,labelJumlahKamarMin,labelJumlahKamarMax;
    JComboBox comboDaerah;
    JSpinner spinHargaMin, spinHargaMax;
    JSlider sliderLuasBangunanMin,sliderLuasBangunanMax,sliderLuasTanahMin,sliderLuasTanahMax,sliderJumlahKamarMin,sliderJumlahKamarMax;
    JButton buttonSearch,buttonBack;
    ControllerProperty controllerProperty = new ControllerProperty();
    
    public FilterProperty(){
        ArrayList<String> listDaerah;
        MethodWilayah methodWilayah = new MethodWilayah();
        
        //frame
        frameFilter = new JFrame("Search Property");
        frameFilter.setSize(500, 600);
        frameFilter.setLayout(null);
        frameFilter.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frameFilter.dispose();
                new MainMenu();
            }
        });
        
        //panel
        panelFilter = new JPanel();
        panelFilter.setSize(500, 600);
        panelFilter.setLayout(null);
        panelFilter.setBackground(new Color(201, 248, 201));
        
        
        //Label
        labelSearchJudul = new JLabel("Input Filter Search");
        labelSearchJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelSearchJudul.setBounds(80,25,300,40);
        labelDaerah = new JLabel("Daerah");
        labelDaerah.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelDaerah.setBounds(30, 80, 200, 40);
        labelHargaMin = new JLabel("Harga Min");
        labelHargaMin.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelHargaMin.setBounds(30, 120, 200, 40);
        labelHargaMax = new JLabel("Harga Max");
        labelHargaMax.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelHargaMax.setBounds(30, 160, 200, 40);
        labelTipeProperty = new JLabel("Tipe Property");
        labelTipeProperty.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelTipeProperty.setBounds(30, 200, 200, 40);
        labelLuasBangunanMin = new JLabel("Luas Bangunan Min");
        labelLuasBangunanMin.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelLuasBangunanMin.setBounds(30, 240, 200, 40);
        labelLuasBangunanMax = new JLabel("Luas Bangunan Max");
        labelLuasBangunanMax.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelLuasBangunanMax.setBounds(30, 280, 200, 40);
        labelLuasTanahMin = new JLabel("Luas Tanah Min");
        labelLuasTanahMin.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelLuasTanahMin.setBounds(30, 320, 200, 40);
        labelLuasTanahMax = new JLabel("Luas Tanah Max");
        labelLuasTanahMax.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelLuasTanahMax.setBounds(30, 360, 200, 40);
        labelJumlahKamarMin = new JLabel("Jumlah Kamar Min");
        labelJumlahKamarMin.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelJumlahKamarMin.setBounds(30, 400, 200, 40);
        labelJumlahKamarMax = new JLabel("Jumlah Kamar Max");
        labelJumlahKamarMax.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        labelJumlahKamarMax.setBounds(30, 440, 200, 40);
        
        //ComboBox
        listDaerah = methodWilayah.getStringDaerah();
        String[] arrayDaerah = new String[listDaerah.size()];
        arrayDaerah = listDaerah.toArray(arrayDaerah);
        JComboBox comboDaerah = new JComboBox(arrayDaerah);
        comboDaerah.setBounds(200, 80, 200, 40);

        //Spinner
        Long intial = Long.valueOf(0);
        Long min = Long.valueOf(0);
        Long max = Long.MAX_VALUE;
        Long stepHarga = Long.valueOf(1000000);
        SpinnerModel modelHarga = new SpinnerNumberModel(intial, min, max, stepHarga);
        spinHargaMin = new JSpinner(modelHarga);
        spinHargaMin.setBounds(200, 120, 200, 40);
        spinHargaMax = new JSpinner(new SpinnerNumberModel(max, min, max, stepHarga));
        spinHargaMax.setBounds(200, 160, 200, 40);
        
        
        sliderLuasBangunanMin = new JSlider(JSlider.HORIZONTAL,0,99999,0);
        sliderLuasBangunanMin.setBounds(220, 240, 200, 40);
        sliderLuasBangunanMax = new JSlider(JSlider.HORIZONTAL,0,99999,99999);
        sliderLuasBangunanMax.setBounds(220, 280, 200, 40);
        int height = 240;
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel("99999");
            label.setBounds(420, height-3, 200, 20);
            panelFilter.add(label);
            height+=40;
        }
        sliderLuasTanahMin = new JSlider(JSlider.HORIZONTAL,0,99999,0);
        sliderLuasTanahMin.setBounds(220, 320, 200, 40);
        sliderLuasTanahMax = new JSlider(JSlider.HORIZONTAL,0,99999,99999);
        sliderLuasTanahMax.setBounds(220, 360, 200, 40);
        sliderJumlahKamarMin = new JSlider(JSlider.HORIZONTAL,0,1000,0);
        sliderJumlahKamarMin.setBounds(220, 400, 200, 40);
        sliderJumlahKamarMax = new JSlider(JSlider.HORIZONTAL,0,1000,1000);
        sliderJumlahKamarMax.setBounds(220, 440, 200, 40);
        height = 400;
        for (int i = 0; i < 2; i++) {
            JLabel label = new JLabel("1000");
            label.setBounds(420, height-3, 200, 20);
            panelFilter.add(label);
            height+=40; 
        }
        height = 240;
        for (int i = 0; i < 6; i++) {
            JLabel labelMin = new JLabel("0");
            labelMin.setBounds(220, height-3, 200, 20);
            panelFilter.add(labelMin);
            height+=40;
        }
        
        //Radio
        JRadioButton radioRumah = new JRadioButton("Rumah");
        radioRumah.setBounds(200, 200, 90, 40);
        JRadioButton radioApartemen = new JRadioButton("Apartemen");
        radioApartemen.setBounds(300, 200, 90, 40);
        ButtonGroup groupTipeProperty = new ButtonGroup();
        groupTipeProperty.add(radioRumah);groupTipeProperty.add(radioApartemen);
        
        //button
        buttonSearch = new JButton("Search");
        buttonSearch.setBounds(80, 490, 130, 40);
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioRumah.isSelected() || radioApartemen.isSelected()){
                    frameFilter.dispose();
                    String[] splitDaerah = String.valueOf(comboDaerah.getSelectedItem()).split(", ");
                    Daerah daerah = new Daerah(splitDaerah[1], splitDaerah[0]);
                    BigInteger hargaMin = BigInteger.valueOf((Long) spinHargaMin.getValue());
                    BigInteger hargaMax = BigInteger.valueOf((Long) spinHargaMax.getValue());
                    TipeProperty tipeProperty;
                    if(radioRumah.isSelected()){
                        tipeProperty = TipeProperty.RUMAH;
                    }else{
                        tipeProperty = TipeProperty.APARTEMEN;
                    }

                    ArrayList<Property> listProperty = controllerProperty.getListPropertyUseFilter(controllerProperty.getIdDaerah(daerah), hargaMin, hargaMax, 
                            tipeProperty.toString(), sliderLuasBangunanMin.getValue(), sliderLuasBangunanMax.getValue(), sliderLuasTanahMin.getValue(), sliderLuasTanahMax.getValue()
                            , sliderJumlahKamarMin.getValue(), sliderJumlahKamarMax.getValue());

                    frameFilter.dispose();
                    new LihatProperty(listProperty);
//                    new lihatpropertyUserbarupakeScroll(listProperty);
                }else{
                    JOptionPane.showMessageDialog(null, "Pilih tipe property");
                }
                
            }
        });
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(210, 490, 130, 40);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameFilter.dispose();
                new MainMenu();
            }
        });

        //add panel
        panelFilter.add(labelSearchJudul);
        panelFilter.add(labelDaerah);
        panelFilter.add(labelHargaMin);
        panelFilter.add(labelHargaMax);
        panelFilter.add(labelTipeProperty);
        panelFilter.add(labelLuasBangunanMin);
        panelFilter.add(labelLuasBangunanMax);
        panelFilter.add(labelLuasTanahMin);
        panelFilter.add(labelLuasTanahMax);
        panelFilter.add(labelJumlahKamarMin);
        panelFilter.add(labelJumlahKamarMax);
        panelFilter.add(comboDaerah);
        panelFilter.add(spinHargaMin);
        panelFilter.add(spinHargaMax);
        panelFilter.add(sliderLuasBangunanMin);
        panelFilter.add(sliderLuasBangunanMax);
        panelFilter.add(sliderLuasTanahMin);
        panelFilter.add(sliderLuasTanahMax);
        panelFilter.add(sliderJumlahKamarMin);
        panelFilter.add(sliderJumlahKamarMax);
        panelFilter.add(radioApartemen);
        panelFilter.add(radioRumah);
        
        panelFilter.add(buttonSearch);
        panelFilter.add(buttonBack);
        
        panelFilter.setLayout(null);
        panelFilter.setVisible(true);
        frameFilter.setLocationRelativeTo(null);
        frameFilter.setLayout(null);
        frameFilter.setVisible(true);
        frameFilter.setVisible(true);
        frameFilter.add(panelFilter);
    }
}

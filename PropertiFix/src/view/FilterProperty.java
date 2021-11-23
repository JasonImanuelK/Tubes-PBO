/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.*;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author patri
 */
public class FilterProperty {
    JFrame frameFilter;
    JPanel panelFilter;
    JLabel labelSearchJudul,labelDaerah,labelHarga,labelTipeProperty,labelLuasBangunan, labelLuasTanah,labelJumlahKamar;
    JComboBox comboDaerah;
    JSpinner spinHarga,spinLuasBangunan,spinLuasTanah,spinJumlahKamar;
    
    JButton buttonSearch,buttonBack;
    
    public FilterProperty(){
        ArrayList<String> listDaerah;
        
        MethodWilayah methodWilayah = new MethodWilayah();
        
        //frame
        frameFilter = new JFrame("Search Property");
        frameFilter.setSize(430, 450);
        frameFilter.setLayout(null);
        
        //panel
        panelFilter = new JPanel();
        panelFilter.setSize(430, 450);
        panelFilter.setLayout(null);
        panelFilter.setBackground(new Color(201, 248, 201));
        
        //Label
        labelSearchJudul = new JLabel("Input Filter Search");
        labelSearchJudul.setFont(new Font("Sans-Serif", Font.BOLD, 26));
        labelSearchJudul.setBounds(80,25,300,40);
        labelDaerah = new JLabel("Daerah");
        labelDaerah.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        labelDaerah.setBounds(30, 80, 200, 40);
        labelHarga = new JLabel("Harga");
        labelHarga.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        labelHarga.setBounds(30, 120, 200, 40);
        labelTipeProperty = new JLabel("Tipe Property");
        labelTipeProperty.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        labelTipeProperty.setBounds(30, 160, 200, 40);
        labelLuasBangunan = new JLabel("Luas Bangunan");
        labelLuasBangunan.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        labelLuasBangunan.setBounds(30, 200, 200, 40);
        labelLuasTanah = new JLabel("Luas Tanah");
        labelLuasTanah.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        labelLuasTanah.setBounds(30, 240, 200, 40);
        labelJumlahKamar = new JLabel("Jumlah Kamar");
        labelJumlahKamar.setFont(new Font("Sans-Serif", Font.BOLD, 20));
        labelJumlahKamar.setBounds(30, 280, 200, 40);
        
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
        spinHarga = new JSpinner(modelHarga);
        spinHarga.setBounds(200, 120, 200, 40);
        
        Long stepBangunan = Long.valueOf(1);
        SpinnerModel modelBangunan = new SpinnerNumberModel(intial, min, max, stepBangunan);
        spinLuasBangunan = new JSpinner(modelBangunan);
        spinLuasBangunan.setBounds(200, 200, 200, 40);
        Long stepTanah = Long.valueOf(1);
        SpinnerModel modelTanah = new SpinnerNumberModel(intial, min, max, stepBangunan);
        spinLuasTanah = new JSpinner (modelTanah);
        spinLuasTanah.setBounds(200, 240, 200, 40);
        Long stepKamar = Long.valueOf(1);
        SpinnerModel modelKamar = new SpinnerNumberModel(intial, min, max, stepKamar);
        spinJumlahKamar = new JSpinner (modelKamar);
        spinJumlahKamar.setBounds(200, 280, 200, 40);
        
        //Radio
        JRadioButton radioRumah = new JRadioButton("Rumah");
        radioRumah.setBounds(200, 160, 90, 40);
        JRadioButton radioApartemen = new JRadioButton("Apartemen");
        radioApartemen.setBounds(300, 160, 90, 40);
        ButtonGroup groupTipeProperty = new ButtonGroup();
        groupTipeProperty.add(radioRumah);groupTipeProperty.add(radioApartemen);
        
        //button
        buttonSearch = new JButton("Search");
        buttonSearch.setBounds(80, 330, 130, 40);
        buttonBack = new JButton("Back");
        buttonBack.setBounds(210, 330, 130, 40);

        //add panel
        panelFilter.add(labelSearchJudul);
        panelFilter.add(labelDaerah);
        panelFilter.add(labelHarga);
        panelFilter.add(labelTipeProperty);
        panelFilter.add(labelLuasBangunan);
        panelFilter.add(labelLuasTanah);
        panelFilter.add(labelJumlahKamar);
        panelFilter.add(comboDaerah);
        panelFilter.add(spinHarga);
        panelFilter.add(spinLuasBangunan);
        panelFilter.add(spinLuasTanah);
        panelFilter.add(spinJumlahKamar);
        
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
        frameFilter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

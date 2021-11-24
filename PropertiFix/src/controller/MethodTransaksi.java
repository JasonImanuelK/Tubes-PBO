/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Daerah;
import model.Property;
import model.StatusJualSewa;
import model.TipeProperty;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author patri
 */
public class MethodTransaksi {
    DbHandler conn = new DbHandler();

    public MethodTransaksi() {
        conn.connect();
    }
    
    public Property getPropertyUser(int idProperty) {
        Property propertyTarik;
        conn.connect();
        User user = (User) UserSingeltonManager.getInstance().getPerson();
        String query = "SELECT * FROM properti WHERE kodeProperti ='" + idProperty + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            propertyTarik = new Property(rs.getInt("kodeProperti"), user, getDaerah(rs.getInt("idDaerah")), rs.getString("alamat"), rs.getString("deskripsiBangunan"), StatusJualSewa.valueOf(rs.getString("statusJualSewa")), BigInteger.valueOf(rs.getLong("harga")), TipeProperty.valueOf(rs.getString("tipeProperty")), rs.getInt("luasBangunan"), rs.getInt("luasTanah"), rs.getInt("jumlahKamar"), rs.getBoolean("verifikasi"));
            return propertyTarik;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Daerah getDaerah(int idDaerah) {
        Daerah daerah = new Daerah();
        conn.connect();
        String query = "SELECT * FROM daerah WHERE idDaerah='" + idDaerah + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                daerah = new Daerah(rs.getString("provinsi"), rs.getString("kota"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daerah;
    }
}
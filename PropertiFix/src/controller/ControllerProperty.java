/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Daerah;
import model.Property;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author Aloysius
 */
public class ControllerProperty {
    DbHandler conn = new DbHandler();

    public ControllerProperty() {
        conn.connect();
    }
    
    public boolean inputProperty(Property property){
        conn.connect();
        String query = "INSERT INTO `properti` (`idPengguna`, `idDaerah`, `alamat`, `deskripsiBangunan`, `statusJualSewa`, `harga`, `tipeProperty`, `luasBangunan`, `luahTanah`, `jumlahKamar`, `verifikasi`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            User user = (User) UserSingeltonManager.getInstance().getPerson();
            stmt.setInt(1, getIdUser(user));
            stmt.setInt(2, getIdDaerah(property.getDaerah()));
            stmt.setString(3, property.getAlamat());
            stmt.setString(4, property.getDeskripsiBangunan());
            stmt.setString(5, property.getStatusJualSewa().name());
            stmt.setBigDecimal(6, new BigDecimal(property.getHarga()));
            stmt.setInt(7, property.getTipeProperty());
            stmt.setInt(8, property.getLuasBangunan());
            stmt.setInt(9, property.getLuasTanah());
            stmt.setInt(10, property.getJumlahKamar());
            stmt.setInt(11, 0);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public int getIdDaerah(Daerah daerah){
        conn.connect();
        String query = "SELECT * FROM daerah WHERE provinsi='" + daerah.getProvinsi() + "'&& kota='" + daerah.getKota() + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("idDaerah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public int getIdUser(User user){
        conn.connect();
        String query = "SELECT * FROM person WHERE email='" + user.getEmail() + "'&& password='" + user.getPassword() + "'";
        int id = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("idPengguna");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    
}

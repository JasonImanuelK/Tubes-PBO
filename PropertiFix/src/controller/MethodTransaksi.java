/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.MethodLogin.conn;
import static controller.MethodRegistrasi.conn;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Daerah;
import model.JenisPembayaran;
import model.Person;
import model.Property;
import model.StatusJualSewa;
import model.StatusPerson;
import model.Status_Pembayaran;
import model.TipeProperty;
import model.User;
import model.UserSingeltonManager;
import model.Transaksi;

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
    
    public boolean insertTransaksi(Property property,String jenisPembayaran){
        String query = "INSERT INTO Transaksi(idPengguna,idProperti,jenisPembayaran,statusPembayaran) VALUES (?,?,?,'Belum Lunas')";
        int idPengguna = getIdPengguna();
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1,idPengguna);
                stmt.setInt(2,property.getKodeProperti());
                stmt.setString(3,jenisPembayaran);
                stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }
        
    }
    
    public int getIdPengguna(){
        String query = "SELECT * FROM PERSON";
        int hasil = 0;
        Person person = (User)UserSingeltonManager.getInstance().getPerson();
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
//                    Person person = new Person(rs.getString("nama"),rs.getString("noTelp"),rs.getString("password"),rs.getString("email"), StatusPerson.USER);
                    if(person.getEmail().equals(rs.getString("email"))&&person.getPassword().equals(rs.getString("password"))){
                        hasil = rs.getInt("idPengguna");
                    }
                }
            }
            return hasil;
        } catch (SQLException e) {
            e.printStackTrace();
            return hasil;
        }
    }
    
    public boolean checkStatusProperty(Property property){
        String query = "SELECT * FROM TRANSAKSI WHERE idProperti = '"+property.getKodeProperti()+"'";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                if(!rs.isBeforeFirst()){
                    return false;
                } else {
                    return true;
                }
            } catch (SQLException e) {
            e.printStackTrace();
            }
            return false;
    }
    
    
    
    public boolean inputDataUser(Person person) {
        String query = "INSERT INTO person (password, email, nama, noTelp) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, person.getPassword());
            stmt.setString(2, person.getEmail());
            stmt.setString(3, person.getNama());
            stmt.setString(4, person.getNoTelp());
            //statusPerson dan member otomatis terisi 'USER' dan 'BRONZE'
            stmt.executeUpdate();
            
            UserSingeltonManager.getInstance().setPerson(person);
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }       
    }
    
    public ArrayList<Transaksi> getListTransaksiUser (){
        String query = "SELECT * FROM transaksi WHERE idPengguna='"+getIdPengguna()+"'";
        ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
        
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Transaksi transaksi = new Transaksi(rs.getInt("idTransaksi"),rs.getInt("idPengguna"),rs.getInt("idProperty"),JenisPembayaran.valueOf(rs.getString("jenisPembayaran")),Status_Pembayaran.valueOf(rs.getString("statusPembayaran")));
                    listTransaksi.add(transaksi);
                }
            }
            return listTransaksi;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    
//    public Property getProperty(int idPropertyGet){
//        String query = "SELECT * FROM properti WHERE kodeProperti ='"+idPropertyGet+"'";
//        Property property;
//        
//        try{
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            
//            if(!rs.isBeforeFirst()){
//                return property = new Property(rs.getInt("kodeProperti"),rs.getInt("idPengguna"),rs.getInt("idDaerah"),rs.getString("alamat"),rs.getString("deskripsiBangunan"),StatusJualSewa.valueOf(rs.getString("statusJualSewa"),rs.getInt("harga"),rs.get))
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
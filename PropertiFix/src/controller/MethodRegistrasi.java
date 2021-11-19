/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Member;
import model.Person;
import model.StatusPerson;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author User
 */
public class MethodRegistrasi {
    static DbHandler conn = new DbHandler();

    public MethodRegistrasi() {
        conn.connect();
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
    
    
//    private int getIdPengguna() {
//        String query = "SELECT idPengguna FROM person ORDER BY idPengguna DESC LIMIT 2";
//        int idPengguna = 0;
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            rs.next();
//            idPengguna = rs.getInt("idPengguna");  
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return idPengguna;
//    }
}

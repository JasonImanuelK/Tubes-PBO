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
import model.Status;
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
        String query = "INSERT INTO user (password, email, status, nama, noTelp) VALUES (?,?,?,?,?)";
        String status = "", member = "";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, person.getPassword());
            stmt.setString(2, person.getEmail());
            if (person.getStatus().equals(Status.USER)) {
                status = "USER";
            }
            stmt.setString(3, status);
            stmt.setString(4, person.getNama());
            stmt.setString(5, person.getNoTelp());
            stmt.executeUpdate();
            if (((User)person).getMember().equals(Member.BRONZE)) {
                member = "BRONZE";
            }
            boolean hasil = inputDataMember(member);
            if (hasil) {
                UserSingeltonManager instance = UserSingeltonManager.getInstance();
                instance.setPerson(person);
            }
            return(hasil);
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }       
    }
    
    private boolean inputDataMember(String member) {
        String query = "INSERT INTO member VALUES (?, ?)";
        int idPengguna = getIdPengguna();
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, idPengguna);
            stmt.setString(2, member);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    private int getIdPengguna() {
        String query = "SELECT idPengguna FROM user ORDER BY idPengguna DESC LIMIT 2";
        int idPengguna = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            idPengguna = rs.getInt("idPengguna");  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idPengguna;
    }
}

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
import model.User;
import model.Admin;
import model.Person;
import model.Member;
import model.StatusPerson;
import model.UserSingeltonManager;

/**
 *
 * @author User
 */
public class MethodLogin {
    static DbHandler conn = new DbHandler();

    public MethodLogin() {
        conn.connect();
    }
    
    private String getMember(int idPengguna){
        String query = "SELECT statusMember FROM member WHERE idPengguna = ? ";
        String member = "";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, idPengguna);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            member = rs.getString("statusMember");  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }
    
    public boolean checkUser(String inputUsername, String inputPassword) {
        String query = "SELECT * FROM user WHERE nama = ? AND password = ?";
        StatusPerson statusEnum;
        Person person = null;
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, inputUsername);
            stmt.setString(2, inputPassword);
            ResultSet rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String status = rs.getString("status");
                    if (status.equals("ADMIN")) {
                        statusEnum = StatusPerson.ADMIN;
                        person = new Admin(rs.getString("nama"), rs.getString("noTelp"), rs.getString("password"), rs.getString("email"), statusEnum);
                    }else if (status.equals("USER")) {
                        String member = getMember(rs.getInt("idPengguna"));
                        person = new User(rs.getString("nama"), rs.getString("noTelp"), rs.getString("password"), rs.getString("email"), StatusPerson.USER, Member.valueOf(member));
                    }
                   
                    UserSingeltonManager instance = UserSingeltonManager.getInstance();
                    instance.setPerson(person);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

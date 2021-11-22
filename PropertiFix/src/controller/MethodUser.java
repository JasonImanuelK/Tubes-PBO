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
import java.util.ArrayList;
import model.Member;
import model.Person;
import model.StatusPerson;
import model.User;
import model.UserSingeltonManager;

/**
 *
 * @author User
 */
public class MethodUser {
    static DbHandler conn = new DbHandler();

    public MethodUser() {
        conn.connect();
    }
    
    public ArrayList<User> getSemuaDataUser() {
        String query = "SELECT * FROM person WHERE statusPerson = 'USER' ";
        ArrayList<User> listUser= new ArrayList<>(); 
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Member member = Member.valueOf(rs.getString("member"));
                listUser.add(new User(rs.getString("nama"),rs.getString("noTelp"),rs.getString("password"),rs.getString("email"),StatusPerson.USER,member));
            };
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUser;   
    }
    
    public boolean deleteUser(String nama,String email){
        String query = "DELETE FROM person WHERE nama = ? AND email = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateData(String nama,String email, String member) {
        String query = "UPDATE person SET member = ? WHERE nama = ? AND email = ?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, member);
            stmt.setString(2, nama);
            stmt.setString(3, email);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
}

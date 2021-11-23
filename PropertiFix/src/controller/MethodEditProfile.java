/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Person;
import model.UserSingeltonManager;

/**
 *
 * @author User
 */
public class MethodEditProfile {
    static DbHandler conn = new DbHandler();

    public MethodEditProfile() {
        conn.connect();
    }
    
    public boolean updateDataUser(Person person) {
        String query = "UPDATE person SET password = ?, email = ?, nama = ?, noTelp = ? WHERE password = ? AND nama = ?";
            
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, person.getPassword());
            stmt.setString(2, person.getEmail());
            stmt.setString(3, person.getNama());
            stmt.setString(4, person.getNoTelp());        
            stmt.setString(5, UserSingeltonManager.getInstance().getPerson().getPassword());
            stmt.setString(6, UserSingeltonManager.getInstance().getPerson().getNama());
            //statusPerson dan member otomatis terisi 'USER' dan 'BRONZE'
            stmt.executeUpdate();
            
            UserSingeltonManager.getInstance().setPerson(person);
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return(false);
        }       
    }
}

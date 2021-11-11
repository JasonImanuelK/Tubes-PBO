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
import model.Member;
import model.Status;

/**
 *
 * @author User
 */
public class MethodLogin {
    static DbHandler conn = new DbHandler();

    public MethodLogin() {
        conn.connect();
    }
    
    public boolean checkUser(String inputUsername, String inputPassword) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        boolean checkUser = true;
        Member memberEnum = Member.BRONZE;
        Status statusEnum = Status.ADMIN;
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, inputUsername);
            stmt.setString(2, inputPassword);
            ResultSet rs = stmt.executeQuery();
            if (rs == null) {
                while (rs.next()) {
                    String member = rs.getString("member");
                    if (member.equals("BRONZE")) {
                        memberEnum = Member.BRONZE;       
                    }else if (member.equals("SILVER")) {
                        memberEnum = Member.SILVER;
                    }else if (member.equals("GOLD")) {
                        memberEnum = Member.GOLD;
                    }
                    
                    String status = rs.getString("status");
                    if (status.equals("ADMIN")) {
                        statusEnum = Status.ADMIN;
                    }else if (status.equals("ADMIN")) {
                        statusEnum = Status.USER;
                    }
                    User user = new User(rs.getString("nama"), rs.getString("noTelp"), rs.getString("password"), rs.getString("email"), statusEnum, memberEnum);
                }
            }else{
                checkUser = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkUser;
    }
}

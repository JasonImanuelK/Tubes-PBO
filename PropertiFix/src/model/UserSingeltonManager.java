/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class UserSingeltonManager {
    private static UserSingeltonManager instance;
    private User user;
    
    public static UserSingeltonManager getInstance(){
        if (instance == null) {
            instance = new UserSingeltonManager();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
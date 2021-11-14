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
    private Person person;
    
    public static UserSingeltonManager getInstance(){
        if (instance == null) {
            instance = new UserSingeltonManager();
        }
        return instance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
}

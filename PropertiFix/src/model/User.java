/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author patri
 */
public class User extends Person{
    
    private Member member;
    
    public User(){
    }
    
    public User(String nama, String noTelp, String password, String email, StatusPerson status,Member member) {
        super(nama, noTelp, password, email, status);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    
    
}

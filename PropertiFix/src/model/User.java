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
    private String password;
    private String email;
    private Status status;
    private Member member;
    
    User(String nama,String noTelp,String password,String email,Status status,Member member){
        super(nama,noTelp);
        this.password = password;
        this.email = email;
        this.status = status;
        this.member = member;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getEmail(){
        return email;
    }
    
    public Status status(){
        return status;
    }
    
    public Member member(){
        return member;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    public void setmember(Member member){
        this.member = member;
    }
    
}

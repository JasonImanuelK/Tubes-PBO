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
abstract class Person {
    private String nama;
    private String noTelp;
    
    Person(String nama,String noTelp){
        this.nama = nama;
        this.noTelp = noTelp;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getNoTelp(){
        return noTelp;
    }
    
    public void setNama(String n){
        this.nama = n;
    }
    
    public void setNoTelp(String t){
        this.noTelp = t;
    }
}

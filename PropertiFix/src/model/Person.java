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
public abstract class Person {
    private String nama;
    private String noTelp;
    private String password;
    private String email;
    private StatusPerson status;

    
    public Person(String nama, String noTelp, String password, String email, StatusPerson status) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusPerson getStatus() {
        return status;
    }

    public void setStatus(StatusPerson status) {
        this.status = status;
    }
    
    
}

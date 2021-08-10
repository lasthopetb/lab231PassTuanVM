/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Account {
    private int id;
    private String user;
    private String pass;
    private String type;
    private String email;

    public Account() {
    }

    public Account(int id, String user, String pass, String type, String email) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.type = type;
        this.email = email;
    }

    public Account(String user, String pass, String type, String email) {
        this.user = user;
        this.pass = pass;
        this.type = type;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

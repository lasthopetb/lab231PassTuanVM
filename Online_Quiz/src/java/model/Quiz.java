/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Quiz {
    private int accountid;
    private String date;
    private double result;
    private String status;

    public Quiz(int accountid, Date date, double result) {
        this.accountid = accountid;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = sdf.format(date);
        this.result = result;
    }

    public Quiz() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        this.date = sdf.format(date);
    }
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
    
    
}

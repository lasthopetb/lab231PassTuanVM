/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;


public class AccountDAO extends DBContext{
    
    //get account by username and password
    public Account getAccount(String username,String password) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from Account where username = ? and password = ?";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            //get account from resultSet
            if(rs.next()){
                Account x = new Account();
                x.setId(rs.getInt("id"));
                x.setUser(rs.getString("username"));
                x.setPass(rs.getString("password"));
                x.setEmail(rs.getString("email"));
                x.setType(rs.getString("type"));
                return x;
            }
        } catch (Exception e) {
            System.out.println("error when get account by username and password");
            throw e;
        } finally { 
            closeConnection(con,ps,rs);
        }
        return null;
    }
    
    public boolean checkUsernameExist(String username) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from Account where username = ?";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            //get account from resultSet
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("error when check username exist");
            throw e;
        } finally { 
            closeConnection(con,ps,rs);
        }
        return false;
    }
    
    //Register new account
    public void createAccount(Account a) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "insert into Account([username],[password],[email],[type])"
                    + " values(?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, a.getUser());
            ps.setString(2, a.getPass());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getType());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error when check username exist");
            throw e;
        } finally { 
            closeConnection(con,ps,rs);
        }
    }
}

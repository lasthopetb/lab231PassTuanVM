/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.*;


public class QuizDAO extends DBContext{
    public void addQuiz(Quiz q) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "insert into Quiz([accountid],[date],[result],[status]) values(?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, q.getAccountid());
            ps.setString(2, q.getDate());
            ps.setDouble(3, q.getResult());
            ps.setString(4, q.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error when add quiz result");
            throw e;
        } finally { 
            closeConnection(con,ps,rs);
        }
    }
}

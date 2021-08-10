package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBContext {

    InitialContext initContext;
    Context context;

  
    public Connection getConnection() {
        try {
            initContext = new InitialContext();
            context = (Context) initContext.lookup("java:comp/env");
            try {
                String serverName = (String) context.lookup("serverName");
                String port = (String) context.lookup("port");
                String dbName = (String) context.lookup("dbName");
                String url = "jdbc:sqlserver://" + serverName + ":" + port + ";databaseName=" + dbName;
                String user = (String) context.lookup("user");
                String pass = (String) context.lookup("pass");
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                return DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } catch (NamingException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void closeConnection(Connection con,PreparedStatement ps,ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public String getImageSource() {
        try {
            initContext = new InitialContext();
            context = (Context) initContext.lookup("java:/comp/env");
            String source = (String) context.lookup("imageSource");
            return source;
        } catch (NamingException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

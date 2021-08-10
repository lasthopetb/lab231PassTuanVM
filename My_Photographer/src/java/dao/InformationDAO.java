package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.Information;
import model.Share;

public class InformationDAO {

    public Information getInfor() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        DBContext db = new DBContext();
        String sql = "select * from Information";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Information info = new Information(rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("country"),
                        rs.getString("tel"),
                        rs.getString("email"), rs.getString("image"));

                return info;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }

        return null;
    }
}

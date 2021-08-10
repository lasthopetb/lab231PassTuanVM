package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.Introduction;
import model.Share;

public class ShareDAO {

    public List<Share> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        DBContext db = new DBContext();
        String sql = "select * from Share";
        List<Share> list = new ArrayList<>();

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share sh = new Share(rs.getString("icon"),
                        rs.getString("social_network"), rs.getString("url"));

                list.add(sh);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }

        return list;
    }
}

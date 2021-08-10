
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
import model.Gallery;
import model.ImageGallery;


public class ImageGalleryDAO {
    
   
    public List<ImageGallery> getImageByGallery(int id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        DBContext db = new DBContext();
        String sql = "select * from ImageGallery where gallery_id = ?";
        List<ImageGallery> list = new ArrayList<>();
        
        try {
            conn = db.getConnection();
            ps= conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                ImageGallery ig = new ImageGallery(rs.getString("image"), rs.getInt("gallery_id"));
                
                list.add(ig);
            }
            
        } catch (Exception ex) {
            throw ex;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        
        return list;
    }
    public List<ImageGallery> pagging(int pageIndex, int pageSize, int galId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<ImageGallery> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by gallery_id ASC) as No,\n" +
"                * from ImageGallery where gallery_id = ?) as x where No between ? and ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galId);
            ps.setObject(2, start);
            ps.setObject(3, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImageGallery g = new ImageGallery(rs.getString("image"),
                                             rs.getInt("gallery_id"));
                list.add(g);
            }
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
    
    public int numberOfResult(int galId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        String sql = "Select count(gallery_id) from ImageGallery where gallery_id = ?";
        int count = 0;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galId);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return count;
    }
}

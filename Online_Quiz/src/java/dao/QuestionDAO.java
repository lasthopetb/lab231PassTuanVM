package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Question;

public class QuestionDAO extends DBContext {

    //add a question
    public void addQuestion(Question q) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "insert into Question([question],[option1],[option2],[option3],[option4],[answer],[createdate],[accountID]) values(?,?,?,?,?,?,?,?)";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getOption1());
            ps.setString(3, q.getOption2());
            ps.setString(4, q.getOption3());
            ps.setString(5, q.getOption4());
            //get answers
            String ans = "";
            for (int i = 0; i < q.getAnswers().length; i++) {
                ans += q.getAnswers()[i] + " ";
            }
            ps.setString(6, ans);
            ps.setString(7, q.getDate());
            ps.setInt(8, q.getAccountid());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error when add question");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    public List<Question> getQuestionsByPageNumber(int id, int currentPage, int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> lst = new ArrayList<Question>();
        int begin = (currentPage-1)*pageSize+1;
        int end = currentPage*pageSize;
        try {
            String sql = "select [id],[Question],[option1],[option2],[option3],[option4],[answer],[createdate],[accountid] from (select ROW_NUMBER() over (order by id asc) as rowid, * \n"
                    + "from Question where accountid=?) as s\n"
                    + "where rowid>=? and rowid<=?";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, begin);
            ps.setInt(3, end);
            rs = ps.executeQuery();
            //get questions from resultSet and add to list
            while (rs.next()) {
                Question x = new Question();
                x.setId(rs.getInt("id"));
                x.setQuestion(rs.getString("question"));
                x.setOption1(rs.getString("option1"));
                x.setOption2(rs.getString("option2"));
                x.setOption3(rs.getString("option3"));
                x.setOption4(rs.getString("option4"));
                x.setAnswers(rs.getString("answer"));
                x.setDate(rs.getDate("createdate"));
                x.setAccountid(id);
                lst.add(x);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("error when get question by page number");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    public List<Question> getAllQuestionByAccountId(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> lst = new ArrayList<Question>();

        try {
            String sql = "select * from Question where accountid = ?";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            //get questions from resultSet and add to list
            while (rs.next()) {
                Question x = new Question();
                x.setId(rs.getInt("id"));
                x.setQuestion(rs.getString("question"));
                x.setOption1(rs.getString("option1"));
                x.setOption2(rs.getString("option2"));
                x.setOption3(rs.getString("option3"));
                x.setOption4(rs.getString("option4"));
                x.setAnswers(rs.getString("answer"));
                x.setDate(rs.getDate("createdate"));
                x.setAccountid(id);
                lst.add(x);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("error when get question by account id");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    public void deleteQuestion(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "delete from Question where id = ?";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error when delete question");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    //get total questions
    public int getNumberOfQuestionsByAccountId(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) as total from Question where accountid = ?";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("error when get number of question");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
        return 0;
    }
    
    //get total questions
    public int getNumberOfQuestions() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) as total from Question";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("error when get number of question");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
        return 0;
    }

    //get a test as questions list by number of questions and randomly
    public List<Question> getQuestions(int numberOfQuestions) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> lst = new ArrayList<Question>();

        try {
            String sql = "select top (?)* from Question order by newid()";
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberOfQuestions);
            rs = ps.executeQuery();
            //get questions from resultSet and add to list
            while (rs.next()) {
                Question x = new Question();
                x.setId(rs.getInt("id"));
                x.setQuestion(rs.getString("question"));
                x.setOption1(rs.getString("option1"));
                x.setOption2(rs.getString("option2"));
                x.setOption3(rs.getString("option3"));
                x.setOption4(rs.getString("option4"));
                x.setAnswers(rs.getString("answer"));
                x.setDate(rs.getDate("createdate"));
                x.setAccountid(rs.getInt("accountid"));
                lst.add(x);
            }
            return lst;
        } catch (Exception e) {
            System.out.println("error when get questions for quiz");
            throw e;
        } finally {
            closeConnection(con, ps, rs);
        }
    }
}

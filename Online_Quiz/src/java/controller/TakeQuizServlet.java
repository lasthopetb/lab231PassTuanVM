/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Question;
import model.Quiz;


public class TakeQuizServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TakeQuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeQuizServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
        if (quiz == null) {
            Account a = (Account) request.getSession().getAttribute("user");
            request.setAttribute("account", a);
            request.setAttribute("title", "Take Quiz");
            request.setAttribute("contentPage", "/view/takeQuiz.jsp");
            request.getRequestDispatcher("/view/view.jsp").forward(request, response);
        } else {
            response.sendRedirect("doquiz");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean startQuiz = false;
        try {
            Account a = (Account) request.getSession().getAttribute("user");
            request.setAttribute("account", a);
            //get parameters form takeQuiz.jsp
            String textNumber = request.getParameter("numOfQues");
            request.setAttribute("numOfQues", textNumber);
            request.setAttribute("title", "Take Quiz");
            request.setAttribute("contentPage", "/view/takeQuiz.jsp");
            QuestionDAO quesDAO = new QuestionDAO();
            Account user = (Account) request.getSession().getAttribute("user");
            int totalQues = quesDAO.getNumberOfQuestions();
            int numOfQues = 0;
            if (textNumber.trim().isEmpty()) {
                request.setAttribute("takequiz_notice", "Please enter a number");
            } else {
                try {
                    numOfQues = Integer.parseInt(textNumber.trim());
                    if (numOfQues > totalQues || numOfQues <= 0) {
                        request.setAttribute("takequiz_notice", "Please enter a integer number between 1 and " + totalQues);
                    } else {
                        List<Question> lstQuiz = quesDAO.getQuestions(numOfQues);
                        HttpSession session = request.getSession();
                        session.setAttribute("lstQuiz", lstQuiz);
                        startQuiz = true;
                        response.sendRedirect("doquiz");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("takequiz_notice", "Error! Wrong format");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("contentPage", "/view/error.jsp");
        } finally {
            if (!startQuiz) {
                request.getRequestDispatcher("/view/view.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

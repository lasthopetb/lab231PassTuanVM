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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Question;


public class MakeQuizServlet extends HttpServlet {

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
            out.println("<title>Servlet MakeQuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MakeQuizServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("title", "Make Quiz");
        request.setAttribute("contentPage", "/view/makeQuiz.jsp");
        request.getRequestDispatcher("/view/view.jsp").forward(request, response);
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
        try {
            //get parameters form makeQuiz.jsp
            String question = request.getParameter("question");
            String options[] = request.getParameterValues("option");
            String answers[] = request.getParameterValues("answer");
            //create boolean array to store answers are checked or not 
            boolean checked[] = new boolean[4];
            //init data, all checked is false if answer is null
            for (int i = 0; i < 4; i++) {
                checked[i] = false;
            }
            if (answers != null) {
                for (int i = 0; i < answers.length; i++) {
                    if (answers[i] != null) {
                        //option answers[i] is checked 
                        checked[Integer.parseInt(answers[i])-1] = true;
                    }
                }
            }
            //check options do not have empty string
            boolean isEmptyOption = false;
            for (int i = 0; i < options.length; i++) {
                if (options[i].trim().isEmpty()) {
                    isEmptyOption = true;
                    break;
                }
            }

            request.setAttribute("question", question);
            request.setAttribute("option", options);
            request.setAttribute("answer", answers);
            request.setAttribute("checked", checked);

            //check empty parameters
            if (question.trim().equals("")) {
                request.setAttribute("makequiz_notice", "Not empty question");
            } else if (isEmptyOption) {
                request.setAttribute("makequiz_notice", "Not empty option");
            } else if (answers == null || answers.length==4) {
                request.setAttribute("makequiz_notice", "Please choose at least 1 answer and at most 3 answers");
            } else {
                Account user = (Account) request.getSession().getAttribute("user");
                QuestionDAO qDAO = new QuestionDAO();
                //get current date
                long millis= System.currentTimeMillis();  
                Date date= new Date(millis);
                Question q = new Question(question, options[0], options[1], options[2], options[3],answers, date, user.getId());
                // add question
                qDAO.addQuestion(q);
                request.setAttribute("makequiz_notice", "Make quiz successful");
            }
            request.setAttribute("title", "Make Quiz");
            request.setAttribute("contentPage", "/view/makeQuiz.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("contentPage", "/view/error.jsp");
        } finally {
            request.getRequestDispatcher("/view/view.jsp").forward(request, response);
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

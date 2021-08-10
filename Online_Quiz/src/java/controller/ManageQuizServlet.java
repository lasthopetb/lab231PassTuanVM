/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Question;


public class ManageQuizServlet extends HttpServlet {

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
            out.println("<title>Servlet ManageQuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageQuizServlet at " + request.getContextPath() + "</h1>");
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
        try {
            QuestionDAO quesDAO = new QuestionDAO();
            //get current user
            Account user = (Account) request.getSession().getAttribute("user");
            if (user.getType().equals("teacher")) {
                int pageSize = 3;
                int currentPage = 1;
                //get total news and pages
                int totalQuestions = quesDAO.getNumberOfQuestionsByAccountId(user.getId());
                request.setAttribute("totalQuestions", totalQuestions);
                int totalPages = (totalQuestions % pageSize == 0) ? totalQuestions / pageSize : (totalQuestions / pageSize) + 1;

                String current = request.getParameter("page");
                //find current page and show message if currentpage is negative,greater than totalpages or wrong format
                if (current != null) {
                    try {
                        currentPage = Integer.parseInt(current);
                        if (currentPage > totalPages || currentPage <= 0) {
                            request.setAttribute("error1", "Not found");
                            currentPage = 1;
                        }
                    } catch (NumberFormatException e) {
                        request.setAttribute("error2", "Error! Wrong format");
                    }
                }
                //get list results of current page
                List<Question> listQuestions = quesDAO.getQuestionsByPageNumber(user.getId(), currentPage, pageSize);
                request.setAttribute("listQuestions", listQuestions);
                request.setAttribute("page", currentPage);
                request.setAttribute("totalPages", totalPages);
            }
            request.setAttribute("title", "Manage Quiz");
            request.setAttribute("contentPage", "/view/manageQuiz.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("contentPage", "/view/error.jsp");
        } finally {
            request.getRequestDispatcher("/view/view.jsp").forward(request, response);
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
        processRequest(request, response);
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

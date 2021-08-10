/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;


public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Login");
        request.setAttribute("contentPage", "/view/login.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get username and password from textfield
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("login_notice", "Not empty username or password");
            request.setAttribute("contentPage", "/view/login.jsp");
            request.setAttribute("title", "Login");
            request.getRequestDispatcher("/view/view.jsp").forward(request, response);
        } else {
            try {
                AccountDAO accDAO = new AccountDAO();
                //check correct account
                Account user = accDAO.getAccount(username, password);
                if (user != null) {
                    //create a session
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    request.setAttribute("account", user);
//                session.setMaxInactiveInterval(600);
                    response.sendRedirect("home");
                } else {
                    //if account is not correct, message login fail
                    request.setAttribute("login_notice", "Username or password is not correct");
                    request.setAttribute("contentPage", "/view/login.jsp");
                    request.setAttribute("title", "Login");
                    request.getRequestDispatcher("/view/view.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("contentPage", "/view/error.jsp");
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

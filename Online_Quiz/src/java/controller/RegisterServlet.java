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
import model.Account;


public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean checkEmail(String s) {
        String regex = "^[a-zA-Z0-9]+@([a-zA-Z]+\\.){1,2}+[a-zA-Z]+$";
        //X@Y.Z or X@Y.Z.T
        return s.matches(regex);
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
        request.setAttribute("title", "Register");
        request.setAttribute("contentPage", "/view/register.jsp");
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        String email = request.getParameter("email");

        request.setAttribute("username", username);
        request.setAttribute("email", email);
        if (type.equals("teacher")) {
            request.setAttribute("type1", "selected");
        } else {
            request.setAttribute("type2", "selected");
        }

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            request.setAttribute("register_notice", "Not empty username, password, or email");
            request.setAttribute("contentPage", "/view/register.jsp");
            request.setAttribute("title", "Register");
            request.getRequestDispatcher("/view/view.jsp").forward(request, response);
        } else {

            try {
                AccountDAO accDAO = new AccountDAO();
                if (accDAO.checkUsernameExist(username)) {
                    request.setAttribute("register_notice", "Username existed");
                    doGet(request, response);
                } else if (!checkEmail(email)) {
                    request.setAttribute("register_notice", "Email is wrong format");
                    doGet(request, response);
                } else {
                    Account a = new Account(username, password, type, email);
                    accDAO.createAccount(a);
                    request.getSession().setAttribute("user", a);
                    response.sendRedirect("home");
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

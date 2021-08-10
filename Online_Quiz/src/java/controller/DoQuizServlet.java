/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import java.util.Arrays;
import model.Question;
import model.Quiz;


public class DoQuizServlet extends HttpServlet {

    private boolean checkAnswer(String[] ans, String[] op) {
        //first condition to check 2 arrays are equals
        if (ans.length != op.length) {
            return false;
        }
        //create a boolean array to store if array options is contains answer or not
        boolean[] test = new boolean[ans.length];
        Arrays.fill(test, false);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < op.length; j++) {
                //if an option equal an answer, test = true
                if (ans[i].equals(op[j])) {
                    test[i] = true;
                }
            }
        }
        for (int i = 0; i < test.length; i++) {
            //if array options do not contain an answer, return false
            if (!test[i]) {
                return false;
            }
        }
        return true;
    }

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
            out.println("<title>Servlet DoQuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DoQuizServlet at " + request.getContextPath() + "</h1>");
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
            request.setAttribute("title", "Do Quiz");
            request.setAttribute("contentPage", "/view/doQuiz.jsp");
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("user");
            request.setAttribute("account", acc);
            List<Question> lstQuiz = (List<Question>) session.getAttribute("lstQuiz");
            if (lstQuiz == null) {
                response.sendRedirect("takequiz");
            } else {
                Quiz quiz = (Quiz) session.getAttribute("quiz");
                int currentQuestion;
                if (quiz == null) {
                    long startTime = System.currentTimeMillis();
                    session.setAttribute("startTime", startTime);
                    long endTime = startTime + lstQuiz.size() * 5000;
                    session.setAttribute("endTime", endTime);
                    request.setAttribute("time", lstQuiz.size() * 5000);
                    Date date = new Date(startTime);
                    quiz = new Quiz(acc.getId(), date, 0);
                    session.setAttribute("quiz", quiz);
                    currentQuestion = 0;
                    session.setAttribute("currentQuestion", currentQuestion);
                } else {
                    currentQuestion = (int) session.getAttribute("currentQuestion");
                    long currentTime = System.currentTimeMillis();
                    long endTime = (long) session.getAttribute("endTime");
                    request.setAttribute("time", endTime - currentTime);
                }
                Question question = lstQuiz.get(currentQuestion);
                request.setAttribute("question", question);
                request.getRequestDispatcher("/view/view.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("contentPage", "/view/error.jsp");
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
        try {
            request.setAttribute("title", "Do Quiz");
            request.setAttribute("contentPage", "/view/doQuiz.jsp");

            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("user");

            request.setAttribute("account", acc);

            long currentTime = System.currentTimeMillis();
            long endTime = (long) session.getAttribute("endTime");
            request.setAttribute("time", endTime - currentTime);
            
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            List<Question> lstQuiz = (List<Question>) session.getAttribute("lstQuiz");
            //confirm before question
            int beforeQuestion = (int) session.getAttribute("currentQuestion");
            Question q = lstQuiz.get(beforeQuestion);
            String options[] = request.getParameterValues("option");
            if (options == null) {
                //don't choose any option
                System.out.println("sai");
            } else if (checkAnswer(q.getAnswers(), options)) {
                //correct answer, add mark
                System.out.println("dung");
                quiz.setResult(Math.round((quiz.getResult() + 10.0 / lstQuiz.size()) * 10.0) / 10.0);
            } else {
                //wrong answer
                System.out.println("sai");
            }
            int currentQuestion = beforeQuestion + 1;
            String timeup = request.getParameter("timeup");
            //go to next question or submit quiz
            if (currentQuestion < lstQuiz.size() && timeup.equals("false")) {
                //check not out of index quiz list, go to next question
                session.setAttribute("currentQuestion", currentQuestion);
                Question question = lstQuiz.get(currentQuestion);
                request.setAttribute("question", question);
            } else {
                //submit quiz
                if (currentTime >= endTime + 5000) {
                    request.setAttribute("cheated", "Your test is rejected");
                    quiz.setStatus("rejected");
                } else {
                    request.setAttribute("result", quiz.getResult());
                    if (quiz.getResult() >= 5) {
                        request.setAttribute("status", "Passed");
                        quiz.setStatus("passed");
                    } else {
                        request.setAttribute("status", "Not Passed");
                        quiz.setStatus("not passed");
                    }
                    
                }
                QuizDAO qDao = new QuizDAO();
                qDao.addQuiz(quiz);
                request.setAttribute("title", "Result");
                request.setAttribute("contentPage", "/view/result.jsp");
                session.removeAttribute("quiz");
                session.removeAttribute("lstQuiz");
                session.removeAttribute("currentQuestion");
                session.removeAttribute("startTime");
                session.removeAttribute("endTime");
            }
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

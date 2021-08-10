

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/manageQuiz.css" rel="stylesheet" type="text/css"/>
        <script src="js/manageQuiz.js" type="text/javascript"></script>
    </head>
    <body>
        <c:if test="${allowed}">
            <c:choose>
                <c:when test="${error1 ne null}">
                    <!--page not found-->
                    <p class="notice">${error1}</p>
                </c:when>  

                <c:when test="${error2 ne null}">
                    <!--wrong format page-->
                    <p class="notice">${error2}</p>
                </c:when>

                <c:when test="${empty listQuestions}">
                    <!--empty questions list-->
                    <p class="text">Number of questions: <span class="text text-blue">0</span></p>
                </c:when>  

                <c:otherwise>
                    <!--Questions list-->
                    <table border="0">
                        <tr>
                            <td id="first"><p class="text">Number of questions: <span class="text text-blue">${totalQuestions}</span></p></td>
                            <td id="second"></td>
                            <td id="third"></td>
                        </tr>
                        <tr></tr>
                        <tr>
                            <td class="text blue-text">Question</td>
                            <td class="text blue-text">DateCreated</td>
                            <td class="text blue-text">Edit</td>
                        </tr>
                        <c:forEach var="ques" items="${listQuestions}">
                            <tr>
                                <td class="text">${ques.getQuestion()} </td>
                                <td class="text">${ques.getDate()}</td>
                                <td class="text"><button onclick="confirmDelete(${ques.getId()})">Delete</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div id="paging">
                        <script>
                            renderPager("paging",${page},${totalPages}, 2);
                        </script>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${!allowed}">
            <p class="notice">You are not allowed to use this function</p>
        </c:if>
    </body>
</html>

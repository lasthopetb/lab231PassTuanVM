

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/makeQuiz.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if test="${allowed}">
            <form action="makequiz" method="post">
                <table border="0">
                    <tr>
                        <td class="text-area">Question:</td>
                        <td>
                            <textarea class="text-question" name="question" >${question}</textarea>
                        </td>
                    </tr>
                    <c:forEach var="i" begin="1" end="4" step="1" >
                        <tr>
                            <td class="text-area">Option ${i}:</td>
                            <td>
                                <textarea class="text-option"  name="option"  >${option[i-1]}</textarea>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="text">Answer(s):</td>
                        <td>
                            <c:forEach var="i" begin="1" end="4" step="1">
                                <input type="checkbox" name="answer" value="${i}" 
                                       <c:if test="${checked[i-1]}"> checked </c:if> 
                                       /> <span class="text">Option ${i}</span> 
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" class="button" value="Save"/>
                        </td>
                    </tr>
                </table>
            </form>
            <p class="notice">${makequiz_notice}</p>            
        </c:if>
        <c:if test="${!allowed}">
            <p class="notice">You are not allowed to use this function</p>
        </c:if>
    </body>
</html>

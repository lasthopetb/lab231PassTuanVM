

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty cheated}">
            <div class="notice">${cheated}</div>
        </c:if>
        <c:if test="${empty cheated}">
            <p class="text">
                <span>Your score </span>
                <span class="text-blue">${result} (${result*10}%) </span>
                <span 
                    <c:if test="${result<5}">
                    class="notice"
                    </c:if>
                    <c:if test="${result>=5}">
                    class="text-blue"
                    </c:if>
                    > - ${status} </span>
            </p>
            <p class="text">
                <span>Take another test </span>
                <a href="takequiz">
                    <button>Start</button>
                </a>
            </p>
        </c:if>
    </body>
</html>

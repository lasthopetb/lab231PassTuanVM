
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link href="css/view.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <div class="content">
                <div class="menu">
                    <ul class="menu-items">
                        <li><a href="home">Home</a></li>
                        <li><a href="takequiz">Take Quiz</a></li>
                        <li><a href="makequiz">Make Quiz</a></li>
                        <li><a href="managequiz">Manage Quiz</a></li>
                            <c:if test="${isLoggedIn}">
                            <li><a href="logout">Log out</a></li>
                            </c:if>
                    </ul>
                </div>
                <div class="contentPage">
                    <jsp:include page="${contentPage}" />
                </div>
            </div>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Home Page</title>
           
            <link href="css/detail.css" rel="stylesheet" type="text/css"/>
        </head>
        <body> 
            <div class="container-detail">
            <jsp:include page="Header.jsp"/>
            <div class="content-detail">
                <div class="main-detail">
                    <c:if test="${not empty iderror}">
                        <div class="error-detail">
                            ${iderror}
                        </div>
                    </c:if>
                    <c:if test="${empty iderror}">
                        <div class="tittle-detail">
                            ${one.title}
                        </div>
                        <div class="image-detail">
                            <img src="${imagePath}${one.image}"/>
                        </div>
                        <div class="text-detail">
                            ${one.description}
                        </div>
                        <div class="signature-detail">
                            <div class="icon1-detail"></div>
                            <div class="icon2-detail"></div>
                           By ${one.author} | ${one.dateConvert}
                        </div>
                    </c:if>
                </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>

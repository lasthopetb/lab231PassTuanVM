

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="takequiz" method="post">
            <p class="text">
                <span>Welcome </span>
                <span class="account">${account.getUser()}</span>
            </p>
            
            <br>
            
            <p class="text">
                Enter number of questions:
            </p>
            
            <p class="text">
                <input type="text" name="numOfQues" class="textfield_takequiz" value="${numOfQues}">
            </p>
            
            <p class="text">
                <input type="submit" value="Start"> 
            </p>
        </form>
            <p class="notice">${takequiz_notice}</p>
    </body>
</html>

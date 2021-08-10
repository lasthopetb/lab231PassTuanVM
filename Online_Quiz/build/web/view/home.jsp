

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--username-->
        <p class="text">
            <span>Welcome </span>
            <span class="account">${account.getUser()}</span>
        </p>
        <!--email-->
        <p class="text">
            <span>Email: </span>
            <span class="account">${account.getEmail()}</span>
        </p>
        <!--type-->
        <p class="text">
            <span>Type: </span>
            <span class="account">${account.getType()}</span>
        </p>
    </body>
</html>

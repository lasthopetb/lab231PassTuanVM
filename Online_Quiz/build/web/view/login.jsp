<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/login_register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <form action="login" method="post">
            <table border="0">
                <tr>
                    <td><p class="text title">Login Form</p></td>
                    <td></td>
                </tr>
                <tr></tr>
                <tr>
                    <td class="text">User Name:</td>
                    <td><input type="text" name="username" class="textfield_Login" value="${username}"></td>
                </tr>
                <tr>
                    <td class="text"> Password:</td>
                    <td><input type="password" name="password" class="textfield_Login"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Sign in"> 
                        <a class="text register" href="register">Register</a></td>
                </tr>  
            </table>
        </form>
        <p class="notice">${login_notice}</p>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login_register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="register" method="post">
            <table border="0">
                <tr>
                    <td><p class="text title">Registration Form</p></td>
                    <td></td>
                </tr>
                <tr></tr>
                <tr>
                    <td class="text">User Name:</td>
                    <td><input type="text" name="username" value="${username}" class="textfield_Login"  /></td>
                </tr>
                <tr>
                    <td class="text"> Password:</td>
                    <td><input type="password" name="password" class="textfield_Login"  /></td>
                </tr>
                <tr>
                <td class="text">User type:</td>
                <td>
                    <select name="type">
                        <option value="teacher" ${type1}>Teacher</option>
                        <option value="student" ${type2}>Student</option>
                    </select>
                </td>
                </tr>
                <tr>
                    <td class="text">Email:</td>
                    <td><input type="text" name="email" value="${email}" class="textfield_Login"  /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form>
        <p class="notice">${register_notice}</p>
    </body>
</html>

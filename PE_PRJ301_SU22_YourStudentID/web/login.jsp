<%-- 
    Document   : login
    Created on : 30-06-2022
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <h1>Login information</h1>
        <form action="MainController" method="POST">
            UserID <input type="text" name="userID" value="" /><br>
            Password <input type="password" name="password" value="" /><br>
            <input type="submit" value="Login" name="action"/>
        </form>
        ${requestScope.LOGINFAIL}
    </body>
    
</html>


<%-- 
    Document   : login
    Created on : Nov 2, 2023, 4:00:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            <p style="color: red">${ms}</p>
            <p style="color: green">${ms1}</p>
            Username: <input type="text" name="user"><br/>
            Password: <input type="password" name="pass"><br/>
            <input type="submit" value="Login">
        </form>
    </body>
</html>

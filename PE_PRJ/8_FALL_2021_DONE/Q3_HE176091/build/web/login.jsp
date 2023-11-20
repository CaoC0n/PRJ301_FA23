<%-- 
    Document   : login
    Created on : Nov 3, 2023, 10:03:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            Username: <input type="text" name="user">
            <br/>
            Password: <input type="password" name="pass"><br/>
            <input type="submit" value="Login">
            <br/><br/>
            ${err}
        </form>
    </body>
</html>

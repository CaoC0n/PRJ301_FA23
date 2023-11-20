<%-- 
    Document   : login
    Created on : Nov 3, 2023, 11:08:08 PM
    Author     : Fpt
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
            <div>Username: <input type="text" name="name" value="${name}" required=""></div>
            <div>Password: <input type="text" name="pass" value="${pass}" required=""></div>
            <div><button>Login</button></div>
        </form>
        <div>${mess}</div>

    </body>
</html>

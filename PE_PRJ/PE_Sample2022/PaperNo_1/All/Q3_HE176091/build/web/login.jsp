
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            UserName: <input type="text" name="username" value="" />
            <br>
            Password:<input type="password" name="password" value="" />
            <br>
            <p style="color: red;">${messError}</p>
            <p style="color: green;">${messError1}</p>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>

<%-- 
    Document   : getfirst
    Created on : Nov 3, 2023, 9:27:22 PM
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
        <h1>HE150167</h1>
        <form action="getfirst" method="post">
            <input type="hidden" name="mssv" value="HE150167" />
            Get first <input type="text" name="letter"> letter(s)
            <br/>
            <input type="submit" value="Get"><br/><br/>
            ${err}
            ${ms}
            ${ms1}
        </form>
    </body>
</html>

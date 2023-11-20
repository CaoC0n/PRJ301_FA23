<%-- 
    Document   : certificate
    Created on : Nov 4, 2023, 2:53:26 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="certificate" method="post">
            <table border="1">
                <tr>
                    <td></td>
                    <c:forEach items="${listC}" var="lc">
                        <td>${lc.name}</td>
                    </c:forEach>
                </tr>
                <c:forEach items="${listS}" var="ls">
                    <tr>
                        <td>${ls.name}</td>
                        <td><input type="checkbox" name="check"></td>
                        <td><input type="checkbox" name="check"></td>
                        <td><input type="checkbox" name="check"></td>
                        <td><input type="checkbox" name="check"></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Save">
        </form>
    </body>
</html>

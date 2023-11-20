<%-- 
    Document   : MyExam
    Created on : Nov 5, 2023, 2:50:20 PM
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
        <form action="add" method="post">
            <table>
                <tr>
                    <td>Code:</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Number of passengers:</td>
                    <td><input type="text" name="number"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="ADD"></td>
                    <td>${err}</td>
                </tr>
            </table>
        </form>
        
        List of Plane:
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Number of passengers</td>
            </tr>
            <c:forEach items="${student}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.number}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>

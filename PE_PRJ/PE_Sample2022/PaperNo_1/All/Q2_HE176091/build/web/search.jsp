<%-- 
    Document   : search
    Created on : Nov 1, 2023, 8:49:58 PM
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
        <form action="search">
            Name: <input type="text" name="name"> <input type="submit" value="Search">
        </form>

        <table border="1" style="margin-top: 100px">
            <thead>   
                <tr>
                    <th>Sid</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Date</th>
                </tr>
            </thead>   
            <c:forEach items="${requestScope.search}" var="s">
                <tbody>    
                    <tr>
                        <td>${s.sid}</td>
                        <td>${s.name}</td>
                        <td>${(s.gender) ? "1" : "0"}</td>
                        <td>${s.date}</td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </body>
</html>

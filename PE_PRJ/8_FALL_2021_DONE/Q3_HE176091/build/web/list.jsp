<%-- 
    Document   : list
    Created on : Nov 3, 2023, 10:13:06 PM
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
        <form action="list" method="post">
            <select name="title">
                <c:forEach items="${list}" var="l">
                    <option >${l.title}</option>
                </c:forEach>
            </select> <input type="submit" value="Filter">
        </form>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Fullname</th>
                <th>Sex</th>
                <th>DOB</th>
                <th>Email</th>
                <th>SchoolYear</th>
                <th>Action</th>
            </tr>
            
            <c:forEach items="${listByTitle}" var="list">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>${list.sex}</td>
                    <td>${list.dob}</td>
                    <td>${list.email}</td>
                    <td>${list.schoolYear}</td>
                    <td><a href="delete?sid=${list.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>

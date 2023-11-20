<%-- 
    Document   : search
    Created on : Nov 2, 2023, 7:22:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="get">
            Group: <select name="group">
                <option value="">ALL</option>
                <c:forEach items="${listG}" var="g">
                    <option value="${g.gid}">${g.gname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search">
        </form>

        <table border="1" style="margin-top: 50px">
            <thead>
                <tr>
                    <th>cid</th> 
                    <th>cname</th> 
                    <th>gender</th> 
                    <th>dob</th> 
                    <th>gname</th> 
                    <th>created_by</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="l">
                    <tr>
                        <td>${l.cid}</td>
                        <td>${l.cname}</td>
                        <td>${(l.cgender) ? "1" : "0"}</td>
                        <td>${l.cdate}</td>
                        <td>${l.gname}</td>
                        <td>${l.ccreated_by}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

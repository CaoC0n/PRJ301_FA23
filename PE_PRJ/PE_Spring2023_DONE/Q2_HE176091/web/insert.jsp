<%-- 
    Document   : insert
    Created on : Nov 2, 2023, 4:00:59 PM
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
        Sesion of: ${sessionScope.user.displayname}
        <br/>
        <form action="insert" method="post">
            Name: <input type="text" name="name"><br/>
            Gender: <input type="radio" name="gender" value="1">Male
            <input type="radio" name="gender" value="0">Female
            <br/>
            Dob: <input type="date" name="dob"><br/>
            Group: <select name="group">
                <c:forEach items="${listG}" var="g">
                    <option value="${g.gid}">${g.gname}</option>
                </c:forEach>
            </select>
            <input type="text" name="cb" value="${sessionScope.user.username}" hidden=""><br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : discuss.jsp
    Created on : Oct 30, 2023, 9:19:06 PM
    Author     : tungl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="t" items="${list}">
            <h1>Thread: ${t.getTcontent()}</h1>
            <c:forEach var="c" items="${t.getlComment()}">
                <p>${c.userid}: ${c.ctitle}</p>
            </c:forEach>
            <input type="text" name="comment"/> <input type="submit" value="Save" />
        </c:forEach>

    </body>
</html>

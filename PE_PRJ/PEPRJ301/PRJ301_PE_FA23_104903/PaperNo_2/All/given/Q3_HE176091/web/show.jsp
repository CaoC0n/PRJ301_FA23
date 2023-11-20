<%-- 
    Document   : show
    Created on : Nov 5, 2023, 3:08:36 PM
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
        <form action="show" method="post" style="margin-bottom: 50px">
            Supplier filter:
            <table style="border: 1px solid black">
                <tr>
                    <td>Supplier name: </td>
                    <td><input type="text" name="name"></td>
                    <td><input type="submit" value="Filter by name"><td>
                </tr>
                <tr>
                    <td>Year of birth: </td>
                    <td><input type="text" name="dob"></td>
                    <td><input type="submit" value="Filter by year"><td>
                </tr>
            </table>

        </form>

        List of Supplier:
        <table border="1">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Date of birth</td>
                <td>Gender</td>
                <td>Address</td>
                <td></td>
            </tr>
            <c:forEach items="${listS}" var="supplier">
                <tr>
                    <td>${supplier.id}</td>
                    <td>${supplier.name}</td>
                    <td>${supplier.date}</td>
                    <td>${supplier.gender ? "Male" : "Female"}</td>
                    <td>${supplier.address}</td>
                    <td><a href="delete?code=${supplier.id}">delete</a></td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>

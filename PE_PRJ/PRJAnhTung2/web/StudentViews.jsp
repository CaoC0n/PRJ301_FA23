<%-- 
    Document   : StudentViews
    Created on : Oct 14, 2023, 3:45:12 PM
    Author     : quangcto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student list</h1>
        <form action="UpdateStudent" method="POST">
            <h2>Create student</h2>
            <table >
                <h2>Update</h2>
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td><input type="text" name="id" value="${studentUpdate.getId()}" /></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="${studentUpdate.getName()}" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>

                            <input type="radio" name="gender" value="1" ${checkedMale} />Male
                            <input type="radio" name="gender" value="0"  ${checkedFemale} />Female
                        </td>
                    </tr>
                    <tr>
                        <td>Department</td>
                        <td>
                            <select name="department">
                                <c:if test="${studentUpdate != null}">
                                    <option value="${studentUpdate.getDepId()}">${studentUpdate.getDepId()}</option>
                                </c:if>
                                <c:forEach var="i" items="${listD}">
                                    <option value="${i.getId()}">${i.getId()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>GPA: </td>
                        <td><input type="text" name="gpa" value="${studentUpdate.getGpa()}" /></td>
                    </tr>
                    <tr>
                        <td>DOB</td>
                        <td><input type="date" name="dob" value="${studentUpdate.getDob()}" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" value="${studentUpdate.getAddress()}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="submit" value="Create"/>
                            <input type="submit" name="submit" value="Save" />
                        </td>
                    </tr>
                </tbody>
                <p style="color: red">${mess}</p>
            </table>

        </form>

        <form action="Search" method="POST">
            <h2>Filter</h2>
            <p>Name: <input type="text" name="key" value="${key}" /> <input type="submit" value="Search" /></p>
            <p>
                Department: 
                <select name="department">
                    <option value="" selected="">All</option>
                    <c:forEach var="i" items="${listD}">
                        <option value="${i.getId()}">${i.getName()}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Filter" />
            </p>
            <p>
                <input type="radio" name="gender" value="1" checked=""/>Male
                <input type="radio" name="gender" value="0"  />Female
            </p>
        </form>
        <table border ="1">

            <tbody>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>Department</td>
                    <td>Gpa</td>
                    <td>Dob</td>
                    <td>Address</td>
                    <td>Action</td>
                </tr>
                <c:forEach var="s" items="${list}">
                    <tr>
                        <td>${s.getId()}</td>
                        <td>${s.getName()}</td>
                        <td>${s.isGender() ? "male" : "female"}</td>
                        <td>${s.getDname()}</td>
                        <td>${s.getGpa()}</td>
                        <td>${s.getDob()}</td>
                        <td>${s.getAddress()}</td>
                        <td>
                            <a href="Delete?id=${s.getId()}">Delete </a>|
                            <a href="UpdateStudent?id=${s.getId()}">Update</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>

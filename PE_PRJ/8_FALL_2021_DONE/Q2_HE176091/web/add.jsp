<%-- 
    Document   : add
    Created on : Nov 3, 2023, 9:45:34 PM
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

        <form action="add" method="post">
            <table>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title"></td> 
                </tr>
                <tr>
                    <td>Startdate (yyyy/MM/dd)</td>
                    <td><input type="text" name="startdate"></td> 
                </tr>
                <tr>
                    <td>Enddate (yyyy/MM/dd)</td>
                    <td><input type="text" name="enddate"></td> 
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td> 
                </tr>
            </table>
        </form>
    </body>
</html>

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.StudentDAO;
import Entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 *
 * @author quangcto
 */
@WebServlet(name = "CreateStudent", urlPatterns = {"/CreateStudent"})
public class CreateStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get data tu form
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Boolean gender = request.getParameter("gender").equals("1");
        String department = request.getParameter("department");
        Float gpa = Float.parseFloat(request.getParameter("gpa"));
        Date dob = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");
        
        // set data -> object
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setGender(gender);
        s.setDepId(department);
        s.setGpa(gpa);
        s.setDob(dob);
        s.setAddress(address);
        //------------------------
        StudentDAO sDAO = new StudentDAO();
        if(!sDAO.createStudent(s)){
            String mess = "ID does exist!";
            request.setAttribute("mess", mess);
        }
        response.sendRedirect("StudentList");
    }

}

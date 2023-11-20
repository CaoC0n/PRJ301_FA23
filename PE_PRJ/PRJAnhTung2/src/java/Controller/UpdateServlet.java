/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DepartmentDAO;
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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateStudent"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO sDAO = new StudentDAO();
        DepartmentDAO dDTO = new DepartmentDAO();
        boolean flag = true;
        request.setAttribute("listD", dDTO.getAllDepartment());
        Student s = sDAO.getAllStudentByID(id);
        if (!s.isGender()) {
            flag = false;
        }
        String checkMale = "";
        String checkFemale = "";
        if (flag) {
            checkMale = "checked";
        } else {
            checkFemale = "checked";
        }
        request.setAttribute("checkedMale", checkMale);
        request.setAttribute("checkedFemale", checkFemale);
        request.setAttribute("studentUpdate", s);
        request.getRequestDispatcher("StudentViews.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        String submit = request.getParameter("submit");
        // set data -> object
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setGender(gender);
        s.setDob(dob);
        s.setDepId(department);
        s.setGpa(gpa);
        s.setAddress(address);
        //------------------------
        StudentDAO sDAO = new StudentDAO();
        if (submit.equalsIgnoreCase("Create")) {
            if (!sDAO.createStudent(s)) {
                String mess = "ID does exist!";
                request.setAttribute("mess", mess);
            }
            response.sendRedirect("StudentList");
        } else {
            if (!sDAO.updateStudent(s)) {
                String mess = "Update fail!";
                request.setAttribute("mess", mess);
            }
            response.sendRedirect("StudentList");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

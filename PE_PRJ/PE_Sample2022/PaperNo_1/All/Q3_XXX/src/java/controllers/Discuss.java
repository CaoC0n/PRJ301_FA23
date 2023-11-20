/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import models.*;

/**
 *
 * @author Fpt
 */
public class Discuss extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Discuss</title>");  
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            Account acc = (Account)session.getAttribute("acc");
            if(acc == null){
                out.println("<h1>access denied</h1>");
            }else{
                out.println("<h1>well come</h1>");
                DAO dao = new DAO();
                List<Threads> th = dao.findThread();
                for (Threads thread : th) {
                    out.println("<div>Thread: "+ thread.getTcontent() + "</div>");
                    List<Comment> cmt = dao.findComment(thread.getTid());
                    for (Comment comment : cmt) {
                        out.println("<div>"+ comment.getUserid().toUpperCase().substring(0,1) + comment.getUserid().substring(1,2)+ " " + comment.getUserid().toUpperCase().substring(2,3)  +": "+comment.getCtitle() + "</div>");
                    }
                    out.println("<form action='discuss' method='post'><input type='text' name='comment'><input type='hidden' name='userid' value='"+acc.getUserid()+"'><input type='hidden' name='tid' value='"+thread.getTid()+"'><button>Save</button></form>");
                    out.println("<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String comment  = request.getParameter("comment");
        String userid  = request.getParameter("userid");
        String tid  = request.getParameter("tid");
        DAO dao = new DAO();
        dao.insertComment(comment, userid, tid);
        
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

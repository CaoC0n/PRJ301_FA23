/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Certificate;
import model.Student;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<Student> getAllStudent() {
        List<Student> s = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.add(new Student(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getString(5))
                );
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return s;
    }

    public List<Certificate> getAllCertificate() {
        List<Certificate> c = new ArrayList<>();
        String sql = "SELECT * FROM Certificate";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Certificate(
                        rs.getString(1),
                        rs.getString(2))
                );
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return c;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getAllCertificate());
    }
}

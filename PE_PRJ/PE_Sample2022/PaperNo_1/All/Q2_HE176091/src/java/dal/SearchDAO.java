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
import model.Student;

/**
 *
 * @author Admin
 */
public class SearchDAO extends DBContext {

    public List<Student> searchStudentByName(String key) {
        List<Student> s = new ArrayList<>();
        String sql = "SELECT [sid]\n"
                + "      ,[name]\n"
                + "      ,[gender]\n"
                + "      ,[dob]\n"
                + "  FROM [dbo].[Student] WHERE [name] like '%" + key + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getDate(4))
                );
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return s;
    }

    public static void main(String[] args) {
        SearchDAO dao = new SearchDAO();
        System.out.println(dao.searchStudentByName("in"));
    }
}

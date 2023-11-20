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
import model.Account;
import model.ListStudent;
import model.SchoolYear;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public Account login(String username, String password) {
        String query = "SELECT * FROM Account WHERE [username] = ? AND [password] =?";
        Account u = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                u = new Account();
                u.setUsername(resultSet.getString(1));
                u.setPassword(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public List<ListStudent> getAllStudentByTitle(String title) {
        String query = "SELECT s.id, s.fullname, s.sex, s.dob, s.email, sy.title\n"
                + "FROM Student s, Student_Class sc, Class c, SchoolYear sy\n"
                + "where (s.id = sc.studentid) and (sc.classid = c.id) \n"
                + "and (c.schoolyear = sy.id) and (sy.title = ?)";
        List<ListStudent> s = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.add(new ListStudent(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public List<SchoolYear> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[startdate]\n"
                + "      ,[enddate]\n"
                + "  FROM [dbo].[SchoolYear]";
        List<SchoolYear> s = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                s.add(new SchoolYear(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                )
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Student]\n"
                + "      WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void deleteStudentClass(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Student_Class]\n"
                    + "      WHERE studentid=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.delete(8);
    }

}

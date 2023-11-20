/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBContext.DBcontext;
import Entity.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quangcto
 */
public class StudentDAO extends DBcontext {

    public boolean createStudent(Student s) {
        String query = "INSERT INTO [dbo].[Student]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[gender]\n"
                + "           ,[depId]\n"
                + "           ,[gpa]\n"
                + "           ,[dob]\n"
                + "           ,[address])\n"
                + "     VALUES("
                + "           ?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, s.getId());
            statement.setString(2, s.getName());
            statement.setBoolean(3, s.isGender());
            statement.setString(4, s.getDepId());
            statement.setFloat(5, s.getGpa());
            statement.setDate(6, s.getDob());
            statement.setString(7, s.getAddress());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean updateStudent(Student s) {
        String query = "UPDATE [dbo].[Student]\n"
                + "   SET [name] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[depId] = ?\n"
                + "      ,[gpa] = ?\n"
                + "      ,[dob] = ?\n"
                + "      ,[address] = ?\n"
                + " WHERE [id] = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, s.getName());
            statement.setBoolean(2, s.isGender());
            statement.setString(3, s.getDepId());
            statement.setFloat(4, s.getGpa());
            statement.setDate(5, s.getDob());
            statement.setString(6, s.getAddress());
            statement.setInt(7, s.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Student> getAllStudent() {
        String query = "SELECT s.[id]\n"
                + "      ,s.[name]\n"
                + "      ,[gender]\n"
                + "      ,[depId]\n"
                + "      ,[gpa]\n"
                + "      ,[dob]\n"
                + "      ,[address]\n"
                + "	  ,d.[name] as [dname]\n"
                + "  FROM [dbo].[Student] s\n"
                + "JOIN [dbo].[Department] d ON s.depId = d.id\n"
                + "ORDER BY s.[id]";
        List<Student> student = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setGender(resultSet.getBoolean("gender"));
                s.setDepId(resultSet.getString("depID"));
                s.setGpa(resultSet.getFloat("gpa"));
                s.setDob(resultSet.getDate("dob"));
                s.setAddress(resultSet.getString("address"));
                s.setDname(resultSet.getString("dname"));

                student.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;
    }

    public List<Student> getAllStudentByName(String key, String filter, boolean gender) {
        String query = "SELECT s.[id]\n"
                + "      ,s.[name]\n"
                + "      ,[gender]\n"
                + "      ,[depId]\n"
                + "      ,[gpa]\n"
                + "      ,[dob]\n"
                + "      ,[address]\n"
                + "	  ,d.[name] as [dname]\n"
                + "  FROM [dbo].[Student] s\n"
                + "JOIN [dbo].[Department] d ON s.depId = d.id\n"
                + "WHERE s.[name] LIKE '%" + key + "%'\n"
                + "AND [depId] LIKE '%" + filter + "%'\n"
                + "AND [gender] = '"+gender+"'\n"
                + "ORDER BY s.[id]";
        List<Student> student = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setGender(resultSet.getBoolean("gender"));
                s.setDepId(resultSet.getString("depID"));
                s.setGpa(resultSet.getFloat("gpa"));
                s.setDob(resultSet.getDate("dob"));
                s.setAddress(resultSet.getString("address"));
                s.setDname(resultSet.getString("dname"));

                student.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;
    }

    public Student getAllStudentByID(int id) {
        String query = "SELECT s.[id]\n"
                + "      ,s.[name]\n"
                + "      ,[gender]\n"
                + "      ,[depId]\n"
                + "      ,[gpa]\n"
                + "      ,[dob]\n"
                + "      ,[address]\n"
                + "	  ,d.[name] as [dname]\n"
                + "  FROM [dbo].[Student] s\n"
                + "JOIN [dbo].[Department] d ON s.depId = d.id\n"
                + "WHERE s.[id] = " + id + "\n"
                + "ORDER BY s.[id]";
        Student s = new Student();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setGender(resultSet.getBoolean("gender"));
                s.setDepId(resultSet.getString("depID"));
                s.setGpa(resultSet.getFloat("gpa"));
                s.setDob(resultSet.getDate("dob"));
                s.setAddress(resultSet.getString("address"));
                s.setDname(resultSet.getString("dname"));

                return s;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE FROM [dbo].[Student]\n"
                + "      WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        StudentDAO sDTO = new StudentDAO();
        Student s = new Student(5, "tng", true, "SE", 10, Date.valueOf("2002-02-02"), "HN");
        System.out.println(sDTO.updateStudent(s));
    }
}

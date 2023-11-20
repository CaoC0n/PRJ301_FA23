/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBContext.DBcontext;
import Entity.Department;
import Entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quangcto
 */
public class DepartmentDAO extends DBcontext {

    public Department getDepByID(String id) {
        String query = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[infor]\n"
                + "  FROM [dbo].[Department]\n"
                + "  Where id = ?";
        Department d = null;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                d = new Department();
                d.setId(resultSet.getString("id"));
                d.setName(resultSet.getString("name"));
                d.setInfor(resultSet.getString("infor"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return d;
    }

    public List<Department> getAllDepartment() {
        String query = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[infor]\n"
                + "  FROM [dbo].[Department]";
        List<Department> dept = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Department s = new Department();
                s.setId(resultSet.getString("id"));
                s.setName(resultSet.getString("name"));
                s.setInfor(resultSet.getString("infor"));
               
                dept.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dept;
    }

    public static void main(String[] args) {
        DepartmentDAO dDTO = new DepartmentDAO();
        System.out.println(dDTO.getAllDepartment());
    }
}

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
import model.Supplier;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<Supplier> getAllSupplier() {
        List<Supplier> s = new ArrayList<>();
        String sql = "SELECT [SupplierID]\n"
                + "      ,[SupplierName]\n"
                + "      ,[BirthDate]\n"
                + "      ,[Gender]\n"
                + "      ,[Address]\n"
                + "  FROM [Y23FA1B1].[dbo].[Suppliers]";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.add(new Supplier(rs.getString(1), rs.getString(2),
                        rs.getString(3).substring(0, rs.getString(3).length() - 10),
                        rs.getBoolean(4),
                        rs.getString(5)));
            }

        } catch (SQLException e) {
        }
        return s;
    }

    public List<Supplier> searchBySupplier(String name) {
        List<Supplier> s = new ArrayList<>();
        String sql = "SELECT [SupplierID]\n"
                + "      ,[SupplierName]\n"
                + "      ,[BirthDate]\n"
                + "      ,[Gender]\n"
                + "      ,[Address]\n"
                + "  FROM [Y23FA1B1].[dbo].[Suppliers]\n"
                + "  where [SupplierName] like '%" + name + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.add(new Supplier(rs.getString(1), rs.getString(2),
                        rs.getString(3).substring(0, rs.getString(3).length() - 10),
                        rs.getBoolean(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return s;
    }

    public void delete(String id) {
        String sql = "DELETE FROM [dbo].[Suppliers]\n"
                + "      WHERE [SupplierID] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public List<Supplier> searchByYear(String dob) {
        List<Supplier> s = new ArrayList<>();
        String sql = "SELECT [SupplierID]\n"
                + "      ,[SupplierName]\n"
                + "      ,[BirthDate]\n"
                + "      ,[Gender]\n"
                + "      ,[Address]\n"
                + "  FROM [Y23FA1B1].[dbo].[Suppliers]\n"
                + "  where [BirthDate] like '%" + dob + "%'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.add(new Supplier(rs.getString(1), rs.getString(2),
                        rs.getString(3).substring(0, rs.getString(3).length() - 10),
                        rs.getBoolean(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return s;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.searchByYear("1987"));
    }

}

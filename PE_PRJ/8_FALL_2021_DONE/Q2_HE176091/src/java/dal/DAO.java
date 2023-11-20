/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public void insert(String title, String startdate, String enddate) {
        String sql = "INSERT INTO SchoolYear VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, startdate);
            ps.setString(3, enddate);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}

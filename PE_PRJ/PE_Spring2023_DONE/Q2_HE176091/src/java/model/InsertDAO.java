/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class InsertDAO extends DBContext {

    public void insertCandidate(CandidateTBL c) {
        String sql = "INSERT INTO [dbo].[CandidateTBL]\n"
                + "           ([cname]\n"
                + "           ,[gender]\n"
                + "           ,[dob]\n"
                + "           ,[gid]\n"
                + "           ,[created_by])\n"
                + "     VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getCname());
            ps.setBoolean(2, c.isGender());
            ps.setString(3, c.getDob());
            ps.setInt(4, c.getGid());
            ps.setString(5, c.getCreated_by());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}

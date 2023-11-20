/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GroupDAO extends DBContext {

    public List<GroupTBL> getAllGroupTBL() {
        ArrayList<GroupTBL> list = new ArrayList<>();
        String sql = "select * from GroupTBL";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new GroupTBL(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
        }

        return list;
    }
    
    public static void main(String[] args) {
        GroupDAO g = new GroupDAO();
        System.out.println(g.getAllGroupTBL());
    }
}

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
public class SearchDAO extends DBContext {

    public List<Candidate> getAll() {
        List<Candidate> c = new ArrayList<>();
        String sql = "select c.cid, c.cname, c.gender, c.dob, g.gname, c.created_by \n"
                + " from CandidateTBL c, GroupTBL g\n"
                + " where (c.gid = g.gid)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Candidate(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6))
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public List<Candidate> getAllById(int cid) {
        List<Candidate> c = new ArrayList<>();
        String sql = "select c.cid, c.cname, c.gender, c.dob, g.gname, c.created_by \n"
                + " from CandidateTBL c, GroupTBL g\n"
                + " where (c.gid = g.gid) and g.gid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Candidate(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6))
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static void main(String[] args) {
        SearchDAO dao = new SearchDAO();
        System.out.println(dao.getAll());
    }
}

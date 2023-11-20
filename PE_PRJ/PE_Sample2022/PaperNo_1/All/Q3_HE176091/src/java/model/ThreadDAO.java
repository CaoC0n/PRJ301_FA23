/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tungl
 */
public class ThreadDAO extends dal.DBContext {

    public List<Threads> getAllThread() {
        String query = "SELECT [tid]\n"
                + "      ,[tcontent]\n"
                + "  FROM [dbo].[Thread]";
        List<Threads> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Threads s = new Threads();
                s.setTid(resultSet.getInt(1));
                s.setTcontent(resultSet.getString(2));
                list.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public List<Comment> getCommentByTid(int id) {
        String query = "SELECT [cid]\n"
                + "      ,[ctitle]\n"
                + "      ,[userid]\n"
                + "      ,[tid]\n"
                + "  FROM [dbo].[Comment]\n"
                + "WHERE [tid] = ?";
        List<Comment> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Comment s = new Comment();
                s.setCid(resultSet.getInt(1));
                s.setCtitle(resultSet.getString(2));
                s.setUserid(resultSet.getString(3));
                s.setTid(resultSet.getInt(4));

                list.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public static void main(String[] args) {
        ThreadDAO dao = new ThreadDAO();
        System.out.println(dao.getAllThread().size());
    }
}

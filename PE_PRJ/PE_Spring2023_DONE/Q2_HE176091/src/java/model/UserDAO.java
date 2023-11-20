/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    public User login(String username, String password) {
        String query = "SELECT * FROM UserTBL WHERE [username] = ? AND [password] =?";
        User u = null;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                u = new User();
                u.setUsername(resultSet.getString(1));
                u.setPassword(resultSet.getString(2));
                u.setDisplayname(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }
}

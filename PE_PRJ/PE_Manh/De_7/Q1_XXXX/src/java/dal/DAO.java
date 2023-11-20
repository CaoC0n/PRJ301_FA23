/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public Account login(String username, String password) {
        String query = "SELECT * FROM Account WHERE [accountid] = ? AND [password] =?";
        Account u = null;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                u = new Account();
                u.setUser(resultSet.getString(1));
                u.setPass(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }
}

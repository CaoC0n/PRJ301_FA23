/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tungl
 */
public class AccountDAO extends dal.DBContext {

    public Account login(String username, String password) {
        String query = "SELECT * FROM Account WHERE [userid] = ? AND [password] =?";
        Account u = null;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                u = new Account();
                u.setUserid(resultSet.getString(1));
                u.setPassword(resultSet.getString(2));
                u.setDisplayName(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }

    public static void main(String[] args) {
        AccountDAO aDAO = new AccountDAO();
        System.out.println(aDAO.login("mra", "123"));
    }
}

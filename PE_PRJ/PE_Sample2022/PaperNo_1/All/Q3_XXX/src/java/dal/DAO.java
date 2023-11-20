/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import models.Account;
import models.Comment;
import models.Threads;


/**
 *
 * @author Fpt
 */
public class DAO extends DBContext{
    public Account findAccount(String username, String password){
        try {
            String sql = "select * from Account where userid = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Threads> findThread(){
        List<Threads> acc = new Vector<>();
        try {
            String sql = "select * from Thread";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                acc.add(new Threads(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (Exception e) {
        }
        return acc;
    }
    
    public List<Comment> findComment(int tid){
        List<Comment> cmt = new Vector<>();
        try {
            String sql = "select * from Comment where tid = " + tid;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cmt.add(new Comment(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
        }
        return cmt;
    }
    
    public void insertComment(String ctitle, String userid, String tid){
        try {
            String sql = "insert into Comment(ctitle, userid, tid) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ctitle);
            ps.setString(2, userid);
            ps.setInt(3, Integer.parseInt(tid));
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.findAccount("mra", "123").getPassword());
    }
}
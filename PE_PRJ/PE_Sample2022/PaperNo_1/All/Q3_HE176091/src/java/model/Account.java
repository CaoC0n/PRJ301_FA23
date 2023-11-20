/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tungl
 */
public class Account {

    String userid;
    String password;
    String displayName;

    public Account() {
    }

    public Account(String userid, String password, String displayName) {
        this.userid = userid;
        this.password = password;
        this.displayName = displayName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Account{" + "userid=" + userid + ", password=" + password + ", displayName=" + displayName + '}';
    }

}

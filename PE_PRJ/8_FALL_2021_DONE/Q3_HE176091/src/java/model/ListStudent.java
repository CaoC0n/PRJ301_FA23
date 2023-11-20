/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ListStudent {

    private int id;
    private String name;
    private String sex;
    private String dob;
    private String email;
    private String schoolYear;

    public ListStudent() {
    }

    public ListStudent(int id, String name, String sex, String dob, String email, String schoolYear) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.email = email;
        this.schoolYear = schoolYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return "ListStudent{" + "id=" + id + ", name=" + name + ", sex=" + sex + ", dob=" + dob + ", email=" + email + ", schoolYear=" + schoolYear + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;



/**
 *
 * @author ADMIN
 */
public class Student {
    private int id;
    private String name;
    private boolean gender;
    private String depId;
    private float gpa;
    private Date dob;
    private String address;
    private String dname;
    public Student(int id, String name, boolean gender, String depId, float gpa, Date dob, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.depId = depId;
        this.gpa = gpa;
        this.dob = dob;
        this.address = address;
    }

    public Student() {
        
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", depId=" + depId + ", gpa=" + gpa + ", dob=" + dob + ", address=" + address + '}';
    }
    
    
    
}

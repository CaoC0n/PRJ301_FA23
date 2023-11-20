/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class CandidateTBL {

    private int cid;
    private String cname;
    private boolean gender;
    private String dob;
    private int gid;
    private String created_by;

    public CandidateTBL() {
    }

    public CandidateTBL(String cname, boolean gender, String dob, int gid, String created_by) {
        this.cname = cname;
        this.gender = gender;
        this.dob = dob;
        this.gid = gid;
        this.created_by = created_by;
    }

    public CandidateTBL(int cid, String cname, boolean gender, String dob, int gid, String created_by) {
        this.cid = cid;
        this.cname = cname;
        this.gender = gender;
        this.dob = dob;
        this.gid = gid;
        this.created_by = created_by;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "CandidateTBL{" + "cid=" + cid + ", cname=" + cname + ", gender=" + gender + ", dob=" + dob + ", gid=" + gid + ", created_by=" + created_by + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Admin
 */
public class Candidate {

    private int cid;
    private String cname;
    private boolean cgender;
    private String cdate;
    private String gname;
    private String ccreated_by;

    public Candidate() {
    }

    public Candidate(int cid, String cname, boolean cgender, String cdate, String gname, String ccreated_by) {
        this.cid = cid;
        this.cname = cname;
        this.cgender = cgender;
        this.cdate = cdate;
        this.gname = gname;
        this.ccreated_by = ccreated_by;
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

    public boolean isCgender() {
        return cgender;
    }

    public void setCgender(boolean cgender) {
        this.cgender = cgender;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getCcreated_by() {
        return ccreated_by;
    }

    public void setCcreated_by(String ccreated_by) {
        this.ccreated_by = ccreated_by;
    }

    @Override
    public String toString() {
        return "Candidate{" + "cid=" + cid + ", cname=" + cname + ", cgender=" + cgender + ", cdate=" + cdate + ", gname=" + gname + ", ccreated_by=" + ccreated_by + '}';
    }

}

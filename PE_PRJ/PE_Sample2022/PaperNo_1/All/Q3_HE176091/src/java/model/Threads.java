/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author tungl
 */
public class Threads {
    int tid;
    String tcontent;
    List<Comment> lComment;

    public Threads() {
    }

    public Threads(int tid, String tcontent, List<Comment> lComment) {
        this.tid = tid;
        this.tcontent = tcontent;
        this.lComment = lComment;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTcontent() {
        return tcontent;
    }

    public void setTcontent(String tcontent) {
        this.tcontent = tcontent;
    }

    public List<Comment> getlComment() {
        ThreadDAO dao = new ThreadDAO();
        return lComment = dao.getCommentByTid(tid);
    }

    public void setlComment(List<Comment> lComment) {
        this.lComment = lComment;
    }

    @Override
    public String toString() {
        return "Thread{" + "tid=" + tid + ", tcontent=" + tcontent + ", lComment=" + lComment + '}';
    }
    
}

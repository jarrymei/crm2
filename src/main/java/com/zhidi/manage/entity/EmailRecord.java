package com.zhidi.manage.entity;

import java.util.Date;

public class EmailRecord {
    private String emailrecordid;

    private String userid;

    private String toaddr;

    private String subject;

    private Date sendtime;

    private Short status;

    private byte[] content;

    public String getEmailrecordid() {
        return emailrecordid;
    }

    public void setEmailrecordid(String emailrecordid) {
        this.emailrecordid = emailrecordid == null ? null : emailrecordid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getToaddr() {
        return toaddr;
    }

    public void setToaddr(String toaddr) {
        this.toaddr = toaddr == null ? null : toaddr.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
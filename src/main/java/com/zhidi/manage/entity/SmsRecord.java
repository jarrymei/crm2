package com.zhidi.manage.entity;

import java.util.Date;

public class SmsRecord {
    private String smsrecordid;

    private String userid;

    private String telephone;

    private Date sendtime;

    private byte[] recordcontent;

    public String getSmsrecordid() {
        return smsrecordid;
    }

    public void setSmsrecordid(String smsrecordid) {
        this.smsrecordid = smsrecordid == null ? null : smsrecordid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public byte[] getRecordcontent() {
        return recordcontent;
    }

    public void setRecordcontent(byte[] recordcontent) {
        this.recordcontent = recordcontent;
    }
}
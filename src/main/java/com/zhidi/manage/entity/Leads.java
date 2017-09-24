package com.zhidi.manage.entity;

import java.util.Date;

public class Leads {
    private String leadsid;

    private String owneruserid;

    private String creatoruserid;

    private String name;

    private String position;

    private String contactsname;

    private String saltname;

    private String mobile;

    private String email;

    private Date createtime;

    private Date updatetime;

    private Short isdeleted;

    private String deleteuserid;

    private Date deletetime;

    private Short istransformed;

    private String transformuserid;

    private String contactsid;

    private String customerid;

    private String businessid;

    private String nextstep;

    private Date nextsteptime;

    private Date havetime;

    private String address;

    private String source;

    private String leadnote;

    public String getLeadsid() {
        return leadsid;
    }

    public void setLeadsid(String leadsid) {
        this.leadsid = leadsid == null ? null : leadsid.trim();
    }

    public String getOwneruserid() {
        return owneruserid;
    }

    public void setOwneruserid(String owneruserid) {
        this.owneruserid = owneruserid == null ? null : owneruserid.trim();
    }

    public String getCreatoruserid() {
        return creatoruserid;
    }

    public void setCreatoruserid(String creatoruserid) {
        this.creatoruserid = creatoruserid == null ? null : creatoruserid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getContactsname() {
        return contactsname;
    }

    public void setContactsname(String contactsname) {
        this.contactsname = contactsname == null ? null : contactsname.trim();
    }

    public String getSaltname() {
        return saltname;
    }

    public void setSaltname(String saltname) {
        this.saltname = saltname == null ? null : saltname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Short getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Short isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getDeleteuserid() {
        return deleteuserid;
    }

    public void setDeleteuserid(String deleteuserid) {
        this.deleteuserid = deleteuserid == null ? null : deleteuserid.trim();
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public Short getIstransformed() {
        return istransformed;
    }

    public void setIstransformed(Short istransformed) {
        this.istransformed = istransformed;
    }

    public String getTransformuserid() {
        return transformuserid;
    }

    public void setTransformuserid(String transformuserid) {
        this.transformuserid = transformuserid == null ? null : transformuserid.trim();
    }

    public String getContactsid() {
        return contactsid;
    }

    public void setContactsid(String contactsid) {
        this.contactsid = contactsid == null ? null : contactsid.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid == null ? null : businessid.trim();
    }

    public String getNextstep() {
        return nextstep;
    }

    public void setNextstep(String nextstep) {
        this.nextstep = nextstep == null ? null : nextstep.trim();
    }

    public Date getNextsteptime() {
        return nextsteptime;
    }

    public void setNextsteptime(Date nextsteptime) {
        this.nextsteptime = nextsteptime;
    }

    public Date getHavetime() {
        return havetime;
    }

    public void setHavetime(Date havetime) {
        this.havetime = havetime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getLeadnote() {
        return leadnote;
    }

    public void setLeadnote(String leadnote) {
        this.leadnote = leadnote == null ? null : leadnote.trim();
    }
}
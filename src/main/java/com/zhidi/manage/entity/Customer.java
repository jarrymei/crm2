package com.zhidi.manage.entity;

import java.util.Date;

public class Customer {
    private String customerid;

    private String owneruserid;

    private String creatoruserid;

    private String name;

    private String origin;

    private String address;

    private String zipcode;

    private String industry;

    private String annualrevenue;

    private String ownership;

    private String rating;

    private Date createtime;

    private Date updatetime;

    private Short isdeleted;

    private Short islocked;

    private String deleteuserid;

    private Date deletetime;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getAnnualrevenue() {
        return annualrevenue;
    }

    public void setAnnualrevenue(String annualrevenue) {
        this.annualrevenue = annualrevenue == null ? null : annualrevenue.trim();
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership == null ? null : ownership.trim();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating == null ? null : rating.trim();
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

    public Short getIslocked() {
        return islocked;
    }

    public void setIslocked(Short islocked) {
        this.islocked = islocked;
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
}
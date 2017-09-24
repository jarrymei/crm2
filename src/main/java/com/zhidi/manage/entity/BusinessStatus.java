package com.zhidi.manage.entity;

public class BusinessStatus {
    private String statusid;

    private String name;

    private Long orderid;

    private Short isend;

    private String description;

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid == null ? null : statusid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Short getIsend() {
        return isend;
    }

    public void setIsend(Short isend) {
        this.isend = isend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
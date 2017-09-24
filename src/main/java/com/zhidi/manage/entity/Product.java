package com.zhidi.manage.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String productid;

    private String categoryid;

    private String name;

    private String creatoruserid;

    private BigDecimal costprice;

    private BigDecimal suggestedprice;

    private String developmentteam;

    private Date developmenttime;

    private String link;

    private Date createtime;

    private Date updatetime;

    private String description;

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCreatoruserid() {
        return creatoruserid;
    }

    public void setCreatoruserid(String creatoruserid) {
        this.creatoruserid = creatoruserid == null ? null : creatoruserid.trim();
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getSuggestedprice() {
        return suggestedprice;
    }

    public void setSuggestedprice(BigDecimal suggestedprice) {
        this.suggestedprice = suggestedprice;
    }

    public String getDevelopmentteam() {
        return developmentteam;
    }

    public void setDevelopmentteam(String developmentteam) {
        this.developmentteam = developmentteam == null ? null : developmentteam.trim();
    }

    public Date getDevelopmenttime() {
        return developmenttime;
    }

    public void setDevelopmenttime(Date developmenttime) {
        this.developmenttime = developmenttime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
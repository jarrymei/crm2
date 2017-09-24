package com.zhidi.manage.entity;

import java.util.Date;

public class ProductImages {
    private String imagesid;

    private String productid;

    private Short ismain;

    private String name;

    private String savename;

    private String imagesize;

    private String path;

    private Date createtime;

    private Long sortnum;

    public String getImagesid() {
        return imagesid;
    }

    public void setImagesid(String imagesid) {
        this.imagesid = imagesid == null ? null : imagesid.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public Short getIsmain() {
        return ismain;
    }

    public void setIsmain(Short ismain) {
        this.ismain = ismain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSavename() {
        return savename;
    }

    public void setSavename(String savename) {
        this.savename = savename == null ? null : savename.trim();
    }

    public String getImagesize() {
        return imagesize;
    }

    public void setImagesize(String imagesize) {
        this.imagesize = imagesize == null ? null : imagesize.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getSortnum() {
        return sortnum;
    }

    public void setSortnum(Long sortnum) {
        this.sortnum = sortnum;
    }
}
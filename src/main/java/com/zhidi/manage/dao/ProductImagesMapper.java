package com.zhidi.manage.dao;

import com.zhidi.manage.entity.ProductImages;

public interface ProductImagesMapper {
    int deleteByPrimaryKey(String imagesid);

    int insert(ProductImages record);

    int insertSelective(ProductImages record);

    ProductImages selectByPrimaryKey(String imagesid);

    int updateByPrimaryKeySelective(ProductImages record);

    int updateByPrimaryKey(ProductImages record);
}
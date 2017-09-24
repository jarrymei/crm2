package com.zhidi.manage.dao;

import com.zhidi.manage.entity.ProductCategory;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(String categoryid);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(String categoryid);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}
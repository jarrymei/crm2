package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}
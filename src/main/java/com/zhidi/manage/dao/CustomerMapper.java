package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(String customerid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String customerid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}
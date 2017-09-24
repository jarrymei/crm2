package com.zhidi.manage.dao;

import com.zhidi.manage.entity.BusinessCustomer;

public interface BusinessCustomerMapper {
    int insert(BusinessCustomer record);

    int insertSelective(BusinessCustomer record);
}
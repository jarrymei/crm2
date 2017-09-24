package com.zhidi.manage.dao;

import com.zhidi.manage.entity.BusinessContract;

public interface BusinessContractMapper {
    int insert(BusinessContract record);

    int insertSelective(BusinessContract record);
}
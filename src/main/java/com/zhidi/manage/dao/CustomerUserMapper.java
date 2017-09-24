package com.zhidi.manage.dao;

import com.zhidi.manage.entity.CustomerUser;

public interface CustomerUserMapper {
    int insert(CustomerUser record);

    int insertSelective(CustomerUser record);
}
package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(String businessid);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(String businessid);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}
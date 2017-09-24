package com.zhidi.manage.dao;

import com.zhidi.manage.entity.SmsTemplate;

public interface SmsTemplateMapper {
    int deleteByPrimaryKey(String templateid);

    int insert(SmsTemplate record);

    int insertSelective(SmsTemplate record);

    SmsTemplate selectByPrimaryKey(String templateid);

    int updateByPrimaryKeySelective(SmsTemplate record);

    int updateByPrimaryKey(SmsTemplate record);
}
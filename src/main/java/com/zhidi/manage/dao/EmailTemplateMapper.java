package com.zhidi.manage.dao;

import com.zhidi.manage.entity.EmailTemplate;

public interface EmailTemplateMapper {
    int deleteByPrimaryKey(String templateid);

    int insert(EmailTemplate record);

    int insertSelective(EmailTemplate record);

    EmailTemplate selectByPrimaryKey(String templateid);

    int updateByPrimaryKeySelective(EmailTemplate record);

    int updateByPrimaryKey(EmailTemplate record);
}
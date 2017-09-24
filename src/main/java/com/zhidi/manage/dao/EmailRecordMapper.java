package com.zhidi.manage.dao;

import com.zhidi.manage.entity.EmailRecord;

public interface EmailRecordMapper {
    int deleteByPrimaryKey(String emailrecordid);

    int insert(EmailRecord record);

    int insertSelective(EmailRecord record);

    EmailRecord selectByPrimaryKey(String emailrecordid);

    int updateByPrimaryKeySelective(EmailRecord record);

    int updateByPrimaryKeyWithBLOBs(EmailRecord record);

    int updateByPrimaryKey(EmailRecord record);
}
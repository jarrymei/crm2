package com.zhidi.manage.dao;

import com.zhidi.manage.entity.SmsRecord;

public interface SmsRecordMapper {
    int deleteByPrimaryKey(String smsrecordid);

    int insert(SmsRecord record);

    int insertSelective(SmsRecord record);

    SmsRecord selectByPrimaryKey(String smsrecordid);

    int updateByPrimaryKeySelective(SmsRecord record);

    int updateByPrimaryKeyWithBLOBs(SmsRecord record);

    int updateByPrimaryKey(SmsRecord record);
}
package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Position;

public interface PositionMapper {
    int deleteByPrimaryKey(String positionid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(String positionid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}
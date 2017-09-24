package com.zhidi.manage.dao;

import com.zhidi.manage.entity.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}
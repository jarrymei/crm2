package com.zhidi.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhidi.base.dao.IBaseDao;
import com.zhidi.system.entity.Function;

public interface FunctionMapper extends IBaseDao<Function> {
   
	/**
	 * 根据角色id查询角色信息
	 * @param roleId
	 * @return
	 */
	List<Function> queryFuncByRoleIds(@Param("roleIds") String[] roleIds,@Param("funcType") Long funcType);
}
package com.zhidi.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhidi.base.dao.IBaseDao;
import com.zhidi.system.entity.Function;

public interface FunctionMapper extends IBaseDao<Function> {
   
	/**
	 * 根据角色id查询角色信息
	 * @param roleIds
	 * @param funcType
	 * @return
	 */
	List<Function> queryFuncByRoleIds(@Param("roleIds") String[] roleIds,@Param("funcType") Long funcType);

	/**
	 * 查询所有权限
	 * @return
	 */
	List<Function> getAll();

	/**
	 * 根据登录用户的id和funcCode查询权限
	 * @param userId
	 * @param funcCode
	 * @return
	 */
	Function getFuncByFuncCode(@Param("userId") String userId, @Param("funcCode") String funcCode);
}
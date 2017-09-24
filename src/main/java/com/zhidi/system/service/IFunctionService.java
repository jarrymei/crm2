package com.zhidi.system.service;

import java.util.List;

import com.zhidi.base.service.IBaseService;
import com.zhidi.system.entity.Function;

public interface IFunctionService extends IBaseService<Function> {
	
	List<Function> queryFuncByRoleIds(String[] roleId);

}

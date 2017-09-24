package com.zhidi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.base.service.IBaseService;
import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.system.dao.FunctionMapper;
import com.zhidi.system.entity.Function;
import com.zhidi.system.service.IFunctionService;

@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements IFunctionService {

	@Autowired
	private FunctionMapper functionMapper;
	
	@Autowired
	public void setFcuntionMapper(FunctionMapper fcuntionMapper) {
		super.setBaseDao(fcuntionMapper);
	}

	@Override
	public List<Function> queryFuncByRoleIds(String[] roleId) {
		return functionMapper.queryFuncByRoleIds(roleId, 1L);
	}
}

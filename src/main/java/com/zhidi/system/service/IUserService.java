package com.zhidi.system.service;

import java.util.List;

import com.zhidi.base.service.IBaseService;
import com.zhidi.common.Pager;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;

public interface IUserService extends IBaseService<User> {
	
	User queryByUserName(String username);
	
	Pager queryByPage(Integer pageNumber, Integer pageSize);
	
	void delBatch(List<String> ids);
	
}

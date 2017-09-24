package com.zhidi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.base.dao.IBaseDao;
import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.common.Pager;
import com.zhidi.system.dao.UserMapper;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.entity.vo.UserVO;
import com.zhidi.system.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		super.setBaseDao(userMapper);
	}

	@Override
	public User queryByUserName(String username) {
		return userMapper.queryByUserName(username);
	}

	@Override
	public Pager queryByPage(Integer pageNumber, Integer pageSize) {
		Integer count = userMapper.count();
		Pager page = new Pager();
		page.setTotalRows(count);
		
		List<UserVO> list = userMapper.queryByPage(pageNumber, pageSize);
		page.setData(list);
		return page;
	}

	@Override
	public void delBatch(List<String> ids) {
		userMapper.delBatch(ids);
	}
	
}

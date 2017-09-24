package com.zhidi.base.service.impl;

import org.springframework.stereotype.Service;

import com.zhidi.base.dao.IBaseDao;
import com.zhidi.base.service.IBaseService;
import com.zhidi.system.entity.User;

@Service
public class BaseServiceImpl<T> implements IBaseService<T> {
	
	private IBaseDao<T> baseDao;
	
	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		return baseDao.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return baseDao.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(String id) {
		return baseDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return baseDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return baseDao.updateByPrimaryKey(record);
	}

}

package com.zhidi.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhidi.base.dao.IBaseDao;
import com.zhidi.system.entity.User;
import com.zhidi.system.entity.vo.UserVO;

public interface UserMapper extends IBaseDao<User> {
	
	User queryByUserName(String username);
	
	Integer count();
	
	List<UserVO> queryByPage(@Param("pageNumber") Integer pageNumber, @Param("pageSize") Integer pageSize);
	
	void delBatch(@Param("ids") List<String> ids);
	
}
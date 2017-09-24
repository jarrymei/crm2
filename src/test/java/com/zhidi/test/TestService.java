package com.zhidi.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhidi.system.entity.User;
import com.zhidi.system.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestService {

	@Autowired
	private IUserService userService;
	
	@Test
	public void test() {
		User user = userService.selectByPrimaryKey("E97788B789BD4CCCB4D8C39B199A70D1");
	}
	
	@Test
	public void test2() {
		User user = new User();
//		user.setId("231231231231");
		user.setUsername("meisss2222");
		user.setPassword("asdasdasd");
		userService.insert(user);
	}
	
	@Test
	public void test3() {
		User user = userService.queryByUserName("admin");
		System.out.println(user.getPassword());
	}
}

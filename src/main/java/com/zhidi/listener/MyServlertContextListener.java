package com.zhidi.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhidi.system.entity.Function;
import com.zhidi.system.service.IFunctionService;

/**
 * 应用程序监听器，应用程序启动时加载所有权限url到应用程序上下文中
 */
public class MyServlertContextListener implements ServletContextListener{
	
	Logger log = Logger.getLogger(MyServlertContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String webName = sce.getServletContext().getContextPath();
		log.info("应用程序" + webName + "启动");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		IFunctionService functionService = context.getBean(IFunctionService.class);
		List<Function> list = functionService.getAll();
		List<String> urls = new ArrayList<>();
		log.info("----------加载全部权限开始----------");
		for (Function func : list) {
			urls.add(webName + "/" + func.getFuncurl());
			log.info(webName + "/" + func.getFuncurl());
		}
		log.info("----------加载全部权限结束----------");
		sce.getServletContext().setAttribute("urls", urls);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

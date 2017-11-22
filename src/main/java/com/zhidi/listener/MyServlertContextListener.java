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
 * Ӧ�ó����������Ӧ�ó�������ʱ��������Ȩ��url��Ӧ�ó�����������
 */
public class MyServlertContextListener implements ServletContextListener{
	
	Logger log = Logger.getLogger(MyServlertContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String webName = sce.getServletContext().getContextPath();
		log.info("Ӧ�ó���" + webName + "����");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		IFunctionService functionService = context.getBean(IFunctionService.class);
		List<Function> list = functionService.getAll();
		List<String> urls = new ArrayList<>();
		log.info("----------����ȫ��Ȩ�޿�ʼ----------");
		for (Function func : list) {
			urls.add(webName + "/" + func.getFuncurl());
			log.info(webName + "/" + func.getFuncurl());
		}
		log.info("----------����ȫ��Ȩ�޽���----------");
		sce.getServletContext().setAttribute("urls", urls);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

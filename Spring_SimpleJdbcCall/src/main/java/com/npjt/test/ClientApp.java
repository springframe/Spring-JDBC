package com.npjt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jc.config.JavaConfiguration;
import com.npjt.bo.CustomerBO;
import com.npjt.dao.CustomerDAOImpl;

public class ClientApp {
	public static void main(String[] args) {
		//ceate ioc container
		/*ApplicationContext ap=new ClassPathXmlApplicationContext("com/npjt/commans/applicationContext.xml");*/
		ApplicationContext ap=new AnnotationConfigApplicationContext(JavaConfiguration.class);
		CustomerDAOImpl cdao=ap.getBean("custdao",CustomerDAOImpl.class);
	   cdao.call(7369);
	}

}

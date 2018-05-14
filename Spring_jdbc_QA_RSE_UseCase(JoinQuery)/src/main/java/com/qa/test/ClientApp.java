package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.dao.CustomerDAOImpl;

public class ClientApp {
public static void main(String[] args) {
	//craete ioc container
	ApplicationContext ap=new ClassPathXmlApplicationContext("com/qa/commans/applicationContext.xml");
	CustomerDAOImpl cd=ap.getBean("customer",CustomerDAOImpl.class);

	System.out.println("find the recourd from table==>"+cd.getCustDetailByNo(100));
	System.out.println("find the recourd from table in List==>"+cd.getCustDetailInList(100));
	System.out.println("find the recourd from table in CustBo cls==>"+cd.getCustDetailInList("hello"));
	
}
}

package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.bo.CustomerBO;
import com.qa.dao.CustomerDAOImpl;

public class ClientApp {
public static void main(String[] args) {
	//craete ioc container
	ApplicationContext ap=new ClassPathXmlApplicationContext("com/qa/commans/applicationContext.xml");
	CustomerDAOImpl cd=ap.getBean("customer",CustomerDAOImpl.class);
     CustomerBO cbo=new CustomerBO();
        /*cbo.setSNO(100);*/
        cbo.setFNAME("java");
        cbo.setLNAME("WebService");
        cbo.setEMAILADRESS("abc@gmail.com");
        cbo.setMBNO(7686);
	//System.out.println("incord insert ==>"+cd.InsertCustBo(cbo));
        System.out.println("incord insert ==>"+cd.InsertCustBoByAutoGenerate(cbo));

	
}
}

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
	/*	List<CustomerBO> cbo=cdao.getCustDetailByNo(100);
		System.out.println(cbo);
		System.out.println(cdao.findTitleById(100));*/
		CustomerBO cbo=new CustomerBO();
		cbo.setSno(100);cbo.setFname("sufiyan");cbo.setLname("Alam");cbo.setEmailAdress("abc#gm");cbo.setMbno(878787);
		///System.out.println("insert custBo by sucessfully with;;>"+cdao.InsertByCustBo(cbo));
		System.out.println(cdao.UpdateById(cbo));
		System.out.println(cdao.deleteById(101));
	}

}

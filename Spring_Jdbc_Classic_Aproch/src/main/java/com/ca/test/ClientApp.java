package com.ca.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ca.dao.CustomerDao;

public class ClientApp {
	public static void main(String[] args) {
		//create ioc container
		ApplicationContext ap=new ClassPathXmlApplicationContext("com/ca/commans/applicationContext.xml");
		CustomerDao cusdao= ap.getBean("custdao",CustomerDao.class);
		 System.out.println("call all record==>"+cusdao.getAllCustdetailsInList());
		System.out.println("'==============================================='");
		 System.out.println("call by no==>"+cusdao.getAllCustdetailsByNo(101));
		 System.out.println("'==============================================='");
		 System.out.println("call by name==>"+cusdao.getAllCustdetailsByName("mansur"));
		 System.out.println("'==============================================='");
		 System.out.println("record in map==>"+cusdao.getAllCustdetailsInMap());
		 System.out.println("'==============================================='");
		 System.out.println("insert the record sucessfully==>"+cusdao.insertCustdetails(001,"java","html","abc@mail","23432"));
		 System.out.println("'==============================================='");
		 System.out.println("the record update sucessfully==>"+cusdao.updateCustdetails("hello",100));
		 System.out.println("'==============================================='");
		 System.out.println("the record delete sucessfully==>"+cusdao.deleteCustdetailsByNo(100));
	}

}

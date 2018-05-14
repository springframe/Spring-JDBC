package com.shi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shi.dao.EmployeeDAO;
import com.shi.entity.Employee;

public class HibernateTest {
public static void main(String[] args) {
	//create ioc container
	
	ApplicationContext ap=new ClassPathXmlApplicationContext("com/shi/commans/applicationConfiguration.xml");
	EmployeeDAO edao=ap.getBean("empdao",EmployeeDAO.class);
	Employee ep=new Employee();
	 ep.setSid(100);
	 ep.setFname("Helam");
	 ep.setLname("java");
	 ep.setEmailAdress("abc@gmail");
	 ep.setMbno(97844);
	 System.out.println(edao.saveEmployee(ep));
	 
}
}

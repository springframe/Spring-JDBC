package com.dectx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dectx.command.JobCommand;
import com.dectx.controller.PostJonController;

public class ClientTest {
	public static void main(String[] args) {
		ApplicationContext context=
				
		new ClassPathXmlApplicationContext("com/dectx/commans/application-context.xml");
		JobCommand jcmd=new JobCommand();
		jcmd.setCompNo(2);
		jcmd.setCompName("apple");
		jcmd.setServiceType("production");
		jcmd.setLocation("hyd");
		jcmd.setJobNo(102);
		jcmd.setJobTitle("developer");
		jcmd.setDescription("better job");
		jcmd.setExperiance("10");
		jcmd.setQualification("B.Tech");
		
		PostJonController pjc=context.getBean("jpc",PostJonController.class);
		pjc.insert(jcmd);
	}

}

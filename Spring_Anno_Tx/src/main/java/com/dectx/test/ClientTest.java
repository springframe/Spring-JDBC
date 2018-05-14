package com.dectx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.an.config.RootConfig;
import com.dectx.command.JobCommand;
import com.dectx.controller.PostJonController;

public class ClientTest {
	public static void main(String[] args) {
		ApplicationContext context=
				
		new AnnotationConfigApplicationContext(RootConfig.class);
		JobCommand jcmd=new JobCommand();
		jcmd.setCompNo(1);
		jcmd.setCompName("apple");
		jcmd.setServiceType("production");
		jcmd.setLocation("hyd");
		jcmd.setJobNo(100);
		jcmd.setJobTitle("developer");
		jcmd.setDescription("better job");
		jcmd.setExperiance("10");
		jcmd.setQualification("B.Tech");
		
		PostJonController pjc=context.getBean("newpjCont",PostJonController.class);
		pjc.insert(jcmd);
	}

}

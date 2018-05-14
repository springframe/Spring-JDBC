package com.an.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dectx.controller.PostJonController;

@Configuration
public class ControllerConfig {
	
	@Bean(name="newpjCont",autowire=Autowire.BY_TYPE)
	public PostJonController newpjCont()
	{
		return new PostJonController();
		
	}

}

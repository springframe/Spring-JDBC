package com.an.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dectx.service.PostJobService;

@Configuration
public class ServiceConfig {
	
	@Bean(name="pjService", autowire=Autowire.BY_TYPE)
	public PostJobService pjService()
	{
		return new PostJobService();
		
	}

}

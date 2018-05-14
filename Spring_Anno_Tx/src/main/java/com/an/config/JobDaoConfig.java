package com.an.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dectx.dao.CompanyDAO;
import com.dectx.dao.JobDAO;

@Configuration
public class JobDaoConfig {
	@Bean(name = "newJd", autowire = Autowire.BY_TYPE)
	public JobDAO newJd() {
		return new JobDAO();

	}

}

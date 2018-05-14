package com.an.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;

import com.dectx.dao.CompanyDAO;
import com.dectx.dao.JobDAO;

public class CompanyDaoConfig 
{
	@Bean(name = "cmpDao", autowire = Autowire.BY_TYPE)
	public CompanyDAO cmpDao() {
		return new CompanyDAO();

	}

}

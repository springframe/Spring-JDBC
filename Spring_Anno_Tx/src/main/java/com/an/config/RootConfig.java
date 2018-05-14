package com.an.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.dectx.dao,com.dectx.service,com.dectx.controller")
@Import(value = { PersistencyConfig.class, ServiceConfig.class, ControllerConfig.class, CompanyDaoConfig.class,
		JobDaoConfig.class })
public class RootConfig {

}

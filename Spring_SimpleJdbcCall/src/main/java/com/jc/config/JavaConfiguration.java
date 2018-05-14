package com.jc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.npjt.dao.CustomerDAOImpl;
@ComponentScan(basePackages="com.npjt.dao")
@Configuration
public class JavaConfiguration {
/*	<property name="driverClassName" value="oracle.jdbc.OracleDriver"/>
	<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
	<property name="username" value="system"/>
	<property name="password" value="manager"/>*/
	
	@Bean(name="/ds")
	public  DriverManagerDataSource dataSource()
	{
	DriverManagerDataSource ds=new DriverManagerDataSource();
	   ds.setDriverClassName("oracle.jdbc.OracleDriver");
	   ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	   ds.setUsername("system");
	   ds.setPassword("manager");
	return ds;
	}
	@Bean(name="npjt")
	public NamedParameterJdbcTemplate namedParameterJdbcTempate()
	{
	NamedParameterJdbcTemplate npjt=new NamedParameterJdbcTemplate(dataSource());
	return npjt;	
	 
	}
	@Bean(name="call")
	public SimpleJdbcCall call() {
		SimpleJdbcCall call=new SimpleJdbcCall(dataSource());
		return call;
	}
/*	@Bean(name="custdao")
  public CustomerDAOImpl cdi()
  {
		CustomerDAOImpl cdi=new CustomerDAOImpl();
		
	return null;
	  
  }*/
}

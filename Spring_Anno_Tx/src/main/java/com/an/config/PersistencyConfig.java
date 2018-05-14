package com.an.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.dectx.dao.CompanyDAO;
import com.dectx.dao.JobDAO;

@Configuration
@PropertySource(value = "com/dectx/commans/db.properties")
public class PersistencyConfig {

	@Autowired
	Environment env;

	@Bean(name = "dataSource")
	public DriverManagerDataSource newDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driverClassNmae"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.usn"));
		ds.setPassword(env.getProperty("db.pwd"));
		return ds;
	}

	@Bean(name = "jt")
	public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	@Bean(name="dstManager",autowire=Autowire.BY_TYPE)
public DataSourceTransactionManager dstManager()
{
	return new DataSourceTransactionManager();
	
}

}

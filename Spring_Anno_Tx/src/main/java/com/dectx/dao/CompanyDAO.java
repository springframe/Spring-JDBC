package com.dectx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dectx.bo.CompanyBO;


public class CompanyDAO {
	private String SQL_INSERT="INSERT INTO TB_COMPANYDAO(COMP_NO,COMP_NAME,SERVICE_TYPE,LOCATION) VALUES(?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	public int saveCompany(CompanyBO cbo)
	{
/*	BeanPropertySqlParameterSource sparam=null;
	sparam=new BeanPropertySqlParameterSource(cbo);*/
		int count=jt.update(SQL_INSERT,cbo.getCompNo(),cbo.getCompName(),cbo.getServiceType(),cbo.getlocation());
		return count;
	}
	

}

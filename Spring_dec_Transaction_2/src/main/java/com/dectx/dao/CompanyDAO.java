package com.dectx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dectx.bo.CompanyBO;

@Repository
public class CompanyDAO {
	
	private String SQL_INSERT="INSERT INTO TB_COMPANYDAO(COMP_NO,COMP_NAME,SERVICE_TYPE,LOCATION) VALUES(:compNo,:compName,:serviceType,:location)";
	
	private NamedParameterJdbcTemplate npjt;

	public CompanyDAO(NamedParameterJdbcTemplate npjt) {
		this.npjt = npjt;
	}

	public int saveCompany(CompanyBO cbo)
	{
	BeanPropertySqlParameterSource sparam=null;
	sparam=new BeanPropertySqlParameterSource(cbo);
		int count=npjt.update(SQL_INSERT, sparam);
		return count;
	}
	

}

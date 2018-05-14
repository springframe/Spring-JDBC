package com.dectx.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dectx.bo.JobBO;



public class JobDAO {
	private String SQL_INSERT="INSERT INTO TB_JOBDAO(JOB_NO,JOB_TITLE,DESCRIPTION,EXPRIANCE,QUALIFICATION,COMP_NO) "
			+ "                    VALUES(:jobNo,:jobTitle,:description,:experiance,:qualification,:copmNo)";
	private NamedParameterJdbcTemplate npjt;
	
	public JobDAO(NamedParameterJdbcTemplate npjt) {
		this.npjt = npjt;
	}

	public int saveJob(JobBO jbo)
	{
	BeanPropertySqlParameterSource sparam=null;
	sparam=new BeanPropertySqlParameterSource(jbo);
		int count=npjt.update(SQL_INSERT, sparam);
		return count;
	}
	

}

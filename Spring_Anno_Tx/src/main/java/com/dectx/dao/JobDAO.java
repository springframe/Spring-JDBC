package com.dectx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import com.dectx.bo.JobBO;

public class JobDAO {
	private String SQL_INSERT = "INSERT INTO TB_JOBDAO(JOB_NO,JOB_TITLE,DESCRIPTION,EXPRIANCE,QUALIFICATION,COMP_NO) "
			+ "                    VALUES(?,?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	public int saveJob(JobBO jbo) {
		/*
		 * BeanPropertySqlParameterSource sparam=null; sparam=new
		 * BeanPropertySqlParameterSource(jbo);
		 */
		int count = jt.update(SQL_INSERT, jbo.getJobNo(), jbo.getJobTitle(), jbo.getDescription(), jbo.getExperiance(),
				jbo.getQualification(), jbo.getCopmNo());
		return count;
	}
}

package com.qa.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.qa.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {
	private final String SQL_QRY_FOR_GETDETAILS="SELECT COUNT(*)FROM CUST_JDBC";
	private final String SQL_QRY_GET_GETDETAILS_BY_NO="SELECT LNAME FROM CUST_JDBC WHERE SNO=?";
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public String findDetail(int sno) {
     	
		return jt.queryForObject(SQL_QRY_GET_GETDETAILS_BY_NO,String.class,new Object[] {sno});
	}

	
	

}

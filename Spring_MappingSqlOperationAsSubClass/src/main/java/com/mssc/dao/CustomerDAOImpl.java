package com.mssc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.mssc.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO{

	private DriverManagerDataSource ds;
	public void setDs(DriverManagerDataSource ds) {
		this.ds = ds;
	}


	@Override
	public List<CustomerBO> getCustomerDetailByNo(int sno) {
		// TODO Auto-generated method stub
		return null;
	}

	private final class GetCustomerDetailById extends MappingSqlQuery<CustomerBO> {

		public GetProjectsByTitle(DataSource ds, String sql) {
			super(ds, sql);
			declareParameter(new SqlParameter(java.sql.Types.VARCHAR));
			compile();
		}


/*
	@Override
	public int updateCustBO(CustomerBO cbo) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}

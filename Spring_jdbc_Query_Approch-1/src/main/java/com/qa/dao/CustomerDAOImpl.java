package com.qa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qa.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {
	private final String SQL_QRY_GET_GETDETAILS_BY_NO_in_List="SELECT FNAME FROM CUST_JDBC WHERE SNO=?";
	private final String SQL_QRY_GET_DETAILS_BY_NAME="SELECT SNO,LNAME,EMAILADRESS,MBNO FROM CUST_JDBC WHERE FNAME=?";
	private final String SQL_QRY_GET_GETDETAILS_BY_NO="SELECT FNAME FROM CUST_JDBC WHERE SNO=?";
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public String getCustDetailByNo(int sno) {
   /* String name=jt.queryForObject(SQL_QRY_GET_GETDETAILS_BY_NO,String.class,sno);
    or*/
    String name=jt.queryForObject(SQL_QRY_GET_GETDETAILS_BY_NO,String.class,new Object[]{sno});
		return name;
	}
	@Override
	public List<CustomerBO> getCustDetailInList(int sno) {
		
		
		return jt.queryForObject(SQL_QRY_GET_GETDETAILS_BY_NO_in_List, new CustRowMapperList(),new Object[] {sno});
	}
	private final class CustRowMapperList implements RowMapper<List<CustomerBO>>
	{

		@Override
		public List<CustomerBO> mapRow(ResultSet rs, int row) throws SQLException 
		{
            CustomerBO cbo=null;
          
            List<CustomerBO> lcbo=new ArrayList<CustomerBO>();
            		cbo=new CustomerBO();
            			cbo.setFNAME(rs.getString(1));
            			cbo.setLNAME(rs.getString(2));
            			cbo.setEMAILADRESS(rs.getString(3));
            			cbo.setMBNO(rs.getLong(4));
            			lcbo.add(cbo);
            	       
            		
			return lcbo;
		}
		
	}
	@Override
	public CustomerBO getCustDetailInList(String fname) 
	{
		
		CustomerBO cbo=jt.queryForObject(SQL_QRY_GET_DETAILS_BY_NAME, new CustRowMapper(),new Object[] {fname});
		return cbo;
	}
	private final class CustRowMapper implements RowMapper<CustomerBO>
	{

		@Override
		public CustomerBO mapRow(ResultSet rs, int row) throws SQLException {
           CustomerBO bo=null;
           bo=new CustomerBO();
           bo.setSNO(rs.getInt(1));
           bo.setLNAME(rs.getString(2));
           bo.setEMAILADRESS(rs.getString(3));
           bo.setMBNO(rs.getLong(4));
			
			return bo;
		}
		
	}
	
	
}

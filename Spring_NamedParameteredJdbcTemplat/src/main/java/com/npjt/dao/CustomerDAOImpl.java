package com.npjt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.npjt.bo.CustomerBO;

@Component("custdao")
public class CustomerDAOImpl implements CustomerDAO {
	private final String SQL_GET_BY_NO = "SELECT SNO,FNAME,LNAME,EMAILADRESS,MBNO FROM CUST_NPJT WHERE SNO=:sid";
	private final String SQL_FIND_BY_NO = "SELECT FNAME FROM CUST_NPJT WHERE SNO=:sno";
	
	private final String SQL_INSERT_CUSTBO = "INSERT INTO CUST_NPJT (SNO,FNAME,LNAME,EMAILADRESS,MBNO) VALUES(:sno,:fname,:lname,:emailadress,:mbno)";
	
	private final String SQL_UPDATE_CUSTBO_BY_NO = "UPDATE CUST_NPJT SET FNAME=:fname, LNAME=:lname,EMAILADRESS=:emailadress,MBNO=:mbno WHERE SNO=:sid";
	
	private final String SQL_DELETE_CUSTBO_BY_NO = "DELETE FROM CUST_NPJT  WHERE SNO=:sid";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	/*public void setNpjt(NamedParameterJdbcTemplate npjt) {
		this.npjt = npjt;
	}*/
	@Override
	public List<CustomerBO> getCustDetailByNo(int sno) {
			System.out.println(sno);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sid", sno);
			//return npjt.query(SQL_GET_BY_NO, map, new CustRowMapper());
			System.out.println(SQL_GET_BY_NO);
			List<CustomerBO> c=npjt.query(SQL_GET_BY_NO, map, new CustRowMapper());
			return c;
		}
	private final class CustRowMapper implements RowMapper<CustomerBO>{
		@Override
		public CustomerBO mapRow(ResultSet rs, int row) throws SQLException {
       List<CustomerBO> lcbo=new ArrayList<>();
       CustomerBO cbo=new CustomerBO();
         cbo.setSno(rs.getInt(1));
         cbo.setFname(rs.getString(2));
         cbo.setLname(rs.getString(3));
		 cbo.setEmailAdress(rs.getString(4));	
		 cbo.setMbno(rs.getLong(5));
			return cbo;
		}}

	@Override
	public String findTitleById(int sno) {
         Map<String,Object> map=new HashMap<>();
        map.put("sno",sno);
		return npjt.queryForObject(SQL_FIND_BY_NO,map,String.class);
	}
	@Override
	public int InsertByCustBo(CustomerBO cbo) {
		//:sno,:fname,:lname,:emailadress,:mbno
		Map<String,Object> map=new HashMap<>();
		map.put("sno",cbo.getSno());
		map.put("fname",cbo.getFname());
		map.put("lname",cbo.getLname());
		map.put("emailadress",cbo.getEmailAdress());
		map.put("mbno",cbo.getMbno());
        int a=npjt.update(SQL_INSERT_CUSTBO,map);
		return a;
	}
	@Override
	public String UpdateById(CustomerBO cbo) {
     Map<String,Object> map=new HashMap<>();
		
		map.put("sid",cbo.getSno());
		map.put("fname",cbo.getFname());
		map.put("lname",cbo.getLname());
		map.put("emailadress",cbo.getEmailAdress());
		map.put("mbno",cbo.getMbno());
        //map.put("sid",sno);
        int a=npjt.update(SQL_UPDATE_CUSTBO_BY_NO, map);
        if(a!=0)
		return "RECORD UPDATE SUCESSESFULLY";
        else {
        	return "RECORD is NOT UPDATE SUCESSESFULLY";
		}
	}
	@Override
	public String deleteById(int sno) {
		Map<String,Object> map=new HashMap<>();
		map.put("sid", sno);
		int a=npjt.update(SQL_DELETE_CUSTBO_BY_NO, map);
		  if(a!=0)
				return "RECORD DELETE SUCESSESFULLY";
		        else {
		        	return "RECORD is NOT DELETE SUCESSESFULLY";
				}
	}


	
}

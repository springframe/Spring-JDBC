package com.ca.dao;

import java.util.List;
import java.util.Map;

import com.ca.bo.CustomerBO;

public interface CustomerDao {
	public List<CustomerBO> getAllCustdetailsInList();
	public List<CustomerBO> getAllCustdetailsByNo(int sno);
	public List<CustomerBO> getAllCustdetailsByName(String fname);
	public Map<String,Object> getAllCustdetailsInMap();
	public int insertCustdetails(int sno,String fname,String lname,String emailAdr,String mbno);
	public int updateCustdetails(String fname,int sno);
	public int deleteCustdetailsByNo(int sno);
	

}

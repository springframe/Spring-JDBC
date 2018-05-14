package com.qa.dao;

import java.util.List;

import com.qa.bo.CustomerBO;

public interface  CustomerDAO {
	public String getCustDetailByNo(int sno);
	public List<CustomerBO> getCustDetailInList(int sno);
	public CustomerBO getCustDetailInList(String fname);

}

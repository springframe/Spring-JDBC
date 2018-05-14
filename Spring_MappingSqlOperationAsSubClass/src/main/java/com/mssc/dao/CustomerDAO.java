package com.mssc.dao;

import java.util.List;

import com.mssc.bo.CustomerBO;

public interface CustomerDAO {
	public List<CustomerBO> getCustomerDetailByNo(int sno);
/*	public int updateCustBO(CustomerBO cbo);*/

}

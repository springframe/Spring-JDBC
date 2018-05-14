package com.npjt.dao;

import java.util.List;

import com.npjt.bo.CustomerBO;

public interface CustomerDAO {
	public  List<CustomerBO> getCustDetailByNo(int sno);
	public String findTitleById(int sno);
	public int InsertByCustBo(CustomerBO cbo);
	public String UpdateById(CustomerBO cbo);
	public String deleteById(int sno);

}

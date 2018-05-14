package com.qa.dao;

import java.util.List;

import com.qa.bo.CustomerBO;

public interface  CustomerDAO {
	/*public String InsertCustBo(CustomerBO cbo);*/
	public Object InsertCustBoByAutoGenerate(CustomerBO cbo);
}

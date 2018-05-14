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
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.npjt.bo.CustomerBO;

@Component("custdao")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SimpleJdbcCall scj;
	@Override
	public void call(int sno) {
		System.out.println("0000000000");
		scj.setProcedureName("Cust_prco");
		 Map<String,Object> map= new HashMap<>();
		 map.put("sno",sno);
		 Map<String,Object> abc= scj.execute(map);
		 System.out.println(abc);
		 CustomerBO cbo=new CustomerBO();
		// cbo.setSno((int)map.get("sno"));
		 
    
     
	}
	}

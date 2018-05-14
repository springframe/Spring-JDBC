package com.dectx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dectx.bo.CompanyBO;
import com.dectx.bo.JobBO;
import com.dectx.command.JobCommand;
import com.dectx.dao.CompanyDAO;
import com.dectx.dao.JobDAO;


public class PostJobService {
	boolean flage=true;
	@Autowired
	private CompanyDAO cdao;
	
	@Autowired
	private JobDAO jdao;

   @Transactional
	public void insertCompany(JobCommand jcommand)
	{
		CompanyBO cbo=new CompanyBO();
		cbo.setCompNo(jcommand.getCompNo());
		cbo.setCompName(jcommand.getCompName());
		cbo.setServiceType(jcommand.getServiceType());
		cbo.setLocation(jcommand.getLocation());
		
		cdao.saveCompany(cbo);

		
		JobBO jbo=new JobBO();
		jbo.setJobNo(jcommand.getJobNo());
		jbo.setJobTitle(jcommand.getJobTitle());
		jbo.setDescription(jcommand.getDescription());
		jbo.setExperiance(jcommand.getExperiance());
		jbo.setQualification(jcommand.getQualification());
		jbo.setCopmNo(jcommand.getCompNo());
		jdao.saveJob(jbo);
		flage=true;
		if(flage==true)
		{
			System.out.println("comdao and jobdao insert");
			}
			else {
				System.out.println("RollBack the data");
			}
		}
		
	/*	if(B!=0)
		return "JOB DATA INSERT SUCESSFULLY";
		else
	  return "JOB DATA NOT INSERT SUCESSFULLY";*/
		//return "DATA INSERT SUCESS FULLY";
			
		
	}



package com.dectx.service;

import com.dectx.bo.CompanyBO;
import com.dectx.bo.JobBO;
import com.dectx.command.JobCommand;
import com.dectx.dao.CompanyDAO;
import com.dectx.dao.JobDAO;

public class PostJobService {
	private CompanyDAO cdao;
	private JobDAO jdao;

	public void setCdao(CompanyDAO cdao) {
		this.cdao = cdao;
	}

	public void setJdao(JobDAO jdao) {
		this.jdao = jdao;
	}

	public String insertCompany(JobCommand jcommand)
	{
		CompanyBO cbo=new CompanyBO();
		cbo.setCompNo(jcommand.getCompNo());
		cbo.setCompName(jcommand.getCompName());
		cbo.setServiceType(jcommand.getServiceType());
		cbo.setLocation(jcommand.getLocation());
		
		cdao.saveCompany(cbo);
	/*	if(a!=0)
		return "Company Data insert sucessFully";
		else
			return "Company Data not insert sucessFully";*/
		
		JobBO jbo=new JobBO();
		jbo.setJobNo(jcommand.getJobNo());
		jbo.setJobTitle(jcommand.getJobTitle());
		jbo.setDescription(jcommand.getDescription());
		jbo.setExperiance(jcommand.getExperiance());
		jbo.setQualification(jcommand.getQualification());
		jbo.setCopmNo(jcommand.getCompNo());
		jdao.saveJob(jbo);
	/*	if(B!=0)
		return "JOB DATA INSERT SUCESSFULLY";
		else
	  return "JOB DATA NOT INSERT SUCESSFULLY";*/
		return "DATA INSERT SUCESS FULLY";
			
		
	}

}

package com.dectx.service;

import org.springframework.stereotype.Service;

import com.dectx.bo.CompanyBO;
import com.dectx.bo.JobBO;
import com.dectx.command.JobCommand;
import com.dectx.dao.CompanyDAO;
import com.dectx.dao.JobDAO;

@Service
public class PostJobService {
	boolean flage1,flage2=false;
	private CompanyDAO cdao;
	private JobDAO jdao;

	public void setCdao(CompanyDAO cdao) {
		this.cdao = cdao;
	}

	public void setJdao(JobDAO jdao) {
		this.jdao = jdao;
	}

	public void insertCompany(JobCommand jcommand)
	{
		CompanyBO cbo=new CompanyBO();
		cbo.setCompNo(jcommand.getCompNo());
		cbo.setCompName(jcommand.getCompName());
		cbo.setServiceType(jcommand.getServiceType());
		cbo.setLocation(jcommand.getLocation());
		
		cdao.saveCompany(cbo);
		flage1=true;
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
		flage2=true;
		if(flage1==true)
		{
			if (flage2==true) {
				System.out.println("comdao and jobdao insert");
			}
			else {
				System.out.println("RollBack data");
			}
			System.out.println("only comdao insert");
		}
		
	/*	if(B!=0)
		return "JOB DATA INSERT SUCESSFULLY";
		else
	  return "JOB DATA NOT INSERT SUCESSFULLY";*/
		//return "DATA INSERT SUCESS FULLY";
			
		
	}

}

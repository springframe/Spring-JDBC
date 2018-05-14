package com.dectx.controller;

import com.dectx.command.JobCommand;
import com.dectx.service.PostJobService;

public class PostJonController {
	private PostJobService pjservice;

	public void setPjservice(PostJobService pjservice) {
		this.pjservice = pjservice;
	}
	
	public String insert(JobCommand jcmd)
	{
		return pjservice.insertCompany(jcmd);
		
	}

}

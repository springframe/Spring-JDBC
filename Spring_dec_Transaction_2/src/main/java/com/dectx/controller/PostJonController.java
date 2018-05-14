package com.dectx.controller;

import org.springframework.stereotype.Controller;

import com.dectx.command.JobCommand;
import com.dectx.service.PostJobService;

@Controller
public class PostJonController {
	private PostJobService pjservice;

	public void setPjservice(PostJobService pjservice) {
		this.pjservice = pjservice;
	}
	
	public void insert(JobCommand jcmd)
	{
		pjservice.insertCompany(jcmd);
		
		
	}

}

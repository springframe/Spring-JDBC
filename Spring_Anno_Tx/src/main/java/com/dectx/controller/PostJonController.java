package com.dectx.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.dectx.command.JobCommand;
import com.dectx.service.PostJobService;

public class PostJonController {
	@Autowired
	private PostJobService pjservice;

	public void insert(JobCommand jcmd)
	{
		pjservice.insertCompany(jcmd);
		
		
	}

}

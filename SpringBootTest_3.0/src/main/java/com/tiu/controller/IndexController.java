package com.tiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiu.service.impl.UserServiceImpl;

@Controller
public class IndexController {
	@Autowired
	private  UserServiceImpl userServiceImpl;
	
	@RequestMapping("/index")
	public String index(){
		String str = userServiceImpl.insertUser();
		return str;
	}

}

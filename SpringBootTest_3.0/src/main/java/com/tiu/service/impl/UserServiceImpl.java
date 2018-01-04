package com.tiu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tiu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String insertUser() {
		jdbcTemplate.update("insert into users values (null,?, ?, ?, ?, ?);",
				"T_Two","female",22,"2222.2","MarsMKII");
		
		return "SUCCESS";
	}


	
	
		
	

}

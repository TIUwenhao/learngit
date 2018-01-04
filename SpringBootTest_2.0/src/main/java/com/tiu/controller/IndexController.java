package com.tiu.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiu.entity.User;
import com.tiu.service.UserService;
//import com.tiu.mapper.UserMapper;
//import com.tiu.service.impl.UserServiceImpl;
//import com.tiu.test1.service.User1Service;
//import com.tiu.test2.service.User2Service;

@Controller
@EnableAutoConfiguration
public class IndexController {
	
	private static Logger log =  Logger.getLogger(IndexController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Value("${name}")
	private String name;
	
//	@Autowired
//	private User1Service user1Service;
	
//	@Autowired
//	private User2Service user2Service;
//	
	@RequestMapping("/hello")
	public String hello(){
		
		return "hello";
	}
	

	@RequestMapping("/getUserByName")
	@ResponseBody
	public User getUserByName(String name){
		
		return userService.findByName(name);
	}
	
	@RequestMapping("/getUserById")
	@ResponseBody
	public User getUserById(String id){
		return userService.selectById(id);
	}
	
	@RequestMapping("/DeleteById")
	public String DeleteById(String id){
		System.out.println("DELETE SUCCESS!");
		userService.deleteById(id);
		return "success";
	}
	
	@RequestMapping("/QueryAllUser")
	@ResponseBody
	public List<User> QueryAllUser(){
		return userService.queryAll();		
	}
	
	@RequestMapping("/InsertUser")
	@ResponseBody
	public String InsertUser(String name,String sex,int age,String birthdate,String address){
		
		userService.save(name, sex, age, birthdate, address);
		return "success";
	}
	
	@RequestMapping("/SaveUser")
	public String Save(String name,String sex,int age,String birthdate,String address){
		userService.insert(name, sex, age, birthdate, address);
		return "success";

	}
//	
//	@RequestMapping("/TestInsertUser")
//	public String TestInsertUser(){
//		user1Service.insertUser("test1", "male", 11, "3333.33", "china");
//		user1Service.insertUser("test2", "male", 11, "3333.33", "china");
//		return "success";       
//	}
	
	@RequestMapping("/LogTest")
	public String LogTest(){
		log.info("testt log");
		return "success";
	}
	
	@RequestMapping("/AopAspectLogTest")
	@ResponseBody
	public String AopAspectLogTest(){
		return "success";
	}
	
	@RequestMapping("/testException")
	public String testException(){
		int i = 1/0;
		
		return "Exception";
	}
	
	@RequestMapping("/testEhCache")
	@ResponseBody
	public User testEhCache(int id){
		return userService.findById(id);
	}
	
	
	@RequestMapping("/testClearCache")
	@ResponseBody
	public String testClearCache(){
		cacheManager.getCache("baseCache").clear();
		return "success";
	}

	@RequestMapping("/testAsync")
	@ResponseBody
	public String testAsync(){
		System.out.println("正在执行：1");		
		userService.TestAsync();
		System.out.println("正在执行：4");	
		return "success";
	}
	
	@RequestMapping("/testValue")
	@ResponseBody
	public String testValue(){		
		return name;
	}
	
}

package com.tiu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.EnableScheduling;

//@ComponentScan相当于springmvc的dispatcher.xml里面的默认扫描包
@ComponentScan(basePackages={"com.tiu.app","com.tiu.controller","com.tiu.service","com.tiu.test1.service","com.tiu.test2.service","com.tiu.dao"})
@MapperScan(basePackages="com.tiu.dao")	//扫描mapper
@EnableAutoConfiguration	//启动
@EnableCaching				//启动cache注解	
@EnableAsync
//@EnableScheduling			//开启定时任务注解
//@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class
//})
public class App {
	
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}



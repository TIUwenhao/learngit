package com.tiu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.tiu.controller","com.tiu.service"})
@EnableAutoConfiguration
public class App {
	
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}

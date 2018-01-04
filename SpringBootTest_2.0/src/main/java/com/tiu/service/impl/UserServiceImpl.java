package com.tiu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiu.dao.UserDao;
import com.tiu.entity.User;
import com.tiu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	

	@Override
	public User findByName(String name) {
		return userDao.findByName(name);	
	}

	@Override
	public int insert(String name, String sex, Integer age, String birthdate, String address) {
		// TODO Auto-generated method stub
		return userDao.insert(name, sex, age, birthdate, address);
	}

	@Override
	@Transactional			//声明式事务，
	public int save(String name, String sex, Integer age, String birthdate, String address) {
		int save = userDao.save(name, sex, age, birthdate, address);
		return save;
	}

	@Override
	public User selectById(String id) {
		return userDao.selectById(id);

	}

	@Override
	public int deleteById(String id) {
		System.out.println("DELETE SUCCESS!");
		userDao.deleteById(id);
		return 0;
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();		
	}


	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	@Async
	public void TestAsync(){
		
		System.out.println("正在执行: 2");
		for(int i = 0; i<5; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i="+i);
		}
		
		System.out.println("正在执行: 3");

	}

}

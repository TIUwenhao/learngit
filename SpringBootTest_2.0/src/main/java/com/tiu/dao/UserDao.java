package com.tiu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.tiu.entity.User;

@Mapper
@CacheConfig(cacheNames = "baseCache")
public interface UserDao {
	@Select("SELECT * FROM users WHERE userName = #{name}")
	User findByName(@Param("name") String name);
	
	@Select("SELECT * FROM users WHERE userID = #{id}")
	@Cacheable
	User findById(@Param("id") int id);
	
	@Insert("INSERT INTO users(userName, sex, age, birthdate, address) VALUES(#{name}, #{sex}, #{age}, #{birthdate}, #{address})")
	int insert(@Param("name") String name,@Param("sex") String sex, @Param("age") Integer age, @Param("birthdate") String birthdate,@Param("address") String address);
	
	int save(@Param("name") String name,@Param("sex") String sex, @Param("age") Integer age, @Param("birthdate") String birthdate,@Param("address") String address);
	
	User selectById(@Param("id") String id);
	
	int deleteById(@Param("id") String id);
	
	List<User> queryAll();
}

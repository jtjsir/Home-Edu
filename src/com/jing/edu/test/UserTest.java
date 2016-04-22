package com.jing.edu.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.jing.edu.common.BaseTest;
import com.jing.edu.common.util.PassUtil;
import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.model.User;

public class UserTest extends BaseTest{

	UserDao userDao ;
	
	@Before
	public void setUp(){
		userDao = context.getBean(UserDao.class) ;
	}
	
	@Test
	public void testQueryUserByName(){
//		String username = "admin" ;
//		//admin
//		String password = "M6uTNOzFptY=" ;
//		int type = 0 ;
//		User user = userDao.queryUser(username,password,type) ;
////		Assert.assertNotNull(user);
//		System.out.println(user.toString());
	}
	
	@Test
	public void updateUser(){
		String name="JingSir" ;
		String password = "jing" ;
		userDao.updatePass(name, password);
	}
	
	@Test
	public void testInsert(){
		User user = new User() ;
//		user.setAge(30);
//		user.setEmail("11@qq.com");
//		user.setLevel("大学");
//		user.setUsername("隔壁老王");
//		user.setPassword(PassUtil.encodePass("laowang"));
//		user.setPhone("15958042355");
//		user.setSex("男");
//		user.setType(1);
		user.setAge(15);
		user.setEmail("12@qq.com");
		user.setLevel("高中");
		user.setUsername("小李");
		user.setPassword(PassUtil.encodePass("xiaoli"));
		user.setPhone("15958042399");
		user.setSex("男");
		user.setType(2);
		userDao.insertUser(user) ;
	}
	
	@Test
	public void testQueryUserByType(){
		int type = 1 ;
		List<User> users = userDao.queryUsersByType(type) ;
		System.out.println("Tea user's size: " +users.size());
	}
	
}

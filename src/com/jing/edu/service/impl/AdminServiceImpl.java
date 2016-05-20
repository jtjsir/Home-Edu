package com.jing.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.common.util.EmailUtil;
import com.jing.edu.mapper.joggle.RegisterUserDao;
import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.model.RegisterUser;
import com.jing.edu.model.User;
import com.jing.edu.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	private static final Logger adminServiceLogger = LogManager.getLogger(AdminServiceImpl.class.getSimpleName()) ;
	
	@Resource
	public RegisterUserDao registerUserDao;
	
	@Resource
	public UserDao userDao ;

	@Override
	public List<RegisterUser> queryUsers(String type) {
		return registerUserDao.queryUsersByType(Integer.valueOf(type)) ;
	}

	@Override
	public RegisterUser queryOneUser(String name,String type) {
		return registerUserDao.queryOneUser(name,Integer.valueOf(type));
	}

	@Override
	public void addUserAndInform(String username,String basePath) {
		RegisterUser user = registerUserDao.queryUserByName(username) ;
		User insertUser = new User() ;
		insertUser.setAge(user.getAge());
		insertUser.setEmail(user.getEmail());
		insertUser.setLevel(user.getLevel());
		insertUser.setPassword(user.getPassword());
		insertUser.setPhone(user.getPhone());
		insertUser.setSex(user.getSex());
		insertUser.setType(user.getType());
		insertUser.setUsername(user.getUsername());
		
		userDao.insertUser(insertUser) ;
		registerUserDao.deleteUser(user.getId());
		adminServiceLogger.info("系统通过了名为:  " + username + " 的用户的请求");
		
		String content = "恭喜，您的注册审核通过，可以进行登录浏览更多的信息了。" 
				+"  <a href='" +basePath +  "'>点击此处</a>";
		EmailUtil.sendEmail(user.getEmail(), "在线家教注册信息反馈", content);
	}

	@Override
	public void ignoreUserAndInform(String username,String basePath) {
		RegisterUser deleteUser = registerUserDao.queryUserByName(username) ;
		
		registerUserDao.deleteUser(deleteUser.getId());
		
		adminServiceLogger.info("过滤了一个用户名为: " + deleteUser.getUsername() + " 的请求");
		
		String content = "对不起，您的注册审核没有通过！" 
				+"  <a href='" +basePath +  "'>点击此处</a>";
		EmailUtil.sendEmail(deleteUser.getEmail(), "在线家教注册信息反馈",content);
	}

}

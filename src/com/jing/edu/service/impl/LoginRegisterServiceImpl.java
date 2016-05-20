package com.jing.edu.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.common.util.PassUtil;
import com.jing.edu.mapper.joggle.RegisterUserDao;
import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.model.RegisterUser;
import com.jing.edu.model.User;
import com.jing.edu.service.LoginRegisterService;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService,BaseLogger{
	private static final Logger Logger = LogManager.getLogger(LoginRegisterServiceImpl.class) ;

	@Resource
	public UserDao userDao ;
	
	@Resource
	public RegisterUserDao registerDao ;
	
	@Override
	public boolean isUser(String username,String password,int type) {
		boolean flag = false ;
//		if(userDao.queryUser(username,password,type)!=null){
//			flag = true ;
//		}
		User user = userDao.queryUserByName(username) ;
		if(user!=null){
			String dbPass = PassUtil.decodePass(user.getPassword()) ;
			if(dbPass.equals(password)&&type==user.getType()){
				flag = true ;
			}
		}
		
		return flag ;
	}

	@Override
	public String register(User user) {
		String resultInfo = null ;
		//加密
		String pass = user.getPassword() ;
		user.setPassword(PassUtil.encodePass(pass)) ;
		
		int i = userDao.insertUser(user) ;
		if(i==1){
			resultInfo = " 成为家教成员成功!为您跳转到登录页面 " ;
			this.getLogger().debug(" 插入用户注册数据成功! ");
		}else{
			resultInfo = " 您注册的信息后台系统遇到bug,请稍后再来! " ;
			this.getLogger().debug(" 插入用户注册数据失败! ");
		}
		
		return resultInfo ;
	}

	@Override
	public Logger getLogger() {
		return Logger;
	}

	@Override
	public boolean isHavingUser(String username) {
		boolean flag = false ;
		User user = userDao.queryUserByName(username) ;
		if(user!=null){
			flag = true ;
		}
		return flag ;
	}

	@Override
	public User queryUser(String username) {
		User user = null ;
		user = userDao.queryUserByName(username) ;
		return user;
	}

	@Override
	public String insertRegisterTable(User user) {
		RegisterUser registerUser = new RegisterUser() ;
		registerUser.setAge(user.getAge());
		registerUser.setEmail(user.getEmail());
		registerUser.setLevel(user.getLevel());
		registerUser.setPassword(PassUtil.encodePass(user.getPassword()));
		registerUser.setPhone(user.getPhone());
		registerUser.setSex(user.getSex());
		registerUser.setType(user.getType());
		registerUser.setUsername(user.getUsername());
		
		registerDao.insertUser(registerUser) ;
		
		String resultInfo = " 注册信息请求已经发送给管理员，请耐心等待审核!现在为您跳转到登录页面 " ;
		this.getLogger().debug(" 向register_user表插入用户注册数据成功! ");
		
		return resultInfo ;
	}

}

package com.jing.edu.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.common.util.PassUtil;
import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.model.User;
import com.jing.edu.service.LoginRegisterService;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService,BaseLogger{
	private static final Logger Logger = LogManager.getLogger(LoginRegisterServiceImpl.class) ;

	@Resource
	public UserDao userDao ;
	
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

}

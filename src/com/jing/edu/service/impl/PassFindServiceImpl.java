package com.jing.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jing.edu.mapper.joggle.UserDao;
import com.jing.edu.model.User;
import com.jing.edu.service.PassFindService;

@Service
public class PassFindServiceImpl implements PassFindService {

	@Resource
	public UserDao userDao ;
	
	@Override
	public boolean isEmailExist(String email) {
		User user = userDao.queryUserByEmail(email) ;
		if(user!=null){
			return true ;
		}
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.queryUserByEmail(email) ;
	}

}

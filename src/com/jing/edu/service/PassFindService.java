package com.jing.edu.service;

import com.jing.edu.model.User;

public interface PassFindService {

	boolean isEmailExist(String email,String username) ;
	
	User getUserByEmail(String email,String username) ;
	
	void updatePassword(String username,String password) ;
}

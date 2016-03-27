package com.jing.edu.service;

import com.jing.edu.model.User;

public interface PassFindService {

	boolean isEmailExist(String email) ;
	
	User getUserByEmail(String email) ;
}

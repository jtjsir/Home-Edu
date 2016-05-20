package com.jing.edu.service;

import java.util.List;

import com.jing.edu.model.RegisterUser;

public interface AdminService {

	List<RegisterUser> queryUsers(String type) ;
	
	RegisterUser queryOneUser(String name,String type) ;
	
	void addUserAndInform(String username,String basePath) ;
	
	void ignoreUserAndInform(String username,String basePath) ;
}

package com.jing.edu.service;

import com.jing.edu.model.User;

public interface LoginRegisterService {

	public boolean isUser(String username,String password,int type);
	
	public String register(User user);
	
	public boolean isHavingUser(String username);
	
	public User queryUser(String username);
	
	public String  insertRegisterTable(User user) ;
}

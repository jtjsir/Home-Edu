package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.User;

public interface UserDao {

	User queryUser(String username,String password,int type) ;
	
	User queryUserByName(String username);
	
	User queryUserByEmail(String email,String username) ;
	
	User queryOneUser(String name,int type) ;
	
	List<User> queryUsersByType(int type);
	//返回插入的记录成功数目 	0/1
	int insertUser(User user);
	
	void deleteUser(int id);
	
	void updatePass(String username,String password);
}

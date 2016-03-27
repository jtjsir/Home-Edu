package com.jing.edu.mapper.joggle;

import com.jing.edu.model.User;

public interface UserDao {

	User queryUser(String username,String password,int type) ;
	
	User queryUserByName(String username);
	
	User queryUserByEmail(String email) ;
	
	//返回插入的记录成功数目 	0/1
	int insertUser(User user);
	
	void deleteUser(int id);
	
	void updatePass(String username,String password);
}

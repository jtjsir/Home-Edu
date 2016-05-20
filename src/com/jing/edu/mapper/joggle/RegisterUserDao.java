package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.RegisterUser;

public interface RegisterUserDao {

	RegisterUser queryUserByName(String username);

	RegisterUser queryOneUser(String name, int type);

	List<RegisterUser> queryUsersByType(int type);

	// 返回插入的记录成功数目 0/1
	int insertUser(RegisterUser user);

	void deleteUser(int id);
}

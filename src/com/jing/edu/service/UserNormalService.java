package com.jing.edu.service;

import com.jing.edu.model.User;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;

/**
 * @author jing
 *
 */
public interface UserNormalService {

	UserDetailStu getStuDetail(String name) ;
	
	UserDetailTea getTeaDetail(String name) ;
	
	User getUser(String name) ;
	
	void updateIsonline(String username,String type,int onlineValue);
}

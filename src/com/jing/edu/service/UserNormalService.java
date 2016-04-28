package com.jing.edu.service;

import com.jing.edu.model.User;
import com.jing.edu.model.UserDetail;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.model.UserNotice;

/**
 * @author jing
 *
 */
public interface UserNormalService {

	UserDetailStu getStuDetail(String name) ;
	
	UserDetailTea getTeaDetail(String name) ;
	
	User getUser(String name) ;
	
	void updateIsonline(String username,String type,int onlineValue);
	
	void addDetail(UserDetail userDetail) ;
	
	void updateNotices(UserNotice userNotice) ;
	
	int readNoticeNums(String username);
	
	boolean isNoticedByFromName(String username,String fromname) ;
}

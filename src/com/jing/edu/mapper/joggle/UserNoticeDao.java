package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.UserNotice;

public interface UserNoticeDao {

	public int readNoticeNums(String username) ;
	
	public void insertNotice(UserNotice notice);
	
	public void updateNotice(UserNotice userNotice);
	
	public List<UserNotice> readNoticeByType(int type);
	
	public UserNotice readNoticeByName(String username,String fromname);
}

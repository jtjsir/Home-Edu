package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.UserNotice;

public interface UserNoticeDao {

	public int readNoticeNums(String username) ;
	
	public void insertNoticeNums(String username,int noticeNums);
	
	public void updateNoticeNums(String username,int noticeNums);
	
	public List<UserNotice> readNoticeByType(int type);
}

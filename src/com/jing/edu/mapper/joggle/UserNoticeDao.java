package com.jing.edu.mapper.joggle;


public interface UserNoticeDao {

	public int readNoticeNums(String username) ;
	
	public void insertNoticeNums(String username,int noticeNums);
	
	public void updateNoticeNums(String username,int noticeNums);
}

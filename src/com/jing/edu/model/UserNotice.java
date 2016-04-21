package com.jing.edu.model;

/**
 * 用户关注表Entity类
 * @author jing
 *
 */
public class UserNotice {
	private int id ;
	private String username ;
	private int notice ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}
	
	
}

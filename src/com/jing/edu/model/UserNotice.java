package com.jing.edu.model;

/**
 * 用户关注表Entity类
 * 
 * @author jing
 *
 */
public class UserNotice {
	private int id;
	private String username;
	private int type;
	private int notice;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

}

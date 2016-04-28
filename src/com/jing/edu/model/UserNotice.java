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
	private String fromname;
	private int type;
	private int isnotice;
	private int noticeNums ;

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

	public int getIsnotice() {
		return isnotice;
	}

	public void setIsnotice(int isnotice) {
		this.isnotice = isnotice;
	}

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}

	public int getNoticeNums() {
		return noticeNums;
	}

	public void setNoticeNums(int noticeNums) {
		this.noticeNums = noticeNums;
	}
	
}

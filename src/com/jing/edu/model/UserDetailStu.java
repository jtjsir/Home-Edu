package com.jing.edu.model;

public class UserDetailStu extends UserDetail {

	private String address;
	private String price;

	public UserDetailStu(){
		
	}
	
	public UserDetailStu(String name, String realname, int type, String level, String introduction, byte[] image,
			String subject, int isonline, String city, String address, String price) {
		super(name, realname, type, level, introduction, image, subject, isonline, city);
		this.address = address;
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

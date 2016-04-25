package com.jing.edu.model;

public class UserDetailTea extends UserDetail {

	private String school;
	private String honor;
	private String price;

	public UserDetailTea(){
		
	}
	
	public UserDetailTea(String name, String realname, int type, String level, String introduction, byte[] image,
			String subject, int isonline, String city, String school, String honor, String price) {
		super(name, realname, type, level, introduction, image, subject, isonline, city);
		this.school = school;
		this.honor = honor;
		this.price = price;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getHonor() {
		return honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}

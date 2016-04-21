package com.jing.edu.model;

public class EduType {
	
	public enum UserType{
		STUDENT("stu"),TEACHER("tea") ;
		
		private String name ;
		private UserType(String name){
			this.name = name ;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	//学历类别
	public enum LevelType{
		PRIMARY,MEDIUM,SENIOR,COLLEGE
	}
}

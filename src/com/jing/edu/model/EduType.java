package com.jing.edu.model;

public class EduType {

	public enum UserType {
		STUDENT("stu",2), TEACHER("tea",1);

		private String name;
		
		private int typeNum ;

		private UserType(String name,int typeNum) {
			this.name = name;
			this.typeNum = typeNum ;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getTypeNum() {
			return typeNum;
		}

		public void setTypeNum(int typeNum) {
			this.typeNum = typeNum;
		}
		
	}

	// 学历类别
	public enum LevelType {
		PRIMARY("小学"), MEDIUM("初中"), SENIOR("高中"), COLLEGE("大学");
		
		private String keyname;

		private LevelType(String keyname) {
			this.keyname = keyname;
		}

		public String getKeyname() {
			return keyname;
		}

		public void setKeyname(String keyname) {
			this.keyname = keyname;
		}
	}

	// sort请求类型
	public enum SortType {
		SORT_PRICE("sort_price"), SORT_AGE("sort_age"), SORT_NOTICE("sort_notice");

		private String keyname;

		private SortType(String keyname) {
			this.keyname = keyname;
		}

		public String getKeyname() {
			return keyname;
		}

		public void setKeyname(String keyname) {
			this.keyname = keyname;
		}
	}
}

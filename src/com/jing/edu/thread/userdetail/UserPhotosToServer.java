package com.jing.edu.thread.userdetail;

import com.jing.edu.util.ImageUtil;

public class UserPhotosToServer implements Runnable {
	private String rootPath;
	private String userType;
	private String realName ;
	private String subjects ;
	private String level ;
	private byte[] images ;
	
	public UserPhotosToServer(String rootPath,String userType,String realName,String subjects,String level,byte[] images) {
		this.rootPath = rootPath ;
		this.userType = userType ;
		this.realName = realName ;
		this.subjects = subjects ;
		this.level = level ;
		this.images = images ;
	}
	@Override
	public void run() {
		String path = rootPath + "/" + userType ;
		if("tea".equals(userType)){
			 if(subjects.contains("小学")){
				 String tempPath = path ;
				 tempPath+= "/" + "smallsch" + "/" +realName + "_" +level + "_" + subjects +".jpg";
				 ImageUtil.write(tempPath, images, 200, "jpeg");
			 }
			 if(subjects.contains("初中")){
				 String tempPath = path ;
				 tempPath+= "/" + "mediumsch" + "/" +realName + "_" +level + "_" + subjects +".jpg";
				 ImageUtil.write(tempPath, images, 200, "jpeg");
			 }
			 if(subjects.contains("高中")){
				 String tempPath = path ;
				 tempPath+= "/" + "seniorsch" + "/" +realName + "_" +level + "_" + subjects +".jpg";
				 ImageUtil.write(tempPath, images, 200, "jpeg");
			 }
		}else if("stu".equals(userType)){
			if(subjects.contains("小学")){
				 String tempPath = path ;
				 tempPath+= "/" + "smallsch" + "/" +realName + "_" +level + "_" + subjects +".jpg";
				 ImageUtil.write(tempPath, images, 200, "jpeg");
			 }
			 if(subjects.contains("初中")){
				 String tempPath = path ;
				 tempPath+= "/" + "mediumsch" + "/" +realName + "_" +level + "_" + subjects +".jpg";
				 ImageUtil.write(tempPath, images, 200, "jpeg");
			 }
			 if(subjects.contains("高中")){
				 String tempPath = path ;
				 tempPath+= "/" + "seniorsch" + "/" +realName + "_" +level + "_" + subjects +".jpg";
				 ImageUtil.write(tempPath, images, 200, "jpeg");
			 }
		}
	}

}

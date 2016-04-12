package com.jing.edu.service;

import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.UserDetail;

public interface UserDetailService {
	
	public boolean validatePhoto(long imageSize) ;
	
	public void insertDetailInfo(UserDetail userDetail) ;
	
	public void addPhotoToServer(String rootPath,String userType,String realname,String subjects,String level,byte[] images);
	
	public boolean isUserDetail(String username,UserType userType);
}

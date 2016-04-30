package com.jing.edu.mapper.joggle;

import java.util.List;
import java.util.Map;

import com.jing.edu.model.UserDetail;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;

public interface UserDetailDao {
	
	void insertDetail(UserDetail userDetail);
	
	List<UserDetailStu> queryStuInfos(String city,String gradeSubject,int offset,int limit) ;
	
	List<UserDetailStu> queryAllStuInfos(String gradeSubject,int offset,int limit) ;
	
	int queryCountStuInfos(String city,String gradeSubject) ;
	
	int queryCountAllStuInfos(String gradeSubject) ;
	
	List<UserDetailTea> queryTeaInfos(String city,String gradeSubject,int offset,int limit) ;
	
	List<UserDetailTea> queryAllTeaInfos(String gradeSubject,int offset,int limit) ;
	
	int queryCountTeaInfos(String city,String gradeSubject) ;
	
	int queryCountAllTeaInfos(String gradeSubject) ;
	
	UserDetailStu queryStuInfo(String username);
	
	UserDetailTea queryTeaInfo(String username);
	
	void setIsonline(Map<String, Object> onlineMap);
	
	void updateDetail(UserDetail userDetail) ;
}

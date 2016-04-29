package com.jing.edu.service;

import java.util.Map;

public interface UserRecordService {
	
	void addSubscribtion(Map<String, String> paramMap) ;
	
	String queryRecordsByStudent(String stuname);
	
	String queryRecordsByTeacher(String teaname);
	
	String queryRecordsBySubject(String username,String subject,String searchType) ;
	
	void setRecordIsIngnored(String detailPath,String stuname,String teachername,String guideby,String isdelete);
}

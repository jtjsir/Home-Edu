package com.jing.edu.service;

import java.util.Map;

public interface UserRecordService {
	
	void addSubscribtion(Map<String, String> paramMap) ;
	
	String queryRecordsByStudent(String stuid);
	
	String queryRecordsByTeacher(String teaid);
	
	String queryRecordsBySubject(String username,String subject,String searchType) ;
	
	void setRecordIngnored(String stuid,String teacherid,String guideby);
}

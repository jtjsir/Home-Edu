package com.jing.edu.service;

public interface UserRecordService {
	
	String queryRecordsByStudent(String stuid);
	
	String queryRecordsByTeacher(String teaid);
	
	String queryRecordsBySubject(String username,String subject,String searchType) ;
	
	void setRecordIngnored(String stuid,String teacherid,String guideby);
}

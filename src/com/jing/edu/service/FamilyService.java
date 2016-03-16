package com.jing.edu.service;

import java.io.InputStream;

public interface FamilyService {
	
	public String queryStuFamily(String city,String gradeSubject,String basePath,String page) ; 
	
	public String queryTeaFamily(String city,String gradeSubject,String basePath,String page) ;
	
	public InputStream getPhoto(String imgid,String userType) ;
	
	public String queryAllStuFamily(String gradeSubject,String basePath,String page) ;
	
	public String queryAllTeaFamily(String gradeSubject,String basePath,String page) ;
}

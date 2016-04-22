package com.jing.edu.service;

import java.io.InputStream;
import com.jing.edu.model.EduType.SortType;
public interface FamilyService {
	
	public String queryStuFamily(String city,String gradeSubject,String userType,String basePath,String page) ; 
	
	public String queryTeaFamily(String city,String gradeSubject,String userType,String basePath,String page) ;
	
	public InputStream getPhoto(String imgid,String userType) ;
	
	public String queryPageStuFamily(String gradeSubject,String userType,String basePath,String page) ;
	
	public String queryPageTeaFamily(String gradeSubject,String userType,String basePath,String page) ;
	
	public String querySortFamily(String city,String gradeSubject,String userType,String basePath,String page,String grade,String order,SortType sortType);
}

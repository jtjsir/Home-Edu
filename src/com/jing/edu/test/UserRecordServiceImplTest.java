package com.jing.edu.test;

import org.junit.Before;
import org.junit.Test;

import com.jing.edu.common.BaseTest;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.service.impl.UserRecordServiceImpl;

public class UserRecordServiceImplTest extends BaseTest{
	UserRecordServiceImpl userRecordService ;
	
	@Before
	public void setUp(){
		userRecordService = context.getBean(UserRecordServiceImpl.class) ;
	}
	
	@Test
	public void testJsonArray(){
		String jsonStr = userRecordService.queryRecordsByTeacher("4") ;
		System.out.println(jsonStr);
	}
	
	@Test
	public void testQuerySubs(){
		String jsonStr = userRecordService.queryRecordsBySubject("jingtianjun", "小学数学,初中数学,高中数学", UserType.TEACHER.getName()) ;
		System.err.println(jsonStr);
	}
}

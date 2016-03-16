package com.jing.edu.test;

import org.junit.Before;
import org.junit.Test;

import com.jing.edu.common.BaseTest;
import com.jing.edu.mapper.joggle.CourseDao;
import com.jing.edu.model.Course;

public class CourseTest extends BaseTest{

	CourseDao courseDao ;
	
	@Before
	public void setUp(){
		courseDao = context.getBean(CourseDao.class) ;
	}
	
	@Test
	public void insertCourse(){
		int teacherId = 1 ;
		String name="高数" ;
		String type = "数学" ;
		String grade = "高一" ;
		String price = "50/时" ;
		
		Course course = new Course() ;
		course.setGrade(grade);
		course.setName(name);
		course.setPrice(price);
		course.setTeacherId(teacherId);
		course.setTeacherName("景");
		courseDao.insertCourse(course) ;
	}
}

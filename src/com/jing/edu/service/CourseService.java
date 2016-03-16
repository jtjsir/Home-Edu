package com.jing.edu.service;

import java.util.List;

import com.jing.edu.model.Course;

public interface CourseService {
	List<Course> queryCourseByTeacher(int teacherId) ;
	
	List<Course> queryCourseByName(String courseType);
	
	void insertCourse(Course course);
}

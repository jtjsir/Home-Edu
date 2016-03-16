package com.jing.edu.mapper.joggle;

import java.util.List;

import com.jing.edu.model.Course;

public interface CourseDao {
	void deleteCourseById(int teacherId) ;
	
	int insertCourse(Course course);
	
	List<Course> queryCourseByTeacher(int teacherId) ;
	
	List<Course> queryCourseByName(String courseType);
}

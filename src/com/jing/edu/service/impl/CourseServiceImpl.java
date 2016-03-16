package com.jing.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.mapper.joggle.CourseDao;
import com.jing.edu.model.Course;
import com.jing.edu.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService,BaseLogger {

	private static final Logger Logger = LogManager.getLogger(CourseServiceImpl.class) ;
	
	@Resource
	CourseDao courserDao ;
	
	@Override
	public List<Course> queryCourseByTeacher(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> queryCourseByName(String courseType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCourse(Course course) {
		courserDao.insertCourse(course) ;
		this.getLogger().debug("课程教师为: " + course.getTeacherName() +" 其中插入数据库的Course信息为: " + course.toString());
	}

	@Override
	public Logger getLogger() {
		// TODO Auto-generated method stub
		return this.Logger;
	}

}

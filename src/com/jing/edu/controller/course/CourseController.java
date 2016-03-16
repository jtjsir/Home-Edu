package com.jing.edu.controller.course;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.model.Course;
import com.jing.edu.service.CourseService;

@Controller
@RequestMapping(value = "/page/course" )
public class CourseController implements BaseLogger{
	
	private static final Logger controllerLogger = LogManager.getLogger(CourseController.class) ;
	
	@Resource
	public CourseService courseService ;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void addCourse(HttpServletRequest request , HttpServletResponse response){
		
		int teaherId = Integer.valueOf(request.getParameter("teacherId")) ;
		String teacherName = request.getParameter("teacherName") ;
		String courseName = request.getParameter("courseName") ;
		String courseType = request.getParameter("courseType") ;
		String courseGrade = request.getParameter("courseGrade") ;
		String coursePrice = request.getParameter("coursePrice") ;
		
		Course course = new Course() ;
		course.setTeacherId(teaherId);
		course.setTeacherName(teacherName);
		course.setGrade(courseGrade);
		course.setName(courseName);
		course.setPrice(coursePrice);
		try {
			courseService.insertCourse(course);
			controllerLogger.info("添加课程成功,添加的信息为: " + course);
		} catch (Exception e) {
			controllerLogger.debug("添加课程失败,未添加的信息为: " + course);
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String redirectToAdd(){
		
		return "/course/add" ;
	}
	
	
	@Override
	public Logger getLogger() {
		return controllerLogger;
	}
}

package com.jing.edu.controller.user;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.service.UserRecordService;

/**
 * 学生老师信息订阅处理类
 * @author jing
 *
 */
@Controller
@RequestMapping(value = "/user/detail/record")
public class UserRecordController {
	
	@Resource
	UserRecordService userRecordService ;
	
	@RequestMapping(value = "/inform/getmessage")
	public void query(HttpServletRequest request,HttpServletResponse response){
		//获取参数userid
		String id = request.getParameter("userid") ;
		String usertype = request.getParameter("usertype") ;
		String putInfo = null ;
		if("tea".equals(usertype)){
			putInfo = userRecordService.queryRecordsByTeacher(id) ;
		}else if("stu".equals(usertype)){
			putInfo = userRecordService.queryRecordsByStudent(id) ;
		}
		response.setContentType("text/html;charset=utf-8" ) ;
		//将json数据返回给前台
		PrintWriter writer = null ;
		try {
			writer = response.getWriter() ;
			writer.write(putInfo);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(writer!=null){
				writer.close();
			}
		}
	}
	
	@RequestMapping(value = "/inform/setignore")
	public void set(HttpServletRequest request){
		String stuid = request.getParameter("stuid") ;
		String teacherid = request.getParameter("teacherid") ;
		String guideby = request.getParameter("guideby") ;
		//设置
		userRecordService.setRecordIngnored(stuid, teacherid, guideby);
	}
	
	
	@RequestMapping(value = "/recommend/getmessage")
	public void queryRecommend(HttpServletRequest request,HttpServletResponse response){
		String userType = request.getParameter("userType") ;
		String putInfo = null ;
		if(UserType.TEACHER.getName().equals(userType)){
			UserDetailTea tea = (UserDetailTea)request.getSession().getAttribute("userDetail") ;
			if(tea==null){
				putInfo = null ;
			}else{
				putInfo = userRecordService.queryRecordsBySubject(tea.getName(), tea.getSubject(),userType) ;
			}
		}else if(UserType.STUDENT.getName().equals(userType)){
			UserDetailStu stu = (UserDetailStu)request.getSession().getAttribute("userDetail") ;
			if(stu==null){
				putInfo = null ;
			}else{
				putInfo = userRecordService.queryRecordsBySubject(stu.getName(), stu.getSubject(),userType) ;
			}
		}
		
		response.setContentType("text/html;charset=utf-8" ) ;
		//将json数据返回给前台
		PrintWriter writer = null ;
		try {
			writer = response.getWriter() ;
			writer.write(putInfo);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(writer!=null){
				writer.close();
			}
		}
	}
}

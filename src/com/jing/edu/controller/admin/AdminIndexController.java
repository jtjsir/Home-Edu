package com.jing.edu.controller.admin;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.jing.edu.model.RegisterUser;
import com.jing.edu.service.AdminService;

/**
 * admin主页面
 * @author jtj
 *
 */
@Controller
@RequestMapping(value = "/admin/user/index")
public class AdminIndexController {
	
	@Resource
	public AdminService adminService ;

	@RequestMapping(value="/query/all")
	public void queryAll(HttpServletRequest request,HttpServletResponse response){
		String type = request.getParameter("userType") ;
		List<RegisterUser> users = adminService.queryUsers(type) ;
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = null ;
		try {
			writer = response.getWriter() ;
			if(null==users){
				writer.write("null");
			}else{
				writer.write(new Gson().toJson(users));
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/query/some")
	public void querySome(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name") ;
		String type = request.getParameter("userType") ;
		RegisterUser user = adminService.queryOneUser(name,type) ;
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = null ;
		try {
			writer = response.getWriter() ;
			if(null==user){
				writer.write("null");
			}else{
				List<RegisterUser> users = new ArrayList<>() ;
				users.add(user) ;
				writer.write(new Gson().toJson(users));
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/accept")
	public void accept(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name") ;
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		//通过请求并Email通知
		adminService.addUserAndInform(name,basePath);
	}
	
	@RequestMapping(value = "/ignore")
	public void ignore(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name") ;
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
		//删除请求并Email通知
		adminService.ignoreUserAndInform(name,basePath);
	}
}

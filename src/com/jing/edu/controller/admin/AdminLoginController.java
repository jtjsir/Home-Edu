package com.jing.edu.controller.admin;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jing.edu.service.LoginRegisterService;

/**
 * 管理员登录页面
 * @author jtj
 *
 */
@RequestMapping(value="/admin")
@Controller
public class AdminLoginController {
	
	@Resource
	public LoginRegisterService loginService ;

	@RequestMapping(value = "/login/on",method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name") ;
		String password = request.getParameter("password") ;
		String redirectName = "" ;
		
		boolean isAdmin = loginService.isUser(name, password, 0) ;
		if(isAdmin){
			//跳转到主页面
			request.getSession().setAttribute("admin", loginService.queryUser(name));
			redirectName = "redirect:/admin/index" ;
		}else{
			//跳转到登录页面
			redirectName  =  "redirect:/admin/login" ;
		}
		
		return redirectName ;
	}
	
	@RequestMapping(value = "/login/out")
	public String loginOut(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("admin");
		return "redirect:/admin/login" ;
	}
	
	
	@RequestMapping(value="/login")
	public void redirectToLogin(HttpServletRequest request,HttpServletResponse response){
		try {
			// 跳转到index.jsp页面
			request.getRequestDispatcher("/admin_login.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/index")
	public void redirectToIndex(HttpServletRequest request,HttpServletResponse response){
		try {
			// 跳转到index.jsp页面
			request.getRequestDispatcher("/admin_index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

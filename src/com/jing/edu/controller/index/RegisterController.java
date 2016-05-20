package com.jing.edu.controller.index;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jing.edu.model.User;
import com.jing.edu.service.LoginRegisterService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Resource
	LoginRegisterService service;

	/**
	 * 注册
	 * 
	 * @param request
	 * @return 返回前台成功注册与否信息
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model) {
		User user = new User();

		// 获取前台数据
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setAge(Integer.valueOf(request.getParameter("age")));
		user.setEmail(request.getParameter("email"));
		user.setLevel(request.getParameter("level"));
		user.setPhone(request.getParameter("phone"));
		user.setSex(request.getParameter("sex"));
		user.setType(Integer.valueOf(request.getParameter("type")));
		
		// 插入数据库 并返回信息给前台
		String resultInfo = service.register(user);
		
//		采用admin策略的代码
//		String resultInfo = service.insertRegisterTable(user) ;
		model.addAttribute("registerInfo", resultInfo);

		return "redirect:/index/passToLogin";
	}
	
	/**
	 * 提供Register页面的ajax请求
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/findName")
	public void validateUsername(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username") ;
		
		String resultInfo = "" ;
		boolean isHavingUser = service.isHavingUser(username) ;
		if(isHavingUser){
			//表明数据库中含有username
			resultInfo = "Sorry,your username is used by other.Please change" ;
		}else{
			resultInfo = "OK,the username is not used yet" ;
		}
		
		try {
			response.getWriter().write(resultInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

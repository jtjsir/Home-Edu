package com.jing.edu.controller.index;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jing.edu.model.User;
import com.jing.edu.service.LoginRegisterService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Resource
	LoginRegisterService loginService ;
	
	@RequestMapping(value = "/on", method = RequestMethod.POST)
	public String loginValidate(String username, String password, String userType, HttpServletRequest request,
			HttpServletResponse response,Model model) {
		String redirectName = "" ;
		
		int type = Integer.valueOf(userType) ;
		if (!loginService.isUser(username, password,type)) {
				//转到login页面
				redirectName = "redirect:/index/login" ;
				model.addAttribute("isError", "true") ;
		} else {
			//转到index页面 	保存user信息到session
			HttpSession session = request.getSession(true) ;
			User user = loginService.queryUser(username) ;
			
			session.setAttribute("user", user);
			redirectName =  "redirect:/index";
		}
		
		return redirectName ;
	}

	@RequestMapping(value = "/out")
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession() ;
		session.removeAttribute("user");
		session.removeAttribute("userDetail");
		session.removeAttribute("city");
		session.removeAttribute("grade");
		session.removeAttribute("subject");
		
		return "redirect:/index/passToIndex" ;
	}
}

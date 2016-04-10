package com.jing.edu.controller.index;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.User;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.service.LoginRegisterService;
import com.jing.edu.service.UserNormalService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Resource
	LoginRegisterService loginService ;
	
	@Resource
	UserNormalService normalService ;
	
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
			//更新在线状态
			if(type==1){
				UserDetailTea tea = normalService.getTeaDetail(username) ;
				if(null!=tea){
					normalService.updateIsonline(username, UserType.TEACHER.getName(), 1);
				}
			}else if(type==2){
				UserDetailStu stu = normalService.getStuDetail(username) ;
				if(null!=stu){
					normalService.updateIsonline(redirectName, UserType.STUDENT.getName(), 1);
				}
			}
			session.setAttribute("user", user);
			redirectName =  "redirect:/index";
		}
		
		return redirectName ;
	}

	@RequestMapping(value = "/out")
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession() ;
		//更新状态
		User user = (User)session.getAttribute("user") ;
		if(null!=user){
			int type = user.getType() ;
			if(1==type){
				UserDetailTea tea = (UserDetailTea)session.getAttribute("userDetail") ;
				if(null!=tea){
					normalService.updateIsonline(user.getUsername(), UserType.TEACHER.getName(), 0);
				}
			}else if(2==type){
				UserDetailStu stu =(UserDetailStu)session.getAttribute("userDetail") ;
				if(null!=stu){
					normalService.updateIsonline(user.getUsername(), UserType.STUDENT.getName(), 0);
				}
			}
		}
		//清除session记录
		session.removeAttribute("user");
		session.removeAttribute("userDetail");
		session.removeAttribute("city");
		session.removeAttribute("grade");
		session.removeAttribute("subject");
		
		return "redirect:/index/passToIndex" ;
	}
}

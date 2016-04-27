package com.jing.edu.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.edu.model.User;
import com.jing.edu.service.UserNormalService;
/**
 * 用户详细信息展示页面
 * @author jing
 *
 */
@Controller
@RequestMapping(value = "/user/normal")
public class UserNormalIndexController {

	@Resource
	UserNormalService userNormalService ;
	
	@RequestMapping(value = "/tea/index")
	public String redirectToTeaIndex(HttpServletRequest request){
		String name = request.getParameter("name") ;
		if(userNormalService.getTeaDetail(name)!=null){
			request.setAttribute("detailUser",userNormalService.getTeaDetail(name) );
		}
		if(userNormalService.getUser(name)!=null){
			request.setAttribute("normalUser", userNormalService.getUser(name));
		}
		User user = new User() ;
		user.setUsername(name);
		request.getSession().setAttribute("user", user);
		return "/user/normal/tea/normal_index" ;
	}
	
	@RequestMapping(value = "/stu/index")
	public String redirectToStuIndex(HttpServletRequest request){
		String name = request.getParameter("name") ;
		if(userNormalService.getStuDetail(name)!=null){
			request.setAttribute("detailUser",userNormalService.getStuDetail(name) );
		}
		if(userNormalService.getUser(name)!=null){
			request.setAttribute("normalUser", userNormalService.getUser(name));
		}
		return "/user/normal/stu/normal_index" ;
	}
}

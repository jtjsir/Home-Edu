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
import com.jing.edu.model.UserNotice;
import com.jing.edu.service.LoginRegisterService;
import com.jing.edu.service.UserNormalService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Resource
	LoginRegisterService loginService;

	@Resource
	UserNormalService normalService;

	@RequestMapping(value = "/on", method = RequestMethod.POST)
	public String loginValidate(String username, String password, String userType, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String redirectName = "";

		int type = Integer.valueOf(userType);
		if (!loginService.isUser(username, password, type)) {
			// 转到login页面
			redirectName = "redirect:/index/login";
			model.addAttribute("isError", "true");
		} else {
			// 转到index页面 保存user信息到session
			HttpSession session = request.getSession(true);
			User user = loginService.queryUser(username);
			// 更新在线状态
			if (type == 1) {
				UserDetailTea tea = normalService.getTeaDetail(username);
				if (null != tea) {
					normalService.updateIsonline(username, UserType.TEACHER.getName(), 1);
				} else {
					// 添加详细信息初始化
					tea = new UserDetailTea(username, null, type, user.getLevel(), null, null, null, 1, null, null,
							null, null);
					normalService.addDetail(tea);
				}
				session.setAttribute("userDetail", tea);
				redirectName = "redirect:/user/detail/" + UserType.TEACHER.getName() + "/index" ;
			} else if (type == 2) {
				UserDetailStu stu = normalService.getStuDetail(username);
				if (null != stu) {
					normalService.updateIsonline(username, UserType.STUDENT.getName(), 1);
				} else {
					// 添加详细信息初始化
					stu = new UserDetailStu(username, null, type, user.getLevel(), null, null, null, 1, null, null,
							null);
					normalService.addDetail(stu);
				}
				redirectName = "redirect:/user/detail/" + UserType.STUDENT.getName() + "/index";
				session.setAttribute("userDetail", stu);
			}
			// 增加notice表记录 自己给自己点赞
			UserNotice userNotice = new UserNotice();
			userNotice.setFromname(username);
			userNotice.setUsername(username);
			userNotice.setIsnotice(1);
			userNotice.setType(type);
			normalService.updateNotices(userNotice);

			session.setAttribute("user", user);
			//存放user用来session失效时更新相应的在线状态
			session.setAttribute(session.getId(), user);
		}

		return redirectName;
	}

	@RequestMapping(value = "/out")
	public String loginOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 更新状态
		User user = (User) session.getAttribute("user");
		if (null != user) {
			int type = user.getType();
			if (1 == type) {
				UserDetailTea tea = (UserDetailTea) session.getAttribute("userDetail");
				if (null != tea) {
					normalService.updateIsonline(user.getUsername(), UserType.TEACHER.getName(), 0);
				}
			} else if (2 == type) {
				UserDetailStu stu = (UserDetailStu) session.getAttribute("userDetail");
				if (null != stu) {
					normalService.updateIsonline(user.getUsername(), UserType.STUDENT.getName(), 0);
				}
			}
		}
		// 清除session记录
		session.removeAttribute("user");
		session.removeAttribute("userDetail");
		session.removeAttribute("city");
		session.removeAttribute("grade");
		session.removeAttribute("subject");
		session.removeAttribute(session.getId());

		return "redirect:/index/passToIndex";
	}
}

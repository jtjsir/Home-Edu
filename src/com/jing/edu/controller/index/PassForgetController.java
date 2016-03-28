package com.jing.edu.controller.index;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.model.User;
import com.jing.edu.service.PassFindService;
import com.jing.edu.util.EmailUtil;
import com.jing.edu.util.PassUtil;
import com.jing.edu.util.StringUtil;

@Controller
@RequestMapping(value = "/password")
public class PassForgetController implements BaseLogger {

	private static final Logger passLogger = LogManager.getLogger(PassForgetController.class);

	@Resource
	public PassFindService findService;

	@Override
	public Logger getLogger() {
		return this.passLogger;
	}

	@RequestMapping(value = "/find/emailval")
	public void processEmail(HttpServletRequest request, HttpServletResponse response) {
		String email = StringUtil.decodeParam(request.getParameter("email"), "GBK");
		String username = StringUtil.decodeParam(request.getParameter("username"), "GBK");
		getLogger().debug(StringUtil.getNowFormatTime() + " email为: " + email + " 正在验证数据库信息....");
		boolean isExist = findService.isEmailExist(email, username);
		if (isExist) {
			User user = findService.getUserByEmail(email, username);
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/"
					+ request.getContextPath() + "/password/accept/email?email=" + StringUtil.encodeParam(email, "GBK")
					+ "&username=" + StringUtil.encodeParam(username, "GBK");
			StringBuffer content = new StringBuffer();
			content.append("<p>").append("亲爱的").append(user.getUsername()).append(",").append("请点击以下链接重置您的密码:</p>")
					.append("<a href='").append(url).append("'>点击this就能重置你的密码了</a><br>").append("时间: ")
					.append(StringUtil.getNowFormatTime());
			// 发送邮件到用户的Email
			EmailUtil.sendEmail(user.getEmail(), content.toString());
		} else {
			getLogger().debug(
					StringUtil.getNowFormatTime() + "email为: " + email + " 且username为: " + username + " 的用户并不存在与数据库中");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
				writer.write("email is not exist,please change!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/accept/email")
	public String acceptPassReq(HttpServletRequest request, HttpServletResponse response) {
		//跳转到重置密码页面
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("username", request.getParameter("username"));
		return "redirect:/index/reset" ;
	}

	@RequestMapping(value = "/reset/email")
	public void resetPassword(HttpServletRequest request) {
//		String email = StringUtil.decodeParam(request.getParameter("email"), "GBK") ;
		String username = StringUtil.decodeParam(request.getParameter("username"), "GBK") ;
		String password = StringUtil.decodeParam(request.getParameter("password"), "GBK") ;
		String encodePassword = PassUtil.encodePass(password) ;
		findService.updatePassword(username, encodePassword);
		getLogger().debug(StringUtil.getNowFormatTime()+username + " 更新密码成功!");
	}
}

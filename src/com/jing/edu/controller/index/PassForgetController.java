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
		getLogger().debug(StringUtil.getNowFormatTime() + " email为: " + email + " 正在验证数据库信息....");
		boolean isExist = findService.isEmailExist(email);
		if (isExist) {
			User user = findService.getUserByEmail(email);
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/"
					+ request.getContextPath() + "/password/accept/email?key=" + StringUtil.encodeParam(email, "GBK");
			StringBuffer content = new StringBuffer();
			content.append("<p>").append("亲爱的").append(user.getUsername()).append(",").append("请点击以下链接重置您的密码:</p>")
					.append("<a href='").append(url).append("'>点击this就能重置你的密码了</a><br>")
					.append("时间: ").append(StringUtil.getNowFormatTime());
			// 发送邮件到用户的Email
			EmailUtil.sendEmail(user.getEmail(), content.toString());
		} else {
			getLogger().debug(StringUtil.getNowFormatTime() + "email为: " + email + " 的用户并不存在与数据库中");
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
	public void acceptPassReq(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	@RequestMapping(value = "/reset/email")
	public void resetPassword(){
		
	}
}

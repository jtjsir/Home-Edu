package com.jing.edu.controller.user;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.edu.common.util.EmailUtil;
import com.jing.edu.model.EduType.UserType;
import com.jing.edu.model.UserDetailStu;
import com.jing.edu.model.UserDetailTea;
import com.jing.edu.service.UserRecordService;

/**
 * 学生老师信息订阅处理类
 * 
 * @author jing
 *
 */
@Controller
@RequestMapping(value = "/user/detail/record")
public class UserRecordController {

	@Resource
	UserRecordService userRecordService;

	@RequestMapping(value = "/inform/getmessage")
	public void query(HttpServletRequest request, HttpServletResponse response) {
		// 获取参数userid
		String username = request.getParameter("username");
		String usertype = request.getParameter("usertype");
		String putInfo = null;
		if ("tea".equals(usertype)) {
			putInfo = userRecordService.queryRecordsByTeacher(username);
		} else if ("stu".equals(usertype)) {
			putInfo = userRecordService.queryRecordsByStudent(username);
		}
		response.setContentType("text/html;charset=utf-8");
		// 将json数据返回给前台
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(putInfo);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	@RequestMapping(value = "/inform/setisignore")
	public void set(HttpServletRequest request) {
		String stuname = request.getParameter("stuname");
		String teaname = request.getParameter("teaname");
		String guideby = request.getParameter("guideby");
		String isdelete = request.getParameter("isdelete");
		String detailPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		if ("0".equals(guideby)) {
			// 学生订阅老师
			detailPath += "/user/normal/tea/index" + "?name=" + teaname;
		} else if ("1".equals(guideby)) {
			// 老师订阅学生
			detailPath += "/user/normal/stu/index" + "?name=" + stuname;
		}
		// 设置
		userRecordService.setRecordIsIngnored(detailPath, stuname, teaname, guideby, isdelete);
	}

	@RequestMapping(value = "/recommend/getmessage")
	public void queryRecommend(HttpServletRequest request, HttpServletResponse response) {
		String userType = request.getParameter("userType");
		String putInfo = null;
		if (UserType.TEACHER.getName().equals(userType)) {
			UserDetailTea tea = (UserDetailTea) request.getSession().getAttribute("userDetail");
			if (tea == null) {
				putInfo = null;
			} else {
				putInfo = userRecordService.queryRecordsBySubject(tea.getName(), tea.getSubject(), userType);
			}
		} else if (UserType.STUDENT.getName().equals(userType)) {
			UserDetailStu stu = (UserDetailStu) request.getSession().getAttribute("userDetail");
			if (stu == null) {
				putInfo = null;
			} else {
				putInfo = userRecordService.queryRecordsBySubject(stu.getName(), stu.getSubject(), userType);
			}
		}

		response.setContentType("text/html;charset=utf-8");
		// 将json数据返回给前台
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(putInfo);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	@RequestMapping(value = "/addSubcribe")
	public void addSubscribtion(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> paramMap = new HashMap<>();
		String stuname = request.getParameter("stuname");
		String teaname = request.getParameter("teaname");
		String guideby = request.getParameter("guideby");
		String isdelete = request.getParameter("isdelete");
		paramMap.put("stuname", stuname);
		paramMap.put("teaname", teaname);
		paramMap.put("guideby", guideby);
		paramMap.put("isdelete", isdelete);
		// 订阅插入数据库供个人中心板块调用显示
		userRecordService.addSubscribtion(paramMap);
	}
}

package com.jing.edu.controller.user;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonObject;
import com.jing.edu.model.UserNotice;
import com.jing.edu.service.UserNormalService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/user/normal")
public class UserNormalContentController {
	
	@Resource
	UserNormalService normalService ;

	@RequestMapping( value = "/notice/update")
	public void updateNotice(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username") ;
		String fromname = request.getParameter("fromname") ;
		int type = Integer.valueOf(request.getParameter("type")) ;
		int isnotice = Integer.valueOf(request.getParameter("isnotice")) ;
		
		UserNotice notice = new UserNotice() ;
		notice.setFromname(fromname);
		notice.setIsnotice(isnotice);
		notice.setType(type);
		notice.setUsername(username);
		
		normalService.updateNotices(notice);
	}
	
	@RequestMapping( value = "/notice/read")
	public void getNoticeNums(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username") ;
		String fromname = request.getParameter("fromname") ;
		//点赞人数统计
		int noticeCount = normalService.readNoticeNums(username) ;
		//当前访问者是否已经点赞过该用户
		boolean flag  = normalService.isNoticedByFromName(username, fromname) ;
		
		//分装成json
		JSONObject noticeJson = new JSONObject() ;
		noticeJson.put("count", noticeCount) ;
		noticeJson.put("isnoticed", flag) ;
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(noticeJson.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
	}
}

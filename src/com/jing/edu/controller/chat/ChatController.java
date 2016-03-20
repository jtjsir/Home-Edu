package com.jing.edu.controller.chat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.edu.util.StringUtil;

@Controller
@RequestMapping(value = "/user/chat")
public class ChatController {

	@RequestMapping(value = "/index")
	public String redirectToIndex(HttpServletRequest request){
		String fromName = StringUtil.encodeParam((String)request.getAttribute("from") ,"GBK");
		String toName = StringUtil.encodeParam((String)request.getAttribute("to"),"GBK") ;
		String type = StringUtil.decodeParam((String)request.getParameter("type"), "GBK") ;
		request.setAttribute("type",type);
		request.setAttribute("from", fromName);
		request.setAttribute("to", toName);
		return "/user/chat/chat_index" ;
	}
}

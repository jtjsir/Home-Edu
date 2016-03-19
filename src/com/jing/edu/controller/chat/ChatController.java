package com.jing.edu.controller.chat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.edu.util.StringUtil;

@Controller
@RequestMapping(value = "/chat")
public class ChatController {

	@RequestMapping(value = "/index")
	public String redirectToIndex(HttpServletRequest request){
		String type = StringUtil.decodeParam((String)request.getParameter("type"), "GBK") ;
		boolean isTea = false ;
		if("tea".equals(type)){
			isTea = true ;
		}
		request.setAttribute("isTea",isTea);
		return "/user/chat/chat_index" ;
	}
}

package com.jing.edu.controller.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chat")
public class ChatController {

	@RequestMapping(value = "/index")
	public String redirectToIndex(){
		return "/user/chat/chat_index" ;
	}
}

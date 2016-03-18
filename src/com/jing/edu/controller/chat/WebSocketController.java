package com.jing.edu.controller.chat;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jing.edu.common.BaseLogger;
/**
 * session代表会话
 * @author jing
 *
 */
@ServerEndpoint(value = "/chatserver")
public class WebSocketController implements BaseLogger{

	private static final Logger webSocketLogger = LogManager.getLogger(WebSocketController.class) ;

	@Override
	public Logger getLogger() {
		return this.webSocketLogger;
	}
	
	//onopen事件在创建本对象时即运行
	@OnOpen
	public void onOpen(){
		System.out.println("server: open");
	}
	
	//长连接状态，如果跳转或者刷新页面会导致连接失败
	@OnClose
	public void onClose(){
		System.out.println("server: connection closed");
	}
	
	@OnError
	public void onError(Throwable cause){
		System.out.println("server: error");
	}
	
	@OnMessage
	public String onMessage(String message,Session session){
		System.out.println("server received message: " + message);
//		try {
//			session.getBasicRemote().sendText("this is first server message");
//		} catch (IOException e) {
//			e.printStackTrace();
//		};
		return "this is first server message" ;
	}
}

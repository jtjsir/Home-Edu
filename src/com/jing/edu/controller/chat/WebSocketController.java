package com.jing.edu.controller.chat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
	public static Set<Session> sessionSets = Collections.synchronizedSet(new HashSet<Session>()) ;

	@Override
	public Logger getLogger() {
		return this.webSocketLogger;
	}
	
	//onopen事件在创建本对象时即运行
	@OnOpen
	public void onOpen(Session session){
		String time = FORMAT.format(new Date()) ;
		this.getLogger().debug(time + " ChatServer is open! ");
		sessionSets.add(session) ;
	}
	
	//长连接状态，如果跳转或者刷新页面会导致连接失败
	@OnClose
	public void onClose(Session session){
		String time = FORMAT.format(new Date()) ;
		this.getLogger().debug(time + " ChatServer: connection closed! ");
		System.out.println(time + " ChatServer: connection closed! ");
		sessionSets.remove(session) ;
	}
	
	@OnError
	public void onError(Throwable cause,Session session){
		this.getLogger().debug(FORMAT.format(new Date()) + "--" + cause.getMessage()) ;
		sessionSets.remove(session) ;
	}
	
	@OnMessage
	public void onMessage(String message,Session session){
		String time  = FORMAT.format(new Date()) ;
		this.getLogger().debug(time + " 接收到的信息为: " + message);
		System.out.println(time + " 接收到的信息为: " + message);
		//将数据message封装成JsonObject
		net.sf.json.JSONObject jsons = net.sf.json.JSONObject.fromObject(message) ;
		jsons.put("datetime", time) ;
		
		//遍历
		Iterator<Session> iterator = sessionSets.iterator() ;
		Session openSession = null ;
		while(iterator.hasNext()){
			openSession = iterator.next() ;
			jsons.put("isSelf",session==openSession?true:false) ;
			openSession.getAsyncRemote().sendText(jsons.toString()) ;
		}
	}
}

package com.jing.edu.controller.chat;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.common.util.PushUtil;
import com.jing.edu.common.util.StringUtil;
import com.jing.edu.model.params.PushConstants;

/**
 * session代表会话
 * 
 * @author jing
 *
 */
@ServerEndpoint(value = "/chatserver/{from_and_to}")
public class WebSocketController implements BaseLogger {

	private static final Logger webSocketLogger = LogManager.getLogger(WebSocketController.class);
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

	@Override
	public Logger getLogger() {
		return webSocketLogger;
	}

	// onopen事件在创建本对象时即运行
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "from_and_to") String fromAndTo) {
		String time = FORMAT.format(new Date());
		this.getLogger().debug(time + " ChatServer is open! ");
		System.out.println(fromAndTo);
		sessionMap.put(fromAndTo, session);
	}

	// 长连接状态，如果跳转或者刷新页面会导致连接失败
	@OnClose
	public void onClose(Session session, @PathParam(value = "from_and_to") String fromAndTo) {
		String time = FORMAT.format(new Date());
		this.getLogger().debug(time + " ChatServer: connection closed! ");
		sessionMap.remove(fromAndTo) ;
	}

	@OnError
	public void onError(Throwable cause, Session session, @PathParam(value = "from_and_to") String fromAndTo) throws Throwable {
		this.getLogger().debug(FORMAT.format(new Date()) + "--" + cause.getStackTrace());
		sessionMap.remove(fromAndTo) ;
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		String time = FORMAT.format(new Date());
		this.getLogger().debug(time + " 接收到的信息为: " + message);
		// 将数据message封装成JsonObject
		net.sf.json.JSONObject jsons = net.sf.json.JSONObject.fromObject(message);
		jsons.put("datetime", time);

		// 遍历发送信息
		Iterator<Entry<String, Session>> iterator = sessionMap.entrySet().iterator();
		Session openSession = null;
		while (iterator.hasNext()) {
			openSession = iterator.next().getValue();
			jsons.put("isSelf", session == openSession ? true : false);
			// chat_index页面的直接传输
			openSession.getAsyncRemote().sendText(jsons.toString());
		}

		String fromAndto = jsons.getString("username") + ">" + jsons.getString("toName");
		Iterator<Entry<String, Session>> sendPersonIterator = sessionMap.entrySet().iterator();
		//默认对应的接收session不存在
		boolean isClose = true;
		while (sendPersonIterator.hasNext()) {
			Entry<String, Session> oneSend = sendPersonIterator.next();
			//查找是否对应接收session
			if (StringUtil.exchangePos(fromAndto, ">").equals(oneSend.getKey())) {
				isClose = false;
				break;
			}
		}
		if (isClose) {
			// 将信息传送给指定的接收者
			this.getLogger().debug("开始发送给<< " + (PushConstants.COMM_CHANNEL_CHAT + "_" + jsons.getString("toName"))
					+ "通道>>此类信息: " + jsons.get("content"));
			// 过滤html字符串
			jsons.put("content", StringUtil.filterHTMLLabel(jsons.getString("content")));
			
			//发送
			PushUtil.getGoeasyServer().publish(PushConstants.COMM_CHANNEL_CHAT + "_" + jsons.getString("toName"),
					jsons.toString());
		}
	}
}

package com.jing.edu.io.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jing.edu.common.BaseLogger;
import com.jing.edu.util.StringUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartbeatHandler extends ChannelInboundHandlerAdapter implements BaseLogger{

	private static final Logger heartLogger = LogManager.getLogger(HeartbeatHandler.class) ;
	private String fromName ;
	private String toName ;
	
	public HeartbeatHandler(String from,String to) {
		this.fromName = from ;
		this.toName = to ;
	}
	
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		//用户事件触发
		if(evt.getClass().equals(IdleStateEvent.class)){
			IdleStateEvent idleEvent  = (IdleStateEvent)evt ;
			if(idleEvent.state()==IdleState.READER_IDLE){
				//读取超时
				System.out.println(StringUtil.getNowFormatTime() + "#####(" + this.toName + ")"+ " 等待 " + "("+ this.fromName + ")" + "发送数据超时，所以决定断开连接");
				this.getLogger().debug(StringUtil.getNowFormatTime() + "#####(" + this.toName + ")"+ " 等待 " + "("+ this.fromName + ")" + "发送数据超时，所以决定断开连接");
				ctx.channel().close() ;
			}else if(idleEvent.state()==IdleState.WRITER_IDLE){
				//写入超时
				System.out.println(StringUtil.getNowFormatTime() + "#####(" + this.fromName + ")"+ " 等待 " + "("+ this.toName + ")" + "发送数据超时，所以决定断开连接");
				this.getLogger().debug(StringUtil.getNowFormatTime() + "#####(" + this.fromName + ")"+ " 等待 " + "("+ this.toName + ")" + "发送数据超时，所以决定断开连接");
				ctx.channel().close() ;
			}else if(idleEvent.state()==IdleState.ALL_IDLE){
				//均超时
				System.out.println(StringUtil.getNowFormatTime() + "#####(" + this.fromName+ ")" + " 与 " + "(" + this.toName+ ")"+ " 之间的连接断开");
				this.getLogger().debug(StringUtil.getNowFormatTime() + "#####(" + this.fromName+ ")" + " 与 " + "(" + this.toName+ ")"+ " 之间的连接断开");
				ctx.channel().close() ;
			}
		}
		super.userEventTriggered(ctx, evt);
	}

	@Override
	public Logger getLogger() {
		return this.heartLogger ;
	}

	
}

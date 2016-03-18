package com.jing.edu.io.handler;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.AttributeKey;
/**
 * 创建Http请求的初始化handler加载类
 * @author jing
 *
 */
public class HttpHandlerInitializer extends ChannelInitializer<SocketChannel>{

	private long IdleReaderTime = 2*60 ;
	private long IdleWriterTime = 3*60 ;
	private long IdleAllTime = 5*60 ;
	
	@Override
	protected void initChannel(SocketChannel sChannel) throws Exception {
		ChannelPipeline pipeline = sChannel.pipeline() ;
		pipeline.addLast(new IdleStateHandler(IdleReaderTime, IdleWriterTime, IdleAllTime, TimeUnit.SECONDS)) ;
//		pipeline.addLast(new HeartbeatHandler(from, to)) ;
	}

}

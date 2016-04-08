package com.testweb.testNetty;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
	private Logger logger = Logger.getLogger(DiscardServerHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		System.out.println("channelRead");
		ByteBuf in = (ByteBuf) msg;
	    try {
	        while (in.isReadable()) { // (1)
	            System.out.print((char) in.readByte());
	            System.out.flush();
	        }
	        
	    } finally {
	        ReferenceCountUtil.release(msg); // (2)
	    }
//	    ctx.write(msg); // (1)
//        ctx.flush(); // (2)
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}
}

package com.testweb.testNetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpVersion;

import java.net.InetAddress;
import java.net.URI;



public class NettyTest {

	public static void main(String args[]){
		
	}
}

class CommonServer {

	public static void start(int port/*
									 * , final
									 * MultiConsumerWareHouse<SendRequestTask>
									 * wareHouse
									 */) throws InterruptedException {

		EventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workerGroup = new NioEventLoopGroup(2);

		workerGroup.setIoRatio(50);
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			
			bootstrap.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch)
								throws Exception {
							ch.config().setAutoRead(true);

							System.out.println("server start");
							ch.pipeline().addLast(new HttpRequestDecoder());
							ch.pipeline().addLast(new HttpResponseEncoder());
							ch.pipeline().addLast(new HttpServerHandler2());
						}
					}).option(ChannelOption.SO_BACKLOG, 128) // 流控
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			ChannelFuture f = bootstrap.bind(port).sync();

			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}

	}

}

class HttpServerHandler2 extends ChannelHandlerAdapter {

	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {

		if (msg instanceof HttpRequest) {
			HttpRequest request = (HttpRequest) msg;
			// System.out.println(request.toString());
			if (request.getUri().contains("pic1")) {
				InetAddress iAddress = InetAddress
						.getByName("asearch.alicdn.com");
				String uri = "/bao/uploaded/i1/189050106579034484/TB28ir7dpXXXXbcXXXXXXXXXXXX_!!17468905-0-saturn_solar.jpg_200x200.jpg_.webp";
				Bootstrap b = createBootStrap(ctx, "asearch.alicdn.com", uri);
				b.connect(iAddress, 80);
			} else {
				InetAddress iAddress = InetAddress.getByName("i1.itc.cn");
				String uri = "/20150806/31e9_f52bb95f_f509_7bc6_5def_c0e48e908048_1.jpg";
				Bootstrap b = createBootStrap(ctx, "i1.itc.cn", uri);
				b.connect(iAddress, 80);
			}
		} else if (msg instanceof HttpContent) {
			System.out.println("http content");
		}
	}

	/**
	 * @param ctx
	 * @param uri
	 * @return
	 */
	private Bootstrap createBootStrap(final ChannelHandlerContext ctx,
			final String host, final String uri) {
		Bootstrap b = new Bootstrap();
		b.group(ctx.channel().eventLoop());
		b.channel(NioSocketChannel.class);
		b.option(ChannelOption.SO_KEEPALIVE, true);
		b.option(ChannelOption.TCP_NODELAY, true);
		b.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			public void initChannel(SocketChannel ch) throws Exception {
				ch.config().setAllocator(new PooledByteBufAllocator());
				ch.pipeline().addLast(new HttpRequestEncoder());
				ch.pipeline().addLast(new HttpResponseDecoder());
				ch.pipeline().addLast(new HttpClientHandler2(host, uri, ctx));
			}
		});
		return b;
	}
}

class HttpClientHandler2 extends ChannelHandlerAdapter {

	String host;

	String uri;

	ChannelHandlerContext serverCtx;

	public HttpClientHandler2(String host, String uri,
			ChannelHandlerContext serverCtx) {
		this.host = host;
		this.uri = uri;
		this.serverCtx = serverCtx;
	}

	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		URI uri = new URI(this.uri);
		DefaultHttpRequest req = new DefaultHttpRequest(HttpVersion.HTTP_1_1,
				HttpMethod.GET, uri.toASCIIString());
		req.headers().add("Host", this.host);
		ctx.writeAndFlush(req);
	}

	/*
	 * tb2.bdstatic.com/img/search_logo_7835b03.png (non-Javadoc)
	 * 
	 * @see io.netty.channel.ChannelHandlerAdapter#channelRead(io.netty.channel.
	 * ChannelHandlerContext, java.lang.Object)
	 */
	public void channelRead(ChannelHandlerContext ctx, final Object msg)
			throws Exception {
		if (msg instanceof HttpResponse) {
			serverCtx.writeAndFlush(msg);
		} else if (msg instanceof DefaultLastHttpContent) {
			// 最后的消息
			serverCtx.writeAndFlush(msg);
			ctx.channel().close();

		} else if (msg instanceof HttpContent) {
			serverCtx.writeAndFlush(msg);
		}
	}

}
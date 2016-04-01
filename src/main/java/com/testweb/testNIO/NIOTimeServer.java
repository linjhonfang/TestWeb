package com.testweb.testNIO;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;


public class NIOTimeServer {

	public static void main(String args[]) throws IOException{
		int port = 8080;
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer,"NIO-MultiplexerTimeServer").start();

	}
}
class MultiplexerTimeServer implements Runnable{
	private Selector selector;
	private ServerSocketChannel servChannel;
	private volatile boolean stop;
	public MultiplexerTimeServer(int port){
		try{
			selector = Selector.open();
			servChannel = ServerSocketChannel.open();
			servChannel.configureBlocking(false);
			servChannel.socket().bind(new InetSocketAddress(port),1024);
			servChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			System.out.println("The time server is start in port : "+ port);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run(){
		while(true){
			try{
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectedKeys.iterator();
				SelectionKey key = null;
				while(it.hasNext()){
					key = it.next();
					it.remove();
					try{
						handleInput(key);
					}catch (Exception e){
						if ( key != null){
							key.cancel();
							if(key.channel()!=null){
								key.channel().close();
							}
						}
					}
				}  
			}catch (Throwable t){
				t.printStackTrace();
			}
		}
	}
	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			if(key.isAcceptable()){
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel)key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order : "+ body);
					String currentTime = "QUERY TIME ORDER"
							.equalsIgnoreCase(body) ? new Date(
							System.currentTimeMillis()).toString() : "WRONG";
					doWrite(sc, currentTime);
				} else if(readBytes<0){
					key.cancel();
					sc.close();
				}
			}
		}
	}
	private void doWrite(SocketChannel channel, String response) throws IOException{
		if(StringUtils.isNotBlank(response)){
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			channel.write(writeBuffer);
			System.out.println("doWrite "+response);
		}
	}
}

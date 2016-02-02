package com.testweb.testNIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
	public static void main(String args[]) throws IOException{
		int port = 8080;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("The tiem server is start in port : " + port);
			Socket socket = null;
			while (true) {
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}

		} finally {
			if (server != null) {
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}
	}
}
class TimeServerHandler implements Runnable{

	private Socket socket;
	
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String currentTime = null;
			String body = null;
			while(true){
				body = in.readLine();
				if(body == null){
					break;
				}
				System.out.println("The time server receive order : "+ body);
				currentTime = "query Time Order".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"WRONG";
				out.print(currentTime);
			}
		}catch(IOException e){
			if(in !=null){
				try{
					in.close();
				}catch (IOException e1){
					e1.printStackTrace();
				}
			}
			if(out!=null){
				out.close();
				out = null;
			}
			if(this.socket !=null){
				try{
					this.socket.close();
				} catch (IOException e1){
					e1.printStackTrace();
				}
				this.socket = null;
			}
		}
	}
	
}
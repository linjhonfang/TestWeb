package com.testweb.testNIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NIOTimeClient {
	public static void main(String args[]){
		int port = 8080;
		Socket socket = null;
		BufferedReader in = null;  
		PrintWriter out = null;
		try{
			socket = new Socket("127.0.0.1",port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			out.println("query Time Order1");
			System.out.println("Send order 2 server succeed");
			String resp = in.readLine();
			System.out.println("Now is : " + resp);
		}catch (Exception e){
			
		}finally{
			out.close();
			try{
			in.close();
			}catch(IOException e ){
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

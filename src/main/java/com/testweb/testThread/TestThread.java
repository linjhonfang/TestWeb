package com.testweb.testThread;

import java.util.concurrent.Executors;

public class TestThread {
	static int wo = 0;
	public static void main2(String args[]){
		
		Runnable thread = null;
		
		while(true){
			wo++;
			System.out.println(wo);
			thread = new Runnable() {
				int wo=0;
				public void run() {
					while (true){
						System.out.println("runnable" + wo++);
					}
				}
			};
			new Thread(thread).start();
		}
	}
	
	public static void main(String args[]){
		Executors.newSingleThreadExecutor();
	}
	
}

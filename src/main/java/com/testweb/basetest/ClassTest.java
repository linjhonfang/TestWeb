package com.testweb.basetest;

public class ClassTest {

	public static void main(String args[]) throws InterruptedException{
		new ClassTest().v();
	}
	public volatile boolean args = false;
	
	public void v() throws InterruptedException{
		Runnable run = new Runnable(){
			public void run(){
				int i = 0;
				while(args==false){
					try {
						System.out.println("#"+i++);
						Thread.sleep(1l);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		Thread.sleep(10l);
		System.out.println("#end");
		args = true;
		
	}
}

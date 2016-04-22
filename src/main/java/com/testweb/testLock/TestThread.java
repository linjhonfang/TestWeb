package com.testweb.testLock;

public class TestThread {

	public static void main(String args[]){
		new Thread(run).start();
		new Thread(run).start();
	}
	static Runnable run = new Runnable(){
		public void run(){
			try {
				TestThread.method();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	public static String lock = "lock";
	public static Integer int_lock = 0;
	public static void method() throws InterruptedException{
		System.out.println("~~~~~~~"+Thread.currentThread().getId());
		if(Thread.currentThread().getId()==12){
		synchronized (int_lock) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+Thread.currentThread().getId());
			Thread.sleep(2000);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+Thread.currentThread().getId());
		}
		}
		if(Thread.currentThread().getId()==13){
//			synchronized (int_lock_1) {
//				System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+Thread.currentThread().getId());
//				Thread.sleep(2000);
//				System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+Thread.currentThread().getId());
//			}
			if(int_lock==0){
				int_lock=int_lock-1;
				System.out.println("~~~~int_lock"+int_lock);
			}
		}
	}
	public static Integer int_lock_1 = 0;
	public static String lock1 = "lock";
	
}

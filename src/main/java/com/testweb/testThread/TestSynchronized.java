package com.testweb.testThread;


public class TestSynchronized {
	
	public static Integer i = 0;
	
	public static void init(){
		int j =0;
		
		synchronized (i) {
			String s = "sd";
			System.out.println(s);
		}
	}
	
	public synchronized void method(){
		int j = 0;
		
		System.out.println("ssd method");
	}
	
	public synchronized void method2(){
		int j = 0;
		
		System.out.println("ssd method2");
	}

	public static void main1(String args[]){
		Thread thread1 = new Thread(new Runnable1());
		Thread thread2 = new Thread(new Runnable1());
		thread2.start();
		thread1.start();
	}
	
	public static void main(String args[]) throws InterruptedException{
		TestSynchronized t = new TestSynchronized();
		Runnable2 run2 = new Runnable2(t);
		Runnable2_1 run2_1 = new Runnable2_1(t);
		Thread thread1 = new Thread(run2);
		Thread thread2 = new Thread(run2_1);
		
		thread1.start();
		Thread.sleep(1000L);
		thread2.start();
	}
	
}
class Runnable1 implements Runnable{
	
	@Override
	public void run() {
		TestSynchronized.init();
	}
}

class Runnable2 implements Runnable{
	public TestSynchronized t;
	public Runnable2(TestSynchronized t){
		this.t = t;
	}
	@Override
	public void run() {
		t.method();
	}
}

class Runnable2_1 implements Runnable{
	public TestSynchronized t;
	public Runnable2_1(TestSynchronized t){
		this.t = t;
	}
	@Override
	public void run() {
		t.method2();
	}
}
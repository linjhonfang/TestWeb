package com.testweb.testSchedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedule {
	private static ScheduledExecutorService widgetInfoScheduled;
	public static void sc(){
		widgetInfoScheduled = Executors.newScheduledThreadPool(1);
		widgetInfoScheduled.scheduleWithFixedDelay(new Runnable() {
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("##"+Thread.currentThread().getId());
				}
			}
		},1,1, TimeUnit.SECONDS);
	}
	public static void main(String args[]) throws InterruptedException{
		sc();
		//sc();
		Thread.sleep(9000);
		widgetInfoScheduled.shutdownNow();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+widgetInfoScheduled.isShutdown());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+widgetInfoScheduled.isTerminated());
		
	}
}

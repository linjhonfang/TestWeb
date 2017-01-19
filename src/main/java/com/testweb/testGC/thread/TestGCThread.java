package com.testweb.testGC.thread;

import java.util.Random;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/1/10 下午8:29
 */
public class TestGCThread {
    /**结论 线程没有引用 也会继续下去*/
    /**如果遇到线程单独做事情，如果有热部署之类，并且内部是死循环来做事情，注意置空不会线程还在，如需停掉，需要业务上给个钩子*/
    public static void main(String args[]) throws InterruptedException {
        TestGCThread sdf = new TestGCThread();
        sdf.t.start();
        Thread.sleep(5000);
        sdf.t = null;
        sdf.t.notify();
        System.gc();
        Runtime.getRuntime().gc();
        Thread.sleep(1000);
        System.out.println("TestGCTread 已经质控1s");
        Thread.sleep(5000);
        sdf.switchThread = false;
        System.out.println("end");
    }
    Thread t = new Thread(new Runnable(){
       public void run(){
            for(;;){
                try {
                    if(switchThread==false)break;
                    System.out.println("xxcxxc"+ new Random().nextInt());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    boolean switchThread = true;
}

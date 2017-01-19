package com.testweb.testGC.thread;

import java.util.Random;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/1/10 ����8:29
 */
public class TestGCThread {
    /**���� �߳�û������ Ҳ�������ȥ*/
    /**��������̵߳��������飬������Ȳ���֮�࣬�����ڲ�����ѭ���������飬ע���ÿղ����̻߳��ڣ�����ͣ������Ҫҵ���ϸ�������*/
    public static void main(String args[]) throws InterruptedException {
        TestGCThread sdf = new TestGCThread();
        sdf.t.start();
        Thread.sleep(5000);
        sdf.t = null;
        sdf.t.notify();
        System.gc();
        Runtime.getRuntime().gc();
        Thread.sleep(1000);
        System.out.println("TestGCTread �Ѿ��ʿ�1s");
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

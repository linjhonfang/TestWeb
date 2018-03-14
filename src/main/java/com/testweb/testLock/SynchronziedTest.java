package com.testweb.testLock;

/**
 * Created by xingxuechao on 2016/6/12.
 */
public class SynchronziedTest {

    public static void main(String args[]){
        new Thread(run).start();
        new Thread(run1).start();
        new Thread(new SynchronziedTest().run3).start();
        new Thread(new SynchronziedTest().run2).start();
        new Thread(new SynchronziedTest().run3).start();

    }

    public static Runnable run = new Runnable() {
        @Override
        public void run() {
            try {
                method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static Runnable run1 = new Runnable() {
        @Override
        public void run() {
            try {
                method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public Runnable run2 = new Runnable() {
        @Override
        public void run() {
            try {
                method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public Runnable run3 = new Runnable() {
        @Override
        public void run() {
            try {
                method3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void method() throws InterruptedException {

        System.out.println("线程id("+Thread.currentThread().getId()+")进入 method");

        synchronized (SynchronziedTest.class){
            System.out.println("线程id("+Thread.currentThread().getId()+"进入 method sync area");
            Thread.sleep(5000L);

        }

        System.out.println("线程id("+Thread.currentThread().getId()+")退出 method");
    }

    public synchronized static void method1() throws InterruptedException {
        System.out.println("线程id("+Thread.currentThread().getId()+")进入 method1");
        Thread.sleep(2000L);
        System.out.println("线程id("+Thread.currentThread().getId()+")退出 method1");
    }

    public synchronized void method2() throws InterruptedException {
        System.out.println("线程id("+Thread.currentThread().getId()+")进入 method2");
        Thread.sleep(2000L);
        System.out.println("线程id("+Thread.currentThread().getId()+")退出 method2");
    }

    public void method3() throws InterruptedException {
        System.out.println("线程id("+Thread.currentThread().getId()+")进入 method3");
        Thread.sleep(5000L);
        System.out.println("线程id("+Thread.currentThread().getId()+")退出 method3");
    }


}

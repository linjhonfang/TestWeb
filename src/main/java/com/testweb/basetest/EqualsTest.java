package com.testweb.basetest;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/9/30 上午5:16
 */
public class EqualsTest {
    public static void main(String args[]) {
        T t = new T("1","order");
        T t1 = t;
        System.out.println(t1 == t);
        t.a = "12";
        System.out.println(t1 == t);
    }
}

class T {
    String a;
    String b;
    T(String a, String b){
        this.a = a;
        this.b = b;
    }

}


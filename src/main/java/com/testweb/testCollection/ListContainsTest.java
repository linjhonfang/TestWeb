package com.testweb.testCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/3/2 ����6:03
 */
public class ListContainsTest {
    public static void main1(String args[]){
        String args1 = "xingxuechao";
        String args2 = "xing";
        String args3 = "xuechao";
        System.out.println(args1==(args2+args3));
    }

    public static void main2(String args[]){
        String args1 = "xingxuechao";
        String args2 = "xing";
        String args3 = "xuechao";
        System.out.println(args1==(args2+args3));

        List<String> list1 = new ArrayList<String>();
        list1.add(args1);
        List<String> list2 = new ArrayList<String>();
        list2.add(args2+args3);
        list1.containsAll(list2);
        System.out.println(list1.containsAll(list2));
    }

    public static void main(String args[]) {

    }
}

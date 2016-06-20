package com.testweb.testRandom;

/**
 * Created by xingxuechao on 6/16/16.
 */
public class TestRandom {


    public static int[] randomIntArray(int length){
        int[] num = new int[length];
        for(int i =0;i<length-1 ;i++){
            num[i] = new Double(Math.random()*length).intValue();
        }
        return num;
    }

    public static int[] randomIntArrayNotRepeat(int length) {
        int[] num = new int[length];
        int len = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            num[i] = i;
        }

        for (int i = 0; i < length; i++) {
            len = new Double(Math.random() * (length - 1 - i)).intValue();
            temp = num[length - 1 - i];
            num[length - 1 - i] = num[len];
            num[len] = temp;
        }
        return num;

    }
}

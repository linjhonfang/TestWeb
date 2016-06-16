package com.testweb.testCPU;

/**
 * Created by xingxuechao on 6/16/16.
 */
public class CacheTest {
    public static void main(String args[]){
        testCache(1000, 10000, 10000);

        testCache(10000, 10000, 1000);
    }

    private static void testCache(int a, int b, int c) {
        Long start = System.currentTimeMillis();
        int total = 0;
        for(int i=0;i<a;i++ ){
            for(int j=0;j<b;j++){
                for(int k=0;k<c;k++){
                    total = i + j+ k;
                }
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("total="+total+" times:"+(end-start));
    }

}

package com.testweb.algorithm.sort;

import com.testweb.testRandom.TestRandom;

import javax.sound.midi.SysexMessage;

/**
 * Created by xingxuechao on 16/6/7.
 */
public class QuickSort {

    public void qs(int[] num, int start, int end) {
        if (start >= end) return;
        int i = start;
        int j = end;
        int temp = num[start];
        while (i < j) {
            while (j > i && num[j] >= temp) {
                j--;
            }
            num[i] = num[j];
            while (i < j && num[i] <= temp) {
                i++;
            }
            num[j] = num[i];
        }
        num[i] = temp;
        qs(num, start, i-1);
        qs(num, i + 1, end);
    }

    public void swap(int[] num, int f, int s) {
        int temp = num[f];
        num[f] = num[s];
        num[s] = temp;
    }

    public static void main(String args[]) {
//        int[] num = new int[]{10, 5, 6, 4, 3, 9, 7, 8, 1, 2};
//        int[] num = new int[]{9,8,6,8,0,7,4,8,6,0};
//        int[] num = TestRandom.randomIntArray(2000);
        int[] num = TestRandom.randomIntArrayNotRepeat(200);
        for (int n : num) {
            System.out.print(n + ",");
        }
        System.out.println();
        QuickSort quickSort = new QuickSort();
        quickSort.qs(num, 0, num.length - 1);
        boolean judge = true;
        for (int i=0;i<num.length;i++) {
            System.out.print(num[i] + ",");
            if(i>1&&num[i]<num[i-1]){
                judge = false;
            }
        }
        System.out.println();
        System.out.print("judge = "+judge);

    }

}

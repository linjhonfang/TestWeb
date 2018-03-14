package com.testweb.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/9/18 下午7:49
 */
public class ACMTest {
    public static Map<Integer,Character> map = new HashMap<Integer,Character>() {
        {
            char[] strs = new char[26];
            for (int i = 0; i < 26; i++) {
                strs[i]= (char)(97 + i );
                put(i+1,strs[i]);
            }
        }
    };
    public static void main(String args[]) {

        String num = "12";
        StringBuilder number= new StringBuilder(num);
        Character[] s = new Character[number.length()];//特殊的数据
        Character[] normal = new Character[number.length()];//正常的
        for(int i=0;i<number.length();i++){

            int t  = number.charAt(i);
            normal[i] = map.get(t);
            int t1 = number.charAt(i+1);
            if((t==1 || t==2 ) && i != number.length() && t1<=6){
                int ts = t*10+t1;
                s[i] = map.get(ts);
            }
        }
        Character[][] sbList = new Character[number.length()][];
        sbList[0] = normal;
//        for(int i=0;i<normal.length;i++) {
//            sbList[i] = sbList;
//        }
    }

}

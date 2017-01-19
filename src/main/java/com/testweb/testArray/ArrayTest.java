package com.testweb.testArray;

import com.alibaba.fastjson.JSON;

public class ArrayTest {
	public static void main1(String[] args) {
		arrayIn();
		arrayIn("123","234");
	}

	public static void arrayIn(String... str) {

		System.out.println(JSON.toJSONString(str));
	}

	public static void main(String args[]){
		String[] str = new String[100];
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
}

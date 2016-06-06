package com.testweb.testArray;

import com.tudou.utils.json.JsonTool;

public class ArrayTest {
	public static void main1(String[] args) {
		arrayIn();
		arrayIn("123","234");
	}

	public static void arrayIn(String... str) {

		System.out.println(JsonTool.writeValueAsString(str));
	}

	public static void main(String args[]){
		String[] str = new String[100];
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
	}
}

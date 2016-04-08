package com.testweb.testArray;

import com.tudou.utils.json.JsonTool;

public class ArrayTest {
	public static void main(String[] args) {
		arrayIn();
		arrayIn("123","234");
	}
	public static void arrayIn(String... str){
		System.out.println(JsonTool.writeValueAsString(str));
	}
}

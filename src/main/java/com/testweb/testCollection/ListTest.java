package com.testweb.testCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

	public static void main1(String args[]){
		List<String> str= null;
		for(String st : str){
			System.out.println("fine~");
		}
	}

	public static void main2(String args[]){
		List<String> str = new ArrayList<String>(100);

		for(int i = 0;i<str.size();i++){
			System.out.println(str.get(i));
		}
	}

	public static void main(String args[]){
		String[] arr = {"xing","xue","chao"};
		List<String> str = null;
		str = Arrays.asList(arr);
		System.out.println(str);
	}
}

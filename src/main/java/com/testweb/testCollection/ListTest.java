package com.testweb.testCollection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main1(String args[]){
		List<String> str= null;
		for(String st : str){
			System.out.println("fine~");
		}
	}

	public static void main(String args[]){
		List<String> str = new ArrayList<String>(100);

		for(int i = 0;i<str.size();i++){
			System.out.println(str.get(i));
		}
	}
}

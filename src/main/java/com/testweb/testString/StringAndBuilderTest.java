package com.testweb.testString;

public class StringAndBuilderTest {

	public static void main(String args[]){
		
        long beginTime = System.currentTimeMillis();
        String a = "";
		for(int i=0;i<10000;i++){
			a+="aad";
		}
        long endTime = System.currentTimeMillis();
        System.out.println("String : " + (endTime - beginTime) + "\t");
		
		long beginTime2 = System.currentTimeMillis();
		StringBuilder ab = new StringBuilder();
		for(int i=0;i<10000;i++){
			ab.append("aad");
		}
        long endTime2 = System.currentTimeMillis();
        System.out.println("String : " + (endTime2 - beginTime2) + "\t");
		
	}
	public static void main1(String args[]){
		long beginTime = System.currentTimeMillis();
        String str="";
		for(int i=0;i<100000;i++){
			str=i+"";
		}
	}
}

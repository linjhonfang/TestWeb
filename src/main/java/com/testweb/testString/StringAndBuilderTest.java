package com.testweb.testString;

import org.apache.commons.lang.StringUtils;

import com.tudou.utils.json.JsonTool;

public class StringAndBuilderTest {

	public static void main2(String args[]){
		
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
	
	public static void main4(String args[]){
		String s = "";
		System.out.println(Integer.valueOf(s));
	}
	
	public static void main5(String[] args) {
		Model_Str mo = new Model_Str();
		mo.setStr("123123");
		String json = JsonTool.writeValueAsString(mo);
		Model_Long mo2 =JsonTool.readValue(json, Model_Long.class);
		System.out.println(mo2.getStr());
	}
	
	public static void main6(String[] args) {
		Model_Long mo = new Model_Long();
		mo.setStr(new Long(23123123));
		String json = JsonTool.writeValueAsString(mo);
		Model_Str mo2 =JsonTool.readValue(json, Model_Str.class);
		System.out.println(mo2.getStr());
	}
	
	public static void main(String[] args) {
		Model_Long mo = new Model_Long();
		mo.setStr(new Long(23123123));
		String json = JsonTool.writeValueAsString(mo);
		Model_Integer mo2 =JsonTool.readValue(json, Model_Integer.class);
		System.out.println(mo2.getStr());
	}
}
class Model_Str{
	String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
class Model_Long{
	Long str;

	public Long getStr() {
		return str;
	}

	public void setStr(Long str) {
		this.str = str;
	}
}
class Model_Integer{
	Integer str;

	public Integer getStr() {
		return str;
	}

	public void setStr(Integer str) {
		this.str = str;
	}
}
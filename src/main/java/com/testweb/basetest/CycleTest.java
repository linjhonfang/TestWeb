package com.testweb.basetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CycleTest {

	public static void main(String args[]){
		Map<String,Boolean> map =  new HashMap<String, Boolean>();
		Boolean b = (map==null ? false: map.get("test") );
		
		
	}
	
	
	public void testArray(){
		//System.out.println(Paths.get("D:/xxc"));
		//FSDirectory.open(Paths.get("D:/xxc"));

		List<Integer> intList =null;
		intList = Arrays.asList(1,2,3,4,5,6,7);
		Object[] j = {1,2,"sd"};
		Object[] o = intList.toArray(j);
		System.out.println(o[1]);
		System.out.println(o[0]);
		System.out.println(o[2] instanceof String);
		System.out.println(o[2]);
	}
	
	public void testMethodNull(){
		Test t1 = new Test();
		t1.setA(null);
		new Test().setA(t1.getA());
		System.out.println("T");
	}
	
	public void  testCycle(){
		for(int i=0 ;i<10 ;i++){
			System.out.println("i="+i);
			for(int j=0;j<10;j++){
				System.out.println("j="+j);
				if(j==3)break;
					
			}
		}
	}
	public void testString (){
		String str = "1231231231";
		System.out.println(Long.getLong(str));
		System.out.println(Long.parseLong(str)-1);
		System.out.println(Long.valueOf(str)-1);
	}
}
class Test{
	Float a;
	Long b;
	public Float getA() {
		return a;
	}
	public void setA(Float a) {
		this.a = a;
	}
	public Long getB() {
		return b;
	}
	public void setB(Long b) {
		this.b = b;
	}
	
}


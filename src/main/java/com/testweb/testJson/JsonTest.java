package com.testweb.testJson;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonTest {
	
	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException{
		Test test = mockTest();
		ObjectMapper mapper = new ObjectMapper();
		
		String str = mapper.writeValueAsString(test); 
		System.out.println("str="+str);
	}
	
	public static  Test mockTest(){
		Test test = new Test();
		test.id="123123123";
		test.value = null;
		return test;
	}
}
class Test{
	public String id;
	public Double value;
}
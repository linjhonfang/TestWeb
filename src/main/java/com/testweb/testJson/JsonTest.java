package com.testweb.testJson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.tudou.utils.json.JsonTool;

public class JsonTest {
	
	public static void main2(String args[]) throws JsonGenerationException, JsonMappingException, IOException{
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
	
	public static void main(String[] args) {
		
		String result="";
				if(StringUtils.isNotBlank(result)){
			Map<String, Object> resultMap=JsonTool.readValue(result, Map.class);
			
			List<Map> list = JsonTool.readValue2List(resultMap.get("data").toString(), Map.class);
			
			for(Map map : list){
				System.out.println(map.get("id"));
			}
		}
		
	}
	
}
class Test{
	public String id;
	public Double value;
}
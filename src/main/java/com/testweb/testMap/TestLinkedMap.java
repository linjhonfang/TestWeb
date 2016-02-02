package com.testweb.testMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestLinkedMap {

	public static void main2(String args[]){
		//Map map = new LinkedHashMap();
		List a = null;
		for(Object o : a){
			
		}
	}
	
	public static void main3(String args[]){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1234);
		
		map.put("1", list);
		list.clear();
		for(Map.Entry entry : map.entrySet()){
			System.out.println(entry.getValue());	
		}
		
	}
	
	public static void main(String args[]){
		LRUCacheMap<String, Object> lc = new LRUCacheMap<String, Object>(10);
		testInsertCache(lc,"1",5);
		testInsertCache(lc,"2",6);
		testInsertCache(lc,"3",5);
		testInsertCache(lc,"4",3);
		testInsertCache(lc,"5",5);
		testInsertCache(lc,"6",4);
		testInsertCache(lc,"7",5);
		testInsertCache(lc,"8",5);
		testInsertCache(lc,"9",2);
		testInsertCache(lc,"10",5);
		testInsertCache(lc,"11",11);
		testInsertCache(lc,"12",10);
		testInsertCache(lc,"13",1);
		testInsertCache(lc,"14",1);
		
		for(Map.Entry entry : lc.entrySet()){
			System.out.println(entry.getKey()+" -- "+entry.getValue());	
		}
		
	}
	
	public static void testInsertCache(LRUCacheMap<String, Object> lc, String value, int time){
		for(int i=0;i<time;i++){
			lc.put(value, "1");
		}
	}
	
	
}
class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {
	private final int cacheSize;

	public LRUCacheMap(int cacheSize) {
		super(16, 0.75f, true);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() >= cacheSize;
	}
}
class LRUCache {
	class node{
		String key;
		String value;
	}
	//public 
}
package com.testweb.TestWork;

import java.util.*;


public class Solution {
	
	public static void main2(String args[]){
		Set<String> set = new HashSet<String>();
		set.add("String");
		set.add("ib");
		set.add("boring");
		set.add("is");
		set.add("ba");
		set.add("borin");
		set.add("gt");
		System.out.println(new Solution().wordBreak("Stringibboringg", set));
	}
	
	public static void main3(String args[]){
		Set<String> set = new HashSet<String>();
		set.add("car");
		set.add("ca");
		set.add("rs");
		System.out.println(new Solution().wordBreak("cars", set));
	}
	
	public static void main(String args[]){
		Set<String> set = new HashSet<String>();
		set.add("b");
		
		System.out.println(new Solution().wordBreak("a", set));
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(wordDict.size()==0)return false;
        Map<Character,List<String>> map = makeMap(wordDict);
        for(Map.Entry<Character, List<String>> entry :map.entrySet()){
        	StringBuilder sb = new StringBuilder();
        	sb.append("key:"+entry.getKey());
        	sb.append("value:"+entry.getValue().toString());
        	System.out.println(sb);
        }
        int[] bit = new int[s.length()];
        int bitPost = -1;
        int[] bitW = new int[s.length()];
		for (int i = 0; i < s.length(); ) {
			Character first = s.charAt(i);
			List<String> list = map.get(first);
			boolean isMatch = false;
			
			if(list != null){
				if(bit[i] == 0){
					bit[i] = list.size();
				}
				String b = list.get(bitW[i]);
				isMatch = compare(s, b, i);
				if(isMatch)i=i+b.length();
			}
			if(!isMatch){
				if(bitW[i]<(bit[i]-1)){
					bitW[i]++;
				}else{
					if(bitPost == -1){
						bitPost = i;
					}
					while( bitPost>0 ){
						if(bit[bitPost]==0||bitW[bitPost]>=(bit[bitPost]-1)){
							bitPost--;
						}else{
							break;
						}
					}
					if(bitPost<0||(bitPost==0&&bitW[bitPost]>=bit[bitPost]-1)){
						return false;
					}else{
						i = bitPost;
						bitW[i]++;
					}
				}
			}
		}
		
        return true;
    }
	public boolean compare(String s , String b,int i){
		if((i+b.length())>s.length()){
			return false;
		}
		String str = s.substring(i, i+b.length());
		System.out.println("对比字符串 ："+str+"-"+b);
		return str.equals(b);
	}
	
	public void next(){
		
	}
	
	public Map<Character,List<String>> makeMap(Set<String> wordDict){
		Map<Character,List<String>> map = new HashMap<Character,List<String>>();
        Iterator<String> stringIterator = wordDict.iterator();
		while(stringIterator.hasNext()){
        	String str = stringIterator.next();
        	Character first = str.charAt(0);
        	if(map.get(first)==null){
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		map.put(first, list);
        	}else{
        		List<String> list = map.get(first);
        		list.add(str);
        	};
        }
		return map;
	}
}

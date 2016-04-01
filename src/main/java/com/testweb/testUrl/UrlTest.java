package com.testweb.testUrl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.tudou.utils.client.HTTPLongClient;
import com.tudou.utils.json.JsonTool;

public class UrlTest {
	public static void main(String[] args) {
		for(int i =0 ;i<1000;i++){
		//String itemUrl ="http://item.taobao.com/item.htm?id=41645073779";
		Map<String,Object> parms = new LinkedHashMap<String,Object>();
		List<String> itemIdList = new LinkedList<String>();
		itemIdList.add("4814802526864358"+i);
		parms.put("goods_id", JsonTool.writeValueAsString(itemIdList));
		String result = HTTPLongClient.getUrlContent("http://10.103.88.77/interact/stats/by_goods_id?goods_id=", false, parms, "utf-8");
		if(result==null){
			System.out.println("result is null");
			
		}
		System.out.println("result= " + result );
		}
	}
}

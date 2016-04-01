package com.testweb.testElastic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;

import com.tudou.utils.json.JsonTool;

public class ElasticTest {

	
	public static void main(String[] args) throws IOException {
		Client transferClient = null;
				Settings settings = Settings.settingsBuilder().
                put("client.transport.sniff", true).
                put("cluster.name", "my-test").
                //put("node.name ", NODE).
                build();
				
		TransportAddress transportAddress = new InetSocketTransportAddress(InetAddress.getByName("10.5.16.125"), 2100);
        transferClient = TransportClient.builder().settings(settings).build().addTransportAddress(transportAddress);
        
        BulkProcessor bulkProcessor = new ElasticTest().initBulkProcessor(transferClient);
        
        String test = "{\"wordKey\":\"巴比罗利\",\"catagory\":\"音乐家\",\"catalog\":\"艺术\",\"fileName\":\"艺术音乐家.txt\",\"baiduUrl\":\"http://baike.baidu.com/view/1728736.html?fromTaglist\"}";
        IndexRequest indexRequest = new IndexRequest("wordwiki", "test", "1");
        indexRequest.source(test);
        indexRequest.routing("2");
        bulkProcessor.add(indexRequest);
        //new FileReader("D:/wordwiki/地理/阿根廷.txt");
//        File rootFile = new File("D:/wordwiki/");
//		int is = 0;
//        for(File file1 : rootFile.listFiles()){
//        	String file1Name = file1.getName();
//        	for(File file2 : file1.listFiles()){
//        		String file2Name = file2.getName();
//        		String f[] = file2Name.split("\\.");
//        		String file2NameNotSuffix =null;
//        		if(f.length==2){
//        			file2NameNotSuffix = f[0];
//        		}else{
//        			System.out.println("~@!!~!~!~!~!~!file is wrong file2Name ="+file2Name +" f.length="+f.length);
//        		}
//        		
//        		FileReader fileReader = new FileReader(file2);
//        		BufferedReader bufferReader = new BufferedReader(fileReader);
//        		String s = null;
//        		Map<String,Object> map = new HashMap<String,Object>();
//        		while((s = bufferReader.readLine()) != null){
//        			String[] str = s.split("!");
//        				map.put("catalog", file1Name);
//        				map.put("fileName", file2Name);
//        				map.put("catagory", file2NameNotSuffix);
//        				int i = 0;
//        				StringBuilder sb = new StringBuilder();
//        				while(str.length - i >= 2){
//        					sb.append(str[i++]);
//        				}
//        				map.put("wordKey", sb);
//        				map.put("baiduUrl", str[str.length-1]);
//        				is++;
//        		}
//        		System.out.println(JsonTool.writeValueAsString(map));
//        		
//        	}
//        }
//        System.out.println(is);
        
        
        
        //transferClient.execute(action, request);
	}
	
	public BulkProcessor initBulkProcessor(Client client) {
		return BulkProcessor
				.builder(client, new BulkProcessor.Listener() {
					@Override
					public void beforeBulk(long executionId, BulkRequest request) {
						System.out.println("beforeBulk");
					}

					@Override
					public void afterBulk(long executionId,
							BulkRequest request, BulkResponse response) {
						System.out.println("afterBulk");
					}

					@Override
					public void afterBulk(long executionId,
							BulkRequest request, Throwable failure) {
						System.out.println("afterBulk");
					}
				})
				.setBulkActions(10000)
				.setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
				.setFlushInterval(TimeValue.timeValueSeconds(5))
				.setConcurrentRequests(1)
				.setBackoffPolicy(
						BackoffPolicy.exponentialBackoff(
								TimeValue.timeValueMillis(100), 3)).build();

	}
}

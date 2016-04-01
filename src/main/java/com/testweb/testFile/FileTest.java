package com.testweb.testFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.tudou.utils.json.JsonTool;

public class FileTest {
	public static void main1(String[] args) {
		File file = new File("D:/wordwiki/地理/阿根廷.txt");
		
		File catalog = new File("D:/wordwiki/地理/");
		for(File file1 : catalog.listFiles()){
			System.out.println(file1.getName());
		}
		System.out.println(file.getAbsolutePath());
		File file2 = new File(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getTotalSpace());
		System.out.println(file2);
		
	}
	public static void main(String[] args) throws IOException {
		File rootFile = new File("D:/wordwiki/");
		int is = 0;
        for(File file1 : rootFile.listFiles()){
        	String file1Name = file1.getName();
        	for(File file2 : file1.listFiles()){
        		String file2Name = file2.getName();
        		String f[] = file2Name.split("\\.");
        		String file2NameNotSuffix =null;
        		if(f.length==2){
        			file2NameNotSuffix = f[0];
        		}else{
        			System.out.println("~@!!~!~!~!~!~!file is wrong file2Name ="+file2Name +" f.length="+f.length);
        		}
        		
        		FileReader fileReader = new FileReader(file2);
        		BufferedReader bufferReader = new BufferedReader(fileReader);
        		String s = null;
        		Map<String,Object> map = new HashMap<String,Object>();
        		while((s = bufferReader.readLine()) != null){
        			String[] str = s.split("!");
        				map.put("catalog", file1Name);
        				map.put("fileName", file2Name);
        				map.put("catagory", file2NameNotSuffix);
        				int i = 0;
        				StringBuilder sb = new StringBuilder();
        				while(str.length - i >= 2){
        					sb.append(str[i++]);
        				}
        				map.put("wordKey", sb);
        				map.put("baiduUrl", str[str.length-1]);
        				is++;
        		}
        		System.out.println(JsonTool.writeValueAsString(map));
        		
        	}
        }
        System.out.println(is);
	}
}

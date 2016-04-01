package com.testweb.testHttp;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

	public static void main(String args[]) throws Exception{
		String url = "http://www.baidu.com/";  
        System.out.println("访问地址:" + url);  
        URL serverUrl = new URL(url);  
        HttpURLConnection conn = (HttpURLConnection) serverUrl  
                .openConnection();  
        conn.setRequestMethod("GET");  
        // 必须设置false，否则会自动redirect到Location的地址  
        conn.setInstanceFollowRedirects(false);  

        conn.addRequestProperty("Accept-Charset", "UTF-8;");  
        conn.addRequestProperty("User-Agent",  
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");  
        conn.addRequestProperty("Referer", "http://zuidaima.com/");  
        conn.connect();  
        String location = conn.getHeaderField("Location");  
        System.out.println("String : "+ location);
	}
}

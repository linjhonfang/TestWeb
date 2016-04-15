package com.testweb.testHttp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tudou.utils.json.JsonTool;

public class HttpTest {

	public static void main1(String args[]) throws Exception{
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
	
	
	public static void main(String args[]) throws IOException{
		String url = "http://weibo.com/p/1005051811442322/follow?pids=Pl_Official_HisRelation__65&relate=fans&page=3&ajaxpagelet=1&ajaxpagelet_v6=1&__ref=/p/1005051811442322/follow&_t=FM_146044739218049";  
        System.out.println("访问地址:" + url);  
		URL serverUrl = new URL(url);  
        HttpURLConnection conn = (HttpURLConnection) serverUrl  
                .openConnection();  
        conn.setRequestMethod("GET");  
		
		String str = "\t\t\t\tHost: weibo.com\n\t\t\t\tConnection: keep-alive\n\t\t\t\tPragma: no-cache\n\t\t\t\tCache-Control: no-cache\n\t\t\t\tAccept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n\t\t\t\tUser-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0\n\t\t\t\tDNT: 1\n\t\t\t\tReferer: http://weibo.com/p/1005051811442322/follow?pids=Pl_Official_HisRelation__65&relate=fans&page=5\n\t\t\t\tAccept-Encoding: gzip,deflate,sdch\n\t\t\t\tAccept-Language: zh-CN,zh;q=0.8\n\t\t\t\tCookie: YF-V5-G0=e6f12d86f222067e0079d729f0a701bc; YF-Ugrow-G0=56862bac2f6bf97368b95873bc687eef; login_sid_t=05858d8e1ffb2ed633aa3bff090826e6; _s_tentry=-; Apache=6911761148367.077.1459841416331; SINAGLOBAL=6911761148367.077.1459841416331; ULV=1459841416344:1:1:1:6911761148367.077.1459841416331:; un=919658703@qq.com; YF-Page-G0=074bd03ae4e08433ef66c71c2777fd84; WBStore=8b23cf4ec60a636c|undefined; wb_publish_vip_2239216501=5; SUS=SID-2239216501-1460435016-GZ-shx3m-da5416c912c87e0a86e634452aaf5a86; SUE=es%3Dc0d49d4fb62ff9ca7250484db15daa8b%26ev%3Dv1%26es2%3D2dbcf7d0912fa1013755b5a7fc023a3d%26rs0%3DJWsZ4dxk7f3Yc7T%252FW9lwqYWKbgtcdI1G%252B5HwH0wraKaCtNJEXdgatH0pBpRFsssW5IajNfREIrX3cc5nlo2qjPHMR58rZRo5L4WrmNwSsttHv6jTPAvt7%252BmI%252BnzwJti5Fy%252FW4d76mFAOhUb8hkkhelWCKU9NuUVgBGWah%252FGHdys%253D%26rv%3D0; SUP=cv%3D1%26bt%3D1460435016%26et%3D1460521416%26d%3Dc909%26i%3D5a86%26us%3D1%26vf%3D0%26vt%3D0%26ac%3D0%26st%3D0%26uid%3D2239216501%26name%3D919658703%2540qq.com%26nick%3DXchaos8%26fmp%3D%26lcp%3D; SUB=_2A256CAgYDeRxGeRM6FsT8SjJyz2IHXVZfH7QrDV8PUNbvtBeLWGjkW9LHeubYA17UrTx_hdgODe05e1XTZVMWQ..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WhT8Hi-5ra7iDxHHc4eEp8e5JpX5KMt; SUHB=0TPUOd0D8r8k7z; ALF=1491971015; SSOLoginState=1460435016; UOR=,,login.sina.com.cn; wvr=6\n";
		Map<String, Object> map = new HashMap<String, Object>();
		String[] s = str.split("\n");
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
			String[] strings = s[i].split(":");
			//if(strings.length!=2)System.out.println("error:"+JsonTool.writeValueAsString(strings));
			StringBuilder sb = new StringBuilder();
			int j=0;
			while(strings.length-j>= 2){
				if(j!=0)sb.append(":");
				sb.append(StringUtils.trim(strings[j++]));
			}
			conn.addRequestProperty(sb.toString(), StringUtils.trim(strings[1]));
			map.put(sb.toString(), StringUtils.trim(strings[1]));
		}
		//System.out.println("Json="+JsonTool.writeValueAsString(map));
		conn.connect();  
        String location = conn.getHeaderField("Location");  
        System.out.println("String : "+ location);
	}
	
}

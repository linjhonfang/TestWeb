package com.testweb.testRegex;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main2(String args[]){
		String splitReqString = "uid=923933544/sid=DFS32DSFS.s";  
//		String uid = getMatcher("uid=([\\d]+)", splitReqString);  
//		System.out.println(uid);
		String sid = getMatcher("sid=([0-9a-zA-Z|/.]+)", splitReqString);  
		System.out.println(sid);
		
		splitReqString= "Mozilla/5.0 (iPhone; CPU iPhone OS 9_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13C75 Youku/5.3.1(iOS 9.2; Bridge_SDK;)";
		//splitReqString= "Mozilla/5.0 (Linux; Android 4.4.2; Che2-TL00 Build/HonorChe2-TL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36 Youku/5.4 (Android 4.4.2; Bridge_SDK; GUID 1062af0bad9c9ea18fbb2f4df73ea686;)";
		
		String sid2 = getMatcher("Youku/([0-9|.]+).*?(.*?Bridge_SDK.*?)", splitReqString);  
		System.out.println("d="+sid2);
		String sid3 = getMatcher("Mozilla/([0-9|\\.]+)", splitReqString);  
		System.out.println("d="+sid3);
		
	}
	  
	public static String getMatcher(String regex, String source) {
		String result = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			result = matcher.group(1);// 只取第一组
		}
		return result;
	}
	
	/**
	 * @param version1 非空 版本中只能包含0~9.
	 * @param version2 非空 版本中只能包含0~9.
	 * @return version1> 2 return true
	 * @return version1> 2 return false
	 * 			null 数据有错误
	 */
	public static Boolean compareVersion(String version1,String version2){
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		if(ver1!=null&&ver2!=null){
			int length = ver1.length>ver2.length?ver2.length:ver1.length;
			for(int i=0;i<length;i++){
				String ver1Str = ver1[i];
				String ver2Str = ver2[i];
				if(StringUtils.isNumeric(ver1Str)&&StringUtils.isNumeric(ver2Str)){
					Integer ver1Num = Integer.valueOf(ver1Str);
					Integer ver2Num = Integer.valueOf(ver2Str);
					if(ver1Num>ver2Num){
						return true;
					}else if(ver2Num>ver1Num){
						return false;
					}
				}else{
					return false;
				}
			}
			if(ver1.length>=ver2.length){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public static void main1(String args[]){
		String version1 = "3";
		String version2 = "5";
		System.out.println(compareVersion(version1, version2));
	}
	
	public static void main(String args[]){
		//String itemUrl = "httphttps%3A%2F%2Fitem.taobao.com%2Fitem.htm%3Fid%3D522166121586";
		String itemUrl = "http%3A%2F%2Fitem.taobao.com%2Fitem.htm%3Fid%3D40930830180";
		System.out.println(itemUrl.matches("^(http|https)%3A%2F%2F(.*)$"));
	}
}

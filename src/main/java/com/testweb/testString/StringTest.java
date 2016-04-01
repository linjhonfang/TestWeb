package com.testweb.testString;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;


public class StringTest {
	
	public static void main2(String args[]){
		String text = "std /sdfsdfdd /ssdf";
		String[] te = text.split("\\n+");
		System.out.println(te);
		
	}
	 public static byte[] decryptBASE64(String key) throws Exception {               
	        return (new Base64()).decode(key.getBytes());      
	  } 
	
	public static String decodeVideoId(String vid) throws Exception{
    	Long v = null;
    	if(StringUtils.isNumeric(vid))return vid;
    	vid = vid.substring(1, vid.length());
    	byte[] bys = decryptBASE64(vid);
    	String decode = new String(bys, "UTF-8");
    	if(StringUtils.isNumeric(decode)){
    		v = Long.valueOf(decode);
    		v= v >>(long) 2;
    	}
    	return String.valueOf(v);
    }
    
	public static String decode(String vid) throws Exception{
    	Long v = null;
    	if(StringUtils.isNumeric(vid))return vid;
    	vid = vid.substring(1, vid.length());
    	byte[] bys = decryptBASE64(vid);
    	String decode = new String(bys, "UTF-8");
    	return String.valueOf(decode);
    }
	
	
    public static void main(String args[]) throws Exception{
//    	var videoId = '126230065';
//    	var videoId2= 'XNTA0OTIwMjYw';http://p4.music.126.net/NlFNJWDldoaCPIEvb5mhUQ==/1385384653520729.jpg
    	System.out.println(decodeVideoId("VODQ2OTI1NDA4"));
    	System.out.println(decode("NlFNJWDldoaCPIEvb5mhUQ=="));
    }
    
    public static String decodeUserCode(String uCode) throws Exception {
    	Long v = null;
		if (StringUtils.isNumeric(uCode))
			return uCode;
		if(StringUtils.isBlank(uCode)){
			return null;
		}
		uCode = uCode.substring(1, uCode.length());
		byte[] bys = decryptBASE64(uCode);
		String decode = new String(bys, "UTF-8");
		if (StringUtils.isNumeric(decode)) {
			v = Long.valueOf(decode);
			v = v >> 2L;
		}
    	return String.valueOf(v);
    }
    
    public static void main4(String args[]) throws Exception{
    	//String userId = decodeUserCode("UMTMyNjc0NDc4NA");
    	String userId = decodeUserCode("UOTM3MTk0NA");
    	System.out.println(encodeUserId("141103004"));
    	System.out.println(userId);
    }
    
    public static String encryptBASE64(byte[] key) throws Exception {               
        return new String((new Base64()).encode(key));               
    }
    
    public static String encodeUserId(String uid) throws Exception {
    	Long uidl = Long.valueOf(uid);
    	uidl = uidl << 2L;
    	String uids = uidl.toString(); 
    	String ucode = "U"+encryptBASE64(uids.getBytes("UTF-8"));
    	
    	return ucode;
    }

    public static void main5(String args[]) throws Exception{
    	Double get_double1 = 234d;
        Double get_double = Double.parseDouble(String.format("%.2f",get_double1));
        System.out.println(get_double);
        double d = 134324;
        double d1 = (d*1000);
        
        d=((int)(d*100))/100d;
        System.out.println(d);
        
        //System.out.println(new Double());
    }
    
    public static void main8(String args[]) throws Exception{
    	//String userId = encodeUserId("2342986");
    	String userId = (String)null;
    	Long e = new Long(1);
    	Long nu = null;
    	//String str2 = (String)nu;
    	//String str = Long.toString(nu);
    	//System.out.println(str);
    }
    
    public static void main1(String args[]){
    	String us = "我dfa";
    	System.out.println(us.equalsIgnoreCase("dfa"));
    	System.out.println(us.startsWith("dfa",1));
    }
    
    public static void main11(String args[]){
    	String url = "http://www.baidu.com/atr.action?str=sdf?sdf&t=";
    	System.out.println(url.contains("?"));
    	
    	String[] urlArray = url.split("\\?",2);	
    	for(String str : urlArray){
    		System.out.println("urlArray:"+str);
    	}
    }
    
    
    /**根据 特殊符号= 判断urlEncode 编码 次数 最多支持两次
	 * @param ybhpss
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getYbhpssEncode(String ybhpss)
			throws UnsupportedEncodingException {
		if (StringUtils.isNotBlank(ybhpss)) {
			// 此处有坑（不得不挖）统计参数不影响主业务
			boolean isDoubleEncode = ybhpss.contains("%253D");// %253D 为两次编码的=
																// “等号”
																// page其中必传的参数
			boolean isSingleEncode = ybhpss.contains("%3D");// %3D 为一次编码= “等号”
															// page其中必传的参数
			// !(isApple&&isDoubleEncode) 苹果平台 并且两次编码 就不要在编码一次
			if (isDoubleEncode) {
				ybhpss = URLDecoder.decode(ybhpss, "UTF-8");
				ybhpss = URLDecoder.decode(ybhpss, "UTF-8");
			}
			if (isSingleEncode) {
				ybhpss = URLDecoder.decode(ybhpss, "UTF-8");
			}
			if (ybhpss.contains("=")) {
				byte[] bytes = Base64.encodeBase64(ybhpss.getBytes());
				ybhpss = new String(bytes, "UTF-8");
				ybhpss = URLEncoder.encode(ybhpss, "UTF-8");
			} else {
			}
		}
		return ybhpss;
	}
	
//	public static void main(String args[]){
//		
//	}
}


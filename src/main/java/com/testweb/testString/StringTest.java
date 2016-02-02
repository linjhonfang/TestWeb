package com.testweb.testString;

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
    
    public static void main4(String args[]) throws Exception{
//    	var videoId = '126230065';
//    	var videoId2= 'XNTA0OTIwMjYw';
    	System.out.println(decodeVideoId("XNTA0OTIwMjYw"));
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
    
    public static void main(String args[]) throws Exception{
    	//String userId = decodeUserCode("UMTMyNjc0NDc4NA");
    	String userId = decodeUserCode("UOTM3MTk0NA");
    	System.out.println(encodeUserId("331172299"));
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
}


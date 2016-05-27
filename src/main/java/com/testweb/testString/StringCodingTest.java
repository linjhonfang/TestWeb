package com.testweb.testString;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;


public class StringCodingTest {
	
	
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
    
    
    public static void main(String args[]) throws Exception{
    	//String userId = decodeUserCode("UMTMyNjc0NDc4NA");
    	System.out.println(encodeId("816762994"));
    	//System.out.println(userId);
    }
    
    public static String encryptBASE64(byte[] key) throws Exception {               
        return new String((new Base64()).encode(key));               
    }
    
    public static String encodeId(String uid) throws Exception {
    	Long uidl = Long.valueOf(uid);
    	uidl = uidl << 2L;
    	String uids = uidl.toString(); 
    	String ucode = "U"+encryptBASE64(uids.getBytes("UTF-8"));
    	return ucode;
    }

   public static void main3(String[] args) {
	   Object o = null;
	   String str = (String)o;
	   System.out.println(str==null);
   }
}


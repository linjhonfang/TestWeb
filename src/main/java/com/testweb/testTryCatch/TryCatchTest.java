package com.testweb.testTryCatch;


public class TryCatchTest {
	
	public static void main(String args[]){
		try{
			new TryCatchTest().test();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void test() throws TestException{
		
		int i = 0;
		Integer j = null;
		i = j;
			
		throw new TestException();
	}
	
}
class TestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
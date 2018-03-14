package com.testweb.testTryCatch;


public class TryCatchTest {

	public static void main(String args[]){
		try{
			new TryCatchTest().test();
		}catch(TestException e){
			System.out.println(e.code);
			e.printStackTrace();
		}catch(Exception e){
			System.out.println("exception");
			if(e instanceof TestException){
				System.out.println(((TestException) e).code);
			}
			e.printStackTrace();
		}
	}



	public void test() throws Exception{

		int i = 0;
		Integer j = null;
		i = j;

		Exception testException = new TestException();
		throw testException;
	}

}

package com.testweb.testTryCatch;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/6/21 上午11:56
 */

public class ExceptionParentTest {

    public static void main(String args[]){
        try{
            new ExceptionParentTest().test();
        }catch(TestException e){
            System.out.println("TestException");
            System.out.println(e.code);
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception");
            if(e instanceof TestException){
                System.out.println(((TestException) e).code);
            }
            e.printStackTrace();
        }
    }



    public void test() throws TestException,Exception{

        Exception exception = new TestException();

        throw new TestException();
    }

}

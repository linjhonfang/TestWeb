package com.testweb.testPatterns;

/**
 * Created by xingxuechao on 6/12/16.
 */
public class SinglePattern {
    public volatile static SinglePattern sp = null; // valatile 针对指令重排

    public static SinglePattern getInstance(){
        if(sp == null){
            sp = new SinglePattern();
        }
        return sp;
    }

    public static SinglePattern getInstanceSafe(){
        if(sp == null){
            synchronized (SinglePattern.class){
                if(sp == null){
                    sp = new SinglePattern();
                }
            }
        }
        return sp;
    }

    public static class singleInnerClass{
        public static final SinglePattern sp = new SinglePattern();
    }

    public static SinglePattern getInstanceStatic(){
        return sp;
    }

}

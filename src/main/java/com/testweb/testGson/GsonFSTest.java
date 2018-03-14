package com.testweb.testGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/6/28 上午10:32
 */
public class GsonFSTest {

    public static void main(String args[]){

        Father father = new Son("nick","name");
        Gson gson = new GsonBuilder().create();
        String str = gson.toJson(father);
        System.out.println(str);
        Father father1 = gson.fromJson(str,Father.class);
        System.out.println(father1.name);
    }

}
class Father{
    String name;
    Father(String name){
        this.name = name;
    }
    Father(){}
}
class Son extends Father{
    String nick;
    String name;
    Son(String nick,String name){
        super();
        this.name = name;
        this.nick = nick;
    }
}

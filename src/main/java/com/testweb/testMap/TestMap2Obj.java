package com.testweb.testMap;

import com.alibaba.fastjson.JSON;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/1/13 上午10:52
 */
public class TestMap2Obj {

    /**
     * 结论：map转换成对象，通过fastjson转换，性能比java.bean去获取，要低三倍左右
     *                    json.bean 性能又比原生的java reflect 低 2到3倍*/
    public static void main(String args[]) throws Exception {
        String str ="{\"xing\":\"x\",\"xue\":\"x\",\"chao\":\"c\"}";
        Map<String, String> map = new HashMap<String, String>();
        map.put("xing","x");
        map.put("xue","x");
        map.put("chao","c");
        map.put("father","f");
        int count = 10000;
        Bean bean = null;
        /**java.bean去获取*/
        long start = System.currentTimeMillis();
        for(int i=0; i < count; i++){
            bean = (Bean) BeanToMapUtil.convertMap(Bean.class, map);
            //System.out.println(bean);
        }
        long end = System.currentTimeMillis();
        System.out.println("java bean waste time ＝ "+ (end-start));
        /**java reflect*/
        start = System.currentTimeMillis();
        for(int i=0; i < count; i++){
            bean = (Bean) ReflectBeanUtils.mapToObject(map, Bean.class);
            //System.out.println(bean);
        }
        end = System.currentTimeMillis();
        System.out.println("reflect waste time ＝ "+ (end-start));
        /**fastjson转换*/
        start = System.currentTimeMillis();
        for(int i=0; i < count; i++){
            bean = TestMap2Obj.getBean(map);
            //System.out.println(bean);
        }
        end = System.currentTimeMillis();
        System.out.println("fastJson waste time ＝ "+ (end-start));

    }

    public static Bean getBean(Map<String, String> paramMap){
        String re = JSON.toJSONString(paramMap);
        Bean sea = JSON.parseObject(re, Bean.class);
        return sea;
    }

}
class fatherBean {
    private String father;

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }
}
class Bean extends fatherBean{
    private String xing;
    private String xue;
    private String chao;

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
    }

    public String getXue() {
        return xue;
    }

    public void setXue(String xue) {
        this.xue = xue;
    }

    public String getChao() {
        return chao;
    }

    public void setChao(String chao) {
        this.chao = chao;
    }
}



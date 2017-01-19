package com.testweb.testMap;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/1/13 ����11:35
 */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ʹ��reflect����ת��
 * getDeclaredFields()���ȡ�������ԣ���Ҫ���˲���Ҫ�������� static final
 * �����ȡ��������ԣ���Ҫ�Լ�����ʵ��
 * ��ʱ��Introspector��ȣ�1:100
 */
public class ReflectBeanUtils{

    public static Object mapToObject(Map<String, String> map, Class<?> beanClass) throws Exception {
        if (map == null || map.size()<=0)
            return null;

        Object obj = beanClass.newInstance();
        //��ȡ�����������࣬�����Լ����и���
        boolean ret = true;
        Class oo = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        while(ret){
            clazzs.add(oo);
            oo = oo.getSuperclass();
            if(oo == null || oo == Object.class)break;
        }

        for(int i=0;i<clazzs.size();i++){
            Field[] fields = clazzs.get(i).getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                //���ַ���ת���ض����Ӧ������
                if (field != null) {
                    field.setAccessible(true);
                    field.set(obj, map.get(field.getName()));
                }
            }
        }
        return obj;
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }
        //��ȡ�����������࣬�����Լ����и���
        boolean ret = true;
        Class oo = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        while(ret){
            clazzs.add(oo);
            oo = oo.getSuperclass();
            if(oo == null || oo == Object.class)break;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        for(int i=0;i<clazzs.size();i++){
            Field[] declaredFields = clazzs.get(i).getDeclaredFields();
            for (Field field : declaredFields) {
                int mod = field.getModifiers();
                //���� static �� final ����
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        }

        return map;
    }
}
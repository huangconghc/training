package com.demo2;

import java.util.LinkedHashMap;
import java.util.Set;

/*
 * LinkedHashMapDemo：是Map接口的哈希表和链表列表实现的，具有可预知的迭代顺序
 */
public class LinkedHashMapDemo {
    public static void main(String[] args){
        LinkedHashMap<String,String> hm = new LinkedHashMap<String,String>();

        hm.put("1234", "hello");
        hm.put("2345", "java");
        hm.put("3456", "world");
        hm.put("1234", "hello");
        hm.put("2345", "java");

        Set<String> set = hm.keySet();
        for(String st : set){
            String values = hm.get(st);
            System.out.println(values + "----" + st);
        }

    }

}

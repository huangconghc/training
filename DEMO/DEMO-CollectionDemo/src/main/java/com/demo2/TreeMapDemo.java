package com.demo2;


import java.util.Set;
import java.util.TreeMap;

/*
 * TreeMao：是基于红黑树的Map集合的接口实现
 */
public class TreeMapDemo {
    public static void main(String[] args){
        TreeMap<String,String> tm = new TreeMap<String,String>();

        tm.put("1234", "hello");
        tm.put("2345", "java");
        tm.put("3456", "world");
        tm.put("1234", "helloe");
        tm.put("2345", "javar");

        Set<String> set = tm.keySet();
        for(String st : set){
            String values = tm.get(st);
            System.out.println(values + "----" + st);
        }

    }

}

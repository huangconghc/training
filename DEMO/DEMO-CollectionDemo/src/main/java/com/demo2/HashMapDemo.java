package com.demo2;

import java.util.HashMap;
import java.util.Set;

/*
 * HashMap:是基于哈希表的map接口实现
 * 哈希表的作用是用来保证键的唯一性的
 *
 * HashMap<String,String>
 * 键：String
 * 值：String
 *
 *
 *
 * Hashtable和HashMap的区别？
 * Hashtable:线程安全，效率低，不允许null键和null值
 * HashMap:线程不安全，效率高，允许null键和null值
 *
 *
 */
public class HashMapDemo {
    public static void main(String[] args){
        HashMap<String,String> hm = new HashMap<String,String>();

        hm.put("001", "琅琊榜");
        hm.put("002", "伪装者");
        hm.put("003", "仙剑奇侠传");
        hm.put("004", "风中奇缘");
        hm.put("001", "猎场");
        hm.put("002", "琅琊榜");
        hm.put("001", "猎场");

        Set<String> set = hm.keySet();
        for(String s : set){
            String values =hm.get(s);
            System.out.println(values);
        }


    }

}

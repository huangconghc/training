package com.demo2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map集合的特点
 * 	将键映射到值的对象，一个映射不能包含多个重复的键，每个键最多只能映射到一个值
 * Map集合与Collection集合的区别
 * 	Map集合存储元素是成对出现的，Map集合的键是唯一的，值却是可以重复的
 * Collection集合存储元素是单独出现的
 *
 *
 * 注意：
 * Map集合的数据结构只针对键有效，跟值无效
 * Collection集合的数据结构是针对元素有效
 *
 * Map集合的功能概述：
 * 1.添加功能
 *		 V put(K key,V value);添加元素，
 *       如果键是第一次存储，就直接存储元素，返回null
 *       如果键不是第一次存在，就用值把以前的值替换，返回以前的值
 * 2.删除功能
 * 		void clear():移除所有的键值对元素
 * 		V remove(Object key);根据删除键值对元素，并把值返回
 * 3.判断功能
 * boolean containsKey(Object key):判断集合是否包含指定键
 * boolean containsValue(object value)；判断集合是否包含指定的值
 * boolean isEmpty():判断集合是否为空
 * 4.获取功能
 * Set<Map.Entry<K,V>> entrySet();
 * V get(Object key);根据键获取值
 * Set<K> keySet();获取集合中所有键的集合
 * Collection<V> value();获取集合中所有中值的集合
 * 5.长度功能
 * int size();返回集合中的键值对的对数
 *
 */
public class MapDemo {
    public static void main(String[] args){

        Map<String,String> map = new HashMap<String,String>();

        //添加元素
        //System.out.println("put:" + map.put("文章","孙俪"));
        //System.out.println("put:" + map.put("文章","金毛狮王"));
        //如果键是第一次存储，就直接存储元素，返回null
        //如果键不是第一次存在，就用值把以前的值替换，返回以前的值
        map.put("胡歌", "琅琊榜");
        map.put("黄晓明", "神雕侠侣");
        map.put("明楼", "伪装者");
        map.put("六爷", "风");

        //删除功能
        //map.clear();

        //V remove(Object key);根据删除键值对元素，并把值返回
        System.out.println("remove:" + map.remove("黄晓明"));


        //boolean containsKey(Object key):判断集合是否包含指定键
        System.out.println("containsKey:" +map.containsKey("胡歌"));

        //boolean containsValue(object value)；判断集合是否包含指定的值
        System.out.println("contaiValue:" +map.containsValue("琅琊榜"));

        //boolean isEmpty():判断集合是否为空
        System.out.println("isEmpty:" + map.isEmpty());

        //int size();返回集合中的键值对的对数
        System.out.println("size:" + map.size());

        System.out.println("map:" +map);

        //V get(Object key);根据键获取值
        System.out.println("get:" +map.get("胡歌"));

        //Set<K(键)> keySet();获取集合中所有键的集合
        Set<String> set = map.keySet();
        for(String key : set){
            System.out.println(key);
        }

        //Collection<V> value();获取集合中所有中值的集合
        Collection<String> con = map.values();
        for(String value : con){
            System.out.println(value);
        }
    }
}
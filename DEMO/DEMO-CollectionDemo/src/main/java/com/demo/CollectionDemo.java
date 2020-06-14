package com.demo;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合的由来：
 * 		我们学习的是面向对象语言，而面向对象语言对事物的描述是通过对象实现的，为了方便实现对多个对象进行操作
 * 我们就必须把多个对象进行存储，而想要存储多个对象，就不能是一个基本的变量。需要容器，我们学过的有数组和StringBuffer
 * 可以当容器，但是StringBuffer的结果是字符串，不一定满足我们的要求，数组（对象数组）又不能适应变化的需求，
 * 因为数组长度是固定的，这个时候java就提供了集合类来使用
 *
 *
 * 数组和集合的区别：
 * 		A长度区别
 * 			数组的固定
 * 			集合的可变
 * 		B内容不同
 * 			数组存储的是同一类元素
 * 			而集合可以存储不同类元素
 * 		C元素的类型问题
 * 			数组可以存储基本类型，也可以存储引用类型
 * 			集合只能存储引用类型
 *
 * Collection:是集合的顶层接口，它的子体系有重复的，有唯一的，有有序的，有无序的
 *
 * Collection的功能概述：
 * 1.添加功能：
 * 		boolean add(Object obj)：添加一个元素
 *      boolean addAll(Collection c)：添加一个集合元素
 * 2.删除功能
 *     void clear():移除所有元素
 *     boolean remove(Object o):移除一个元素
 *     boolean removeAll(Collection c):移除一个集合的元素
 * 3.判断功能
 * 		boolean contains(Object o):判断集合中 是否包含指定元素
 * 		boolean contaunsAll(Collection c);判断集合中是否包含指定的集合元素
 *      boolean isEmply();判断集合是否为空
 * 4.获取功能
 *      Iterator<E> iterator()(重)
 * 5.长度功能
 *      int size():元素个数
 * 6.交集功能
 *    boolean retainAll(Collection c):两个集合都有的元素
 *   7.把集合转换为数组
 *   Object[] toArray()
 *
 */

public class CollectionDemo {
	public static void main(String[] args) {

		//创建对象
		Collection c = new ArrayList();

		//boolean add(Object obj)：添加一个元素
		c.add("hello");
		c.add("world");
		c.add("java");


		//void clear():移除所有元素
		c.clear();

		//boolean remove(Object o):移除一个元素
		//System.out.println(c.remove("hello"));


		//boolean contains(Object o):判断集合中 是否包含指定元素
		System.out.println(c.contains("hello"));

		//boolean isEmply();判断集合是否为空
		System.out.println(c.isEmpty());

		// int size():元素个数
		System.out.println(c.size());


		System.out.println(c);
	}



}

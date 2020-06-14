package com.demo;

import java.util.LinkedList;


/*
 * LinkedList的特有功能:
 * A:添加功能:
 * 		public void addFirst(object e)
 * 		public void addLast(object e)
 * B:获取功能：
 * 		public object getFirst()
 * 		public object getLast()
 * C:删除功能：
 * 		public object removeFirst()
 * 		public object removeLast()
 *
 */
public class LinkedListDemo {
	public static void main(String[] args){
		//创建集合对象
		LinkedList link = new LinkedList();

		//添加元素
		link.add("hello");
		link.add("world");
		link.add("java");


		link.addFirst("javaee");
		link.addLast("android");


		//System.out.println(link.removeFirst());
		//System.out.println(link.removeLast());
		//System.out.println(link.getLast());
		//System.out.println(link.getFirst());
		System.out.println("link:" +link);




	}

}

package com.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*
 * List集合的特点：
 * 	有序(存储和取出的顺序一致)，可重复
 */
public class ListDemo {
	public static void main(String[] args) {

		List list = new ArrayList();

		list.add("hello");
		list.add("world");
		list.add("java");
		list.add("javaee");
		list.add("andorid");
		list.add("javaee");
		list.add("android");

		Iterator it = list.iterator();//获取Iterator接口的实现类对象
		//如果下一元素不为空就进入执行下一步
		while(it.hasNext()){
			//获取下一个元素
			String s =(String)it.next();
			System.out.println(s);
		}
	}



}

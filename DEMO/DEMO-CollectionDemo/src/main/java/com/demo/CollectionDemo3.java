package com.demo;

import java.util.ArrayList;
import java.util.Collection;


public class CollectionDemo3 {
	public static void main(String[] args) {

		Collection c = new ArrayList();

		//添加元素
		c.add("hello");
		c.add("world");
		c.add("java");

		//遍历
		Object[] objs = c.toArray();
		for(int x = 0; x < objs.length;x++){
			//System.out.println(objs[x]);
			//下面的实现不了元素的长度是多少，原因是Object中没有length（）方法
			//要用length（）方法的话就得转化为字符串
			//System.out.println(objs[x]);

			//向下转型
			String s =(String)  objs[x];
			System.out.println(s.length() + "----" + objs[x]);
		}
	}



}

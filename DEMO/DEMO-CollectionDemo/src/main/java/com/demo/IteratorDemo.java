package com.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/*
 * Iterator iterator():迭代器，集合专用的遍历方式
 *    Object next():获取元素，并移动到下一个位置。
 *    java.util.NoSuchElementException：没有这样的元素，因为你已经访问到最后一个了
 *
 *    boolean hasNext():如果仍有元素可以迭代，则返回true
 */
public class IteratorDemo {
	public static void main(String[] args) {

		//创建集合对象
		Collection c = new ArrayList();
		//List list = new ArrayList();

		//创建并添加元素
		//String s ="hello";
		//c.add(s);
		c.add("hello");//list.add("hello");
		c.add("world");
		c.add("java");

		Iterator it = c.iterator();//实际返回的肯定是子类的对象，这里是多态.获取Iterator接口的实现类对象

		//Object obj = it.next();//获取下一个元素
		//System.out.println(obj);

		/*System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());超过了长度，最后一个为java
	*/

	/*	if(it.hasNext()){
			System.out.println(it.next());
		}

		if(it.hasNext()){
			System.out.println(it.next());
		}

		if(it.hasNext()){
			System.out.println(it.next());
		}
		这样就不会出问题了
		if(it.hasNext()){
			System.out.println(it.next());
		}
		*/

		while(it.hasNext()){
			String s =(String) it.next();
			System.out.println(s);
		}
	}



}

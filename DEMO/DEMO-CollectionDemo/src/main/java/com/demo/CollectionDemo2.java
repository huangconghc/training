package com.demo;

import java.util.ArrayList;
import java.util.Collection;


public class CollectionDemo2 {
	public static void main(String[] args) {

		Collection c1= new ArrayList();
		c1.add("abc1");
		c1.add("abc2");
		c1.add("abc3");
		c1.add("abc4");

		Collection c2 = new ArrayList();
		c2.add("abc4");
		c2.add("abc5");
		c2.add("abc6");
		c2.add("abc7");

		//boolean addAll(Collection c)：添加一个集合元素
		//System.out.println("addAll:" +c1.addAll(c2));

		//boolean removeAll(Collection c):移除一个集合的元素
		//只要一个元素被移除了，就返回true
		//System.out.println(c1.removeAll(c2));

		//boolean contaunsAll(Collection c);判断集合中是否包含指定的集合元素
		//只有包含所有的元素才叫包含。才有true
		System.out.println(c1.containsAll(c2));

		//boolean retainAll(Collection c):两个集合都有的元素
		//假设两个集合A，B
		//A对B做交集，最终的结果保存在A中，B不变
		//返回值表示的是A是否改变过。
		System.out.println(c1.retainAll(c2));

		System.out.println(c1);
		System.out.println(c2);

	}



}

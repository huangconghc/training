package com.demo;

import java.util.Enumeration;
import java.util.Vector;


/*
 * Vector的特有功能
 * 1.添加功能
 * public void addElement(Object obj)        --add()
 *
 * 2.获取功能
 * public Object elementAt(int index)         --get()
 * public Enumeration elementAt()             --Iterator iterator()
 * 				boolean hasMoreElements()     --hasNext()
 * 				Object nextElement()          --Next()
 *
 */
public class VectorDemo {
	public static void main(String[] args){
		Vector v = new Vector();

		v.add("hello");
		v.add("world");
		v.add("java");

		for(int x = 0 ; x < v.size(); x++){
			String s = (String)v.elementAt(x);
			System.out.println(s);
		}

		Enumeration en = v.elements();
		while(en.hasMoreElements()){
			String s = (String)en.nextElement();
			System.out.println(s);
		}
	}

}

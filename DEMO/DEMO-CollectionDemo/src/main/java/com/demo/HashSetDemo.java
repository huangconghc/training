package com.demo;

import com.demo.pojo.Students;

import java.util.HashSet;

/*
 * 存储自定义对象，并保证元素的唯一性
 *
 *
 */
public class HashSetDemo {
    public static void main(String[] args){
        HashSet<Students> hs = new HashSet<Students>();

        Students s1 = new Students("独孤求败",21);
        Students s2 = new Students("风清扬",22);
        Students s3 = new Students("任盈盈",23);
        Students s4 = new Students("少林",24);
        Students s5 = new Students("任盈盈",23);
        Students s6 = new Students("任盈盈",22);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s5);
        hs.add(s6);

        for(Students s : hs){
            System.out.println(s);
        }
    }

}

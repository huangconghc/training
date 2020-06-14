package com.date.demo;

/*
构造方法：
public SimpleDateFormat（）：构造一个SimpleDateFormat，使用默认模式和日期格式
public SimpleDateFormat（String pattern）：构造一个SimpleDateFormat使用给定的模式和默认的日期格式

 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        /*格式化：从date到String
        *public final String format(Date date);
        * 将日期格式化成日期/时间字符串
         */
        SimpleDateFormat sdf = new SimpleDateFormat();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(date);

        System.out.println(s);
    }
}

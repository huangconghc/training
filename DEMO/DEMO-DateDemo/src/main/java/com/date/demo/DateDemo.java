package com.date.demo;

import java.util.Calendar;

public class DateDemo {
    public static void main(String[] args) {
        //获取日历类对象
        Calendar calendar = Calendar.getInstance();
        //public int get (int field);返回给定日历字段的值

        int hour =calendar.get(Calendar.HOUR_OF_DAY);
        int date =calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);


        System.out.println(year + "年" + month + "月" + date + "日" + hour + "小时" );

        System.out.println("-----------------------");
        //public abstract void add(int field,int amount);根据日历的规则，将指定的时间量添加或减去给定的日历字段
        calendar.add(Calendar.HOUR_OF_DAY,+1);
        calendar.add(Calendar.DATE,+1);
        calendar.add(Calendar.MONTH,+1);
        calendar.add(Calendar.YEAR,+1);

        int hour_1 =calendar.get(Calendar.HOUR_OF_DAY);
        int date_1 =calendar.get(Calendar.DATE);
        int month_1 = calendar.get(Calendar.MONTH)+1;
        int year_1 = calendar.get(Calendar.YEAR);

        System.out.println(year_1 + "年" + month_1 + "月" + date_1  + "日" +hour_1 + "小时");

        System.out.println("-----------------------");


        calendar.add(Calendar.HOUR_OF_DAY,-1);
        calendar.add(Calendar.DATE,-1);
        calendar.add(Calendar.MONTH,-1);
        calendar.add(Calendar.YEAR,-1);

        int hour_2 =calendar.get(Calendar.HOUR_OF_DAY);
        int date_2 =calendar.get(Calendar.DATE);
        int month_2 = calendar.get(Calendar.MONTH)+1;
        int year_2 = calendar.get(Calendar.YEAR);

        System.out.println(year_2 + "年" + month_2 + "月" + date_2  + "日" +hour_2 + "小时");




    }
}

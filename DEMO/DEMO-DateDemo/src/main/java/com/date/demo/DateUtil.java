package com.date.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

   public static void stringToDate(String s) throws ParseException {
        //将
       //SimpleDateFormat dateToStringAndSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
       //String str =  dateToStringAndSimpleDateFormat.format(s);
       SimpleDateFormat stringToDateAndSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

           Date date = stringToDateAndSimpleDateFormat.parse(s);

       Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);

       int year = calendar.get(Calendar.YEAR);					//获取年份
       int month = calendar.get(Calendar.MONTH)+1;				//获取月份
       int dates = calendar.get(Calendar.DATE);                 //获取日期

       String quarter="";
       if(month >= 1 && month <= 3 ){
           quarter="1";
       }
       if(month >= 4 && month<= 6 ){
           quarter="2";
       }
       if(month >= 7 && month <= 9 ){
           quarter="3";
       }
       if(month >= 10 && month <= 12 ){
           quarter="4";
       }


       String[] arr={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
       String week = arr[calendar.get(Calendar.DAY_OF_WEEK) -1];

       int day = calendar.get(Calendar.DAY_OF_YEAR);

       System.out.println(year + "年" + month + "月" + dates + "日" + "第" + quarter +"季度" + week + "一年中第" + day+"天");
   }


}

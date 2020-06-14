package com.date.demo;

import java.text.ParseException;
import java.util.Date;

public class DateUtilDemo {
    public static void main(String[] args) {
        String s2 = "2018-04-01";
        try {
            DateUtil.stringToDate(s2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

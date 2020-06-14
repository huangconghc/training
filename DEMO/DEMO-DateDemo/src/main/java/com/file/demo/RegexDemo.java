package com.file.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String address1 = "中华人民共和国吉林省长春市二道区临河街万兴小区4栋2门";
        String address2 ="中华人民共和国河北省石家庄市武林区砂石街河东小区8栋1单元";

        addressResolution(address1);
        System.out.println("---------------------");
        addressResolution(address2);

    }


    public static void addressResolution(String address){
        //定义规则
        String regex="(?<country>[^国]+国)(?<province>[^省]+省)(?<city>[^市]+市)?(?<town>[^区]+区)?(?<village>[^街]+街)?(?<home>.*)";

        /*
        pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，
        你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
         */
        Pattern pattern = Pattern.compile(regex);

        /*
        Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，
        Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
         */
        Matcher matcher =pattern.matcher(address);
        while(matcher.find()){
            System.out.println(matcher.group("country"));

            System.out.println(matcher.group("province"));

            System.out.println(matcher.group("city"));

            //System.out.println(matcher.group("county"));

            System.out.println(matcher.group("town"));

            System.out.println(matcher.group("village"));

            System.out.println(matcher.group("home"));

        }

    }
}

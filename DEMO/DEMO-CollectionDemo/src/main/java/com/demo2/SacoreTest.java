package com.demo2;

import java.util.Scanner;

public class SacoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩");
        int score = scanner.nextInt();

        Teacher teacher = new Teacher();

        try {
            teacher.checkScore(score);
        } catch (ScoreException e) {
            e.printStackTrace();
        }

    }

}

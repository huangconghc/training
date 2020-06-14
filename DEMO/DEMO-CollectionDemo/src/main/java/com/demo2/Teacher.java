package com.demo2;

public class Teacher {
    public void checkScore(int score) throws ScoreException {
        if(score<0 || score >100){
            throw new ScoreException("输入有误");
        }
    }
}

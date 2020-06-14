package com.demo.pojo;


public class Student {
    private String name;
    private int chinese;
    private int math;
    private int English;

    public Student(){
        super();
    }

    public Student(String name,int chinese , int matn,int Engilsh ){
        this.name=name;
        this.chinese= chinese;
        this.math=math;
        this.English=English;

    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getChinese(){
        return chinese;
    }
    public void setChinese(int chinese){
        this.chinese= chinese;
    }

    public int  getMath(){
        return math;
    }
    public void setMath(int math){
        this.math=math;
    }

    public int getEnglish(){
        return English;
    }
    public void setEnglish(int English){
        this.English=English;
    }

    public int getSum(){
        return this.chinese + this.math + this.English;
    }

    public String toString(){
        return "姓名：" + name +"\t" + "语文成绩:" + chinese + "\t" +"数学：" +math +"\t" +"英语成绩:" + English;
    }

}


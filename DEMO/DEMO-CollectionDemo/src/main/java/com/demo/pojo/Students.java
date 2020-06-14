package com.demo.pojo;

public class Students {
    private String name;
    private int age;
    public Students(){
        super();
    }

    public Students(String name, int age){
        super();
        this.name=name;
        this.age=age;
    }

    public String getName(){
        return name;
    }

    public void getName(String name){
        this.name= name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Students other = (Students) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }



    /*
    public int hashCode(){
        return 0;为了使它们的hash码相同，好比较成员变量
        但是这样比较，如果有一千个的话，那么第一千个也要一个一个的从第一个开始比较
        这样的话效率就比较低所以就得改善这个方法



         * 因为成员变量影响了哈希值，所以我们把成员变量值相加即可
         * return this.name.hashCode() + this.age();
         * 看下面
         * s1:name.hashCode() = 40, age = 30;
         * s2:name.hashCode() =  20,age = 50;
         * 这样他们相加总数是相等的，但是里面的分开的就不相等了，
         * 为了尽可能的区分，我们可以把它们乘以一些整数

        return this.name.hashCode() + this.age *15;

    }

    public boolean equals(Object obj) {
        if (this == obj){  tigaoxiaolv
            return true;
         }
        if(!(obj instanceof Student)){如果不是学生对象就就不需要参与比较，没有可比性
            return false;
        }
        Student s = (Student) obj;转成学生对象
        return this.name.equals(s.name) && this.age == s.age;

    }
    */
    public String toString(){
        return "姓名：" + name + ",年龄：" +age;
    }

}

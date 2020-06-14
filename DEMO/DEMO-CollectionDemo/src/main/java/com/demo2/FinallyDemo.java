package com.demo2;


/*
 * 如果catch里面有return语句，finally里面的代码还会执行
 * 在return前执行，
 *
 */
public class FinallyDemo {
    public static void main(String[] args){
        System.out.println(getInt());
    }

    public static int getInt() {

        int a = 10;
        try{
            System.out.println(a/0);
            a = 20;
        }catch(ArithmeticException e){
            a = 30;
            return a;
			/*
			 * return a在程序执行到这一步时，这里不是return a 而是return
			 * 30；这个回路就形成了，但是呢他发现后面还有fanally，所以就继续执行，a
			 * =40；再次回到以前的路径继续return 30
			 *
			 */

        }finally{
            a = 40;
            //return a;如果这样结果就是40了
        }
        return a;
    }

}

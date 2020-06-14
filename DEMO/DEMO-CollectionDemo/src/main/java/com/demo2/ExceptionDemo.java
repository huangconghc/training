package com.demo2;


/*
 * A:一个异常
 * B:两个异常的处理
 * 	a:每一个写一个try...catch
 *  b:写一个try,多个catch
 *  	try{
 *        .......
 *         }catch(异常类名 变量名){
 *         ......
 *         }catch(异常类名 变量名){
 *         ......
 *         }
 *         ......
 *
 *         注意事项：
 *         		1：能够明确的尽量明确，不要用大的来处理。
 *         		2：平级关系的异常谁前谁后无所谓，如果出现父子关系，父必须在后面
 * 注意：一旦try里面出了问题，就会在这里把问题抛出，然后和catch里面的问题进行匹配，
 * 一旦有匹配的，就执行catch里面的处理，然后结束try..catch
 * 继续执行后面的操作
 *
 *
 * JDK7出现了一个新的异常处理方案：
 *   try{
 *
 *   }catch(异常名1 | 异常名2 | ....   变量){
 *   .......
 *   }
 *
 *   注意：这个方法虽然简洁，但是不够好
 *   A：处理方式是一致的。
 *   B：多个异常间必须是同级关系。
 */
public class ExceptionDemo {
    public static void main(String[] args){
        method();
    }

    public static void method() {


        int a = 10;
        int b = 0;
        int[] arr = {1,2,3};

        try{
            System.out.println(a/b);
            System.out.println(arr[3]);
        }catch(ArithmeticException e){
            System.out.println("除数不能为零");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("索引越界");
        }catch(Exception e){
            System.out.println("出问题了");
            //不知道除了什么问题就用这个，万能匹配的。但是能不用尽量不用，而且必须放在最后面，他是父类的父类
        }

		/*
		 *
		 * try{
			System.out.println(a/b);
			System.out.println(arr[3]);
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
			System.out.println("出问题了");
		 * }
		 */

        System.out.println("over");
    }

}

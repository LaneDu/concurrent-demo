package com.concurrent.demo1;

import java.util.Arrays;
import java.util.List;

/**
 * @author lane
 * @date 2021年05月19日 下午4:37
 */
public class SynchornizedDemo {
    public static final Object obj = new Object();

    //method1 = 2
    //method3 = 4
    //synchronized关键字“给某个实例对象加锁”，示例代码：
    public void  method1(){
        synchronized (this){
            System.out.println("aaa");
        }
        synchronized (obj){
            System.out.println("aaa");
        }


    }
    //synchronized关键字“给某个实例对象加锁”，示例代码：
    public synchronized void method2(){
        System.out.println("bbb");
    }

    public synchronized static void method3(){
        System.out.println("ccc");

    }


    public static void method4(){
        synchronized (SynchornizedDemo.class){
            System.out.println("ddd");
            String[] array = new String[]{"aaa","bbb","ccc"};
            List<String> stringList = Arrays.asList(array);

        }

    }


}

package com.concurrent.demo1;

/**
 * @author lane
 * @date 2021年05月19日 下午3:22
 */
public class MainTest {


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+" 正在运行");
        System.out.println(Thread.currentThread().getId()+" id");
        System.out.println(Thread.currentThread().getState()+" state");
        new ThreadDemo().start();
        new Thread(new RunnableDemo()).start();





    }
}

package com.concurrent.demo8;

import java.util.concurrent.CountDownLatch;

/**
 * @author lane
 * @date 2021年05月22日 上午11:56
 */
public class CountdownlatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //线程计数--类
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开了");
                //开始计数--
                countDownLatch.countDown();
            }).start();
        }
        //等到减少到0以后main线程再继续执行下去
        countDownLatch.await();
        System.out.println("可以关门了");
        System.out.println("该睡觉了");



    }
    
    
}

package com.concurrent.demo8;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 限流，停车位有限
 * @author lane
 * @date 2021年05月25日 下午5:05
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //指定线程的个数3，停车位
        Semaphore semaphore = new Semaphore(3);
        //进来了10辆车，3个停车位
        for (int i = 0; i <10  ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"占用了一个停车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开了一个停车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },"车辆编号："+i).start();
        }

    }




}

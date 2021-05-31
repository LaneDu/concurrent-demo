package com.concurrent.demo23deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author lane
 * @date 2021年05月31日 上午12:38
 */
public class DeadLockDemo {

    public static String lockA ="A" ;
    public static String lockB= "B" ;


    public static void main(String[] args) {


        new Thread(()->{
        synchronized (lockA){

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"lockA" +lockA+"lockB"+lockB);
            }


        }
        },"T1").start();

        new Thread(()->{
            synchronized (lockB) {
                synchronized (lockA){
                System.out.println(Thread.currentThread().getName() + "lockA" + lockA + "lockB" + lockB);
            }
            }
        },"T2").start();


    }



}

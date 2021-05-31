package com.concurrent.demo11;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * @author lane
 * @date 2021年05月26日 下午2:01
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        //创建同步队列
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        //生产数据
        new Thread(()->{
            try {
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName()+"添加了数据a");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName()+"添加了数据b");
                synchronousQueue.put("c");
                System.out.println(Thread.currentThread().getName()+"添加了数据c");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        //消费数据
        new Thread(()->{
            try {

                System.out.println(Thread.currentThread().getName()+"取出了数据："+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"取出了数据："+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"取出了数据："+synchronousQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();




    }


}

package com.concurrent.demo12Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类 三大方法 Executors不推荐
 * 线程池自定义创建
 * @author lane
 * @date 2021年05月26日 下午2:46
 */
public class ThreadPoolExecutorsDemo {

    public static void main(String[] args) {
        //创建单一线程
        ExecutorService threadPoolSingle = Executors.newSingleThreadExecutor();
        //创建固定线程个数
        ExecutorService threadPoolFix = Executors.newFixedThreadPool(5);
        //创建弹性线程个数最大21亿
        ExecutorService threadPoolCache = Executors.newCachedThreadPool();

        try {
           /* for (int i = 0; i <10 ; i++) {
                threadPoolSingle.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行了");
                });
            }*/

           /* for (int i = 0; i <10 ; i++) {
                threadPoolFix.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行了");
                });
            }*/

            for (int i = 0; i <10 ; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                threadPoolCache.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行了");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPoolSingle.shutdown();
            threadPoolFix.shutdown();
            threadPoolCache.shutdown();
        }

    }





}

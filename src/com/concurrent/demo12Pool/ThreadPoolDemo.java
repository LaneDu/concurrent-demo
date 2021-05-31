package com.concurrent.demo12Pool;

import java.util.concurrent.*;

/**
 * 线程池自定义创建
 * @author lane
 * @date 2021年05月26日 下午2:59
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu可以并行个数："+cpuNum);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                10,
                3,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(7),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        /**
         * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异常
         * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
         * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
         * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会抛出异常！
         */
        //默认的拒绝策略
     // private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();

        try {
            for (int i = 0; i <10 ; i++) {
                //参数是runnable对象
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"执行了");

                        }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           threadPoolExecutor.shutdown();
        }


    }




}



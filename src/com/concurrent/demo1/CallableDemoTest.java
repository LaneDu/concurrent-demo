package com.concurrent.demo1;

import java.util.concurrent.*;

/**
 * @author lane
 * @date 2021年05月19日 下午4:22
 */
public class CallableDemoTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
     //测试1
      /*  CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> futureTask =new FutureTask<>(callableDemo);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());*/

      //测试2
        ThreadPoolExecutor threadPoolExecutor =new ThreadPoolExecutor(
                5,5,1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

        Future<String> future =threadPoolExecutor.submit(new CallableDemo());
        System.out.println(future.get());
        threadPoolExecutor.shutdown();


    }
}

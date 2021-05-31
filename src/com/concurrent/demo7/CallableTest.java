package com.concurrent.demo7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lane
 * @date 2021年05月22日 上午11:39
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //1. 同样是通过thread.start()方法启动线程
        //2. thread构造只有runnbale
        //3. runnable接口有一个实现类futureTask可以传入参数为callable;
        //4. callable类似与runnable接口不过有返回值和缓存，可能会阻塞

        CallableThread callableThread = new CallableThread();
        //适配器
        FutureTask futureTask = new FutureTask(callableThread);
        Runnable runnable = futureTask;
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread2.start();
        //这个get 方法可能会产生阻塞！把他放到最后
        Object ret = futureTask.get();
        System.out.println(ret);

    }



}

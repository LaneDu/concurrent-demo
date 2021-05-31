package com.concurrent.demo1;

/**
 * @author lane
 * @date 2021年05月19日 下午3:24
 */
public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable线程运行" +Thread.currentThread().getName());
    }
}

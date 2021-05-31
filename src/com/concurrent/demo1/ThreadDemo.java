package com.concurrent.demo1;

/**
 * @author lane
 * @date 2021年05月19日 下午3:21
 */
public class ThreadDemo extends  Thread {

    @Override
    public void run() {
        System.out.println("thread线程开始运行:"+Thread.currentThread().getName());
    }
}

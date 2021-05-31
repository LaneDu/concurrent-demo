package com.concurrent.demo7;

import java.util.concurrent.Callable;

/**
 * @author lane
 * @date 2021年05月22日 上午11:39
 */
public class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName()+"callbale接口的call方法执行了。。。");

        return "call的返回值";
    }
}

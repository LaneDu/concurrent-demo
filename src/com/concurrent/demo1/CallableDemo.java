package com.concurrent.demo1;

import java.util.concurrent.Callable;

/**
 * @author lane
 * @date 2021年05月19日 下午4:20
 */
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call 方法执行");
        return "返回String";
    }
}

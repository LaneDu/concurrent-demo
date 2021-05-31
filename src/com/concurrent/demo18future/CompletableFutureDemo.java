package com.concurrent.demo18future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture
 * @author lane
 * @date 2021年05月28日 下午4:10
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test1();
        System.out.println("===========test2=================");
        test2();
    }



    //无返回值类型异步
    public static void test1() throws ExecutionException, InterruptedException {


        CompletableFuture<Void> completableFuture =  CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"异步方法执行完成了");
        });

        System.out.println("main方法一直执行");
        // 获取阻塞执行结果
        Void aVoid = completableFuture.get();
        System.out.println(aVoid);


    }
    //有返回值的执行
    private static void test2() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{

            System.out.println(Thread.currentThread().getName()+"执行有返回值的");
            //int i =1/0;
            return 1024;

        });

        Integer integer = completableFuture.whenComplete((t, u) -> {
            System.out.println("t:" + t);// 正常的返回结果
            System.out.println("u:" + u);//异常信息
            //u:java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 400;
        }).get();


        System.out.println("执行异步回调返回的结果是："+integer);
    }



}

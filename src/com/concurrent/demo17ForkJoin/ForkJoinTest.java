package com.concurrent.demo17ForkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.FutureTask;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

/**
 * 测试下不同方式求和sum = 1+2+..20个小目标 的执行时间
 * @author lane
 * @date 2021年05月27日 下午3:25
 */
public class ForkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //基本单线程求和
        test1(); //sum:2000000001000000000基本求和方式花费时间：797
        //多线程求和
        test2();//sum:2000000001000000000两个线程方式花费时间：461
        test2_4(); //sum:2000000001000000000四个线程方式花费时间：358
        //forkjoin递归求和
        test3(); //sum:2000000001000000000forkjoin求和方式花费时间：640
        //stream求和
        test4();//sum:2000000001000000000stream流求和方式花费时间：462

    }
    //基本的求和方式
    public static void test1(){
        long currentTimeMillis1 = System.currentTimeMillis();
        long sum =0l;
        for (long i = 0l; i <=20_0000_0000l ; i++) {
            sum+=i;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("sum:"+sum +"基本求和方式花费时间："+(currentTimeMillis2-currentTimeMillis1));


    }
    /**
     * 有一种方式是放在数组里使用runnable
     * 这是用的callable
     * int fromInt = max * i / threads + 1; // 边界条件
     * int toInt =  max * (i + 1) / threads; // 边界条件
     * 循环创建线程
     * @author lane
     * @date 2021/5/27 下午6:02
     */
    //多线程2个线程的求和方式，为了省事就没正式写
    public static void test2() throws ExecutionException, InterruptedException {
        long currentTimeMillis1 = System.currentTimeMillis();

        FutureTask<Long> runnable1 = new FutureTask<Long>(()->{
            long sum11 =0l;
            for (long j = 0; j <10_0000_0000l ; j++) {
                sum11 += j;}
            return sum11;
        });
        FutureTask<Long> runnable2 = new FutureTask<Long>(()->{
            long sum11 =0l;
            for (long j = 10_0000_0000l; j <=20_0000_0000l ; j++) {
                sum11 += j;}
            return sum11;
        });

        new Thread(runnable1).start();
        new Thread(runnable2).start();

        Long sum1 = runnable1.get();
        Long sum2 = runnable2.get();

        long sum = sum1+sum2;
        long currentTimeMillis2 = System.currentTimeMillis();

        System.out.println("sum:"+sum+"两个线程方式花费时间："+(currentTimeMillis2-currentTimeMillis1));


    }
    //多线程4个线程的求和方式，总感觉不对
    public static void test2_4() throws ExecutionException, InterruptedException {
        long currentTimeMillis1 = System.currentTimeMillis();

        FutureTask<Long> runnable1 = new FutureTask<Long>(()->{
            long sum11 =0l;
            for (long j = 0; j <5_0000_0000l ; j++) {
                sum11 += j;}
            return sum11;
        });
        FutureTask<Long> runnable2 = new FutureTask<Long>(()->{
            long sum11 =0l;
            for (long j = 5_0000_0000l; j <10_0000_0000l ; j++) {
                sum11 += j;}
            return sum11;
        });
        FutureTask<Long> runnable3 = new FutureTask<Long>(()->{
            long sum11 =0l;
            for (long j = 10_0000_0000l; j <15_0000_0000l ; j++) {
                sum11 += j;}
            return sum11;
        });
        FutureTask<Long> runnable4 = new FutureTask<Long>(()->{
            long sum11 =0l;
            for (long j = 15_0000_0000l; j <=20_0000_0000l ; j++) {
                sum11 += j;}
            return sum11;
        });
        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();
        new Thread(runnable4).start();

        Long sum1 = runnable1.get();
        Long sum2 = runnable2.get();
        Long sum3 = runnable3.get();
        Long sum4 = runnable4.get();
        long sum = sum1+sum2+sum3+sum4;
        long currentTimeMillis2 = System.currentTimeMillis();

        System.out.println("sum:"+sum+"四个线程方式花费时间："+(currentTimeMillis2-currentTimeMillis1));


    }


    //forkjoin求和方式
    public static void test3() throws ExecutionException, InterruptedException {
        long currentTimeMillis1 = System.currentTimeMillis();
        //通过forkjoinpool执行任务
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //创建任务
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0l,20_0000_0000l);
        //提交任务
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        //获取返回结果
        Long sum = submit.get();
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("sum:"+sum +"forkjoin求和方式花费时间："+(currentTimeMillis2-currentTimeMillis1));

    }
    //stream流求和方式
    public static void test4(){
        long currentTimeMillis1 = System.currentTimeMillis();
        //Stream流式求和（]
        long reduce = LongStream.rangeClosed(0l, 20_0000_0000l).parallel().reduce(0, Long::sum);
        long currentTimeMillis2 = System.currentTimeMillis();
        System.out.println("sum:"+reduce +"stream流求和方式花费时间："+(currentTimeMillis2-currentTimeMillis1));


    }

}

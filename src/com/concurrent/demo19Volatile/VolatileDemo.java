package com.concurrent.demo19Volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile保证了可见性
 * volatile不能保证原子性
 * 可以保证原子性的有
 * 1. synchronized
 * 2. lock
 * 3. atomic类的自增
 * @author lane
 * @date 2021年05月28日 下午6:42
 */
public class VolatileDemo {

    private static volatile   boolean  flag = false;
    private static int num = 0;
    private static volatile int volatileNum = 0;

    private static Lock lock = new ReentrantLock();
    private static AtomicInteger atomicIntegerNum = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        //volatile 保证了可见性
//        test1();
        //测试原子性
        testAtomic();
    }

    public static void test1() throws InterruptedException {
        int num = 1;
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"子线程开始执行");
            while (!flag){
                //一直等待
            }
        }).start();
        //执行一系列操作
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main执行修改flag的值");
        //可以退出循环了
        flag = true;
        System.out.println("main修改后flag的值为"+flag);
    }

    //测试原子性
    public  static void testAtomic(){
        //10个线程，每个加1000 ，想要的是10000
        for (int i = 0; i < 10; i++) {

            new Thread(()->{

                for (int j = 0; j <1000 ; j++) {
                    //1. synchronized方式
                  /*  synchronized (VolatileDemo.class){
                    num++;
                    volatileNum++;
                  }*/
                  //2.lock方式实现
                  /*  lock.lock();
                    try {
                        num++;
                        volatileNum++;
                    } finally {
                        lock.unlock();
                    }*/
                    //加1递增
                    num++;
                    volatileNum++;
                    atomicIntegerNum.getAndIncrement();
                }

            }).start();
        }
        //测试了几次发现结果都不对
        //原来是忘了加这个了，必须保证子线程执行完之后再看结果才行
        //默认有两个线程分别是main和gc
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("num的值为："+num);
        System.out.println("volatileNum的值为："+volatileNum);
        System.out.println("atomicIntegerNum的值为："+atomicIntegerNum);
    }





}

package com.concurrent.demo20Single;

/**
 * 饿汉式
 * 为了线程安全需要加volatile和synchronized
 * @author lane
 * @date 2021年05月29日 下午10:53
 */
public class LazyDemo {

    private static volatile LazyDemo lazyDemo ;
    private static int num = 0;
    private LazyDemo(){

        if(lazyDemo!=null){
            throw new RuntimeException("懒汉式防御第一手");
        }

        if (num==0){
            num =1;
        }else {
            throw new RuntimeException("懒汉式防御第二手");

        }

    }

    /**
     *  lazyDemo = new LazyDemo();非原子性操作
     * 1. 分配内存空间
     * 2、执行构造方法，初始化对象
     * 3、把这个对象指向这个空间
     *
     * 123 单线程正常 123执行
     * 132 指令重排 变成 132 执行
     * 多线程 A 指令重排执行到13的时候 ，多线程B进入第一个判断发现已经分配空间
     * 开始执行return 并继续操作，实际对象并没有初始化，出现问题
     * 所以需要加上volatile关键字来避免指令重排
     * DCL懒汉式 就是双重加锁检测
     */
    public static  LazyDemo getInstance(){

        if (lazyDemo==null){
        synchronized (LazyDemo.class) {
            if (lazyDemo ==null){
              //  不是一个原子性操作
            lazyDemo = new LazyDemo();}
        }
        }
        return  lazyDemo;

    }

}

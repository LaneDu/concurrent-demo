package com.concurrent.demo22cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lane
 * @date 2021年05月30日 下午10:21
 */
public class CASDemo {
    //设置初始值
    public static AtomicInteger atomicInteger= new AtomicInteger(2021);
    public static void main(String[] args) {
        //参数为期望值，如果期望值和原先的值一样那么就执行set设置新值
        boolean b = atomicInteger.compareAndSet(2021, 2022);
        int i = atomicInteger.get();
        System.out.println("设置之后的值是："+i+" 设置是否成功"+b);
        boolean b2 = atomicInteger.compareAndSet(2021, 2022);
        int i2 = atomicInteger.get();
        System.out.println("设置之后的值是："+i2+" 设置是否成功"+b2);


    }

}

package com.concurrent.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 精确唤醒
 * @author lane
 * @date 2021年05月21日 下午3:53
 */
public class BusinessCondition {

private Lock lock = new ReentrantLock();
    private int number =1;
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    List<String> list = new ArrayList<String>();

    public void printA() throws InterruptedException {
        lock.lock();
        while (number!=1){
            condition1.await();
        }
        number=2;
        System.out.println(Thread.currentThread().getName()+"aaaaaa");
        //先唤醒
        condition2.signal();
        //最后才释放锁
        lock.unlock();
    }

    public void printB() throws InterruptedException {
        lock.lock();
       while (number!=2){

            condition2.await();
        }
        number=3;
        System.out.println(Thread.currentThread().getName()+"bbbbbb");

        condition3.signal();
        lock.unlock();
    }
    public void printC() throws InterruptedException {
        lock.lock();
        while (number!=3) {

            condition3.await();
        }
        number=1;
        System.out.println(Thread.currentThread().getName()+"cccccc");

        condition1.signal();
        lock.unlock();
    }


}

package com.concurrent.demo5;

import java.time.Clock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单一的生产者消费者不会有问题
 * 多个生产者和消费者就会出现问题
 * @author lane
 * @date 2021年05月21日 下午2:28
 */
public class BusinessLock {

    private int number =0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public BusinessLock(int number) {
        this.number = number;
    }
    //1. 注意必须加sync才可以使用wait和notify
    //2. 不能使用if，if醒来之后不会判断，while会判断
    public   void produce(){
        lock.lock();
        while (number!=0){

            System.out.println(Thread.currentThread().getName()+"number为"+number );
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
        number++;
        condition.signalAll();

    }
    public   void consume(){
        lock.lock();
        while (number==0){

            System.out.println(Thread.currentThread().getName()+"number为"+number );
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        number--;
        condition.signalAll();

    }
}

package com.concurrent.demo9;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁（写锁）只能被一个线程占有
 * 共享锁（读锁）可以被多个线程共有
 * 读-读 可以同时多个线程、
 * 读-写 只能同时存在一个线程
 * 写-写 只能同时一个线程存在
 * @author lane
 * @date 2021年05月26日 上午10:45
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();


        //5个线程同时写入缓存

        for (int i = 0; i <5 ; i++) {
            final int temp =  i;
            new Thread(()->{
            myCache.set(String.valueOf(temp),Thread.currentThread().getName());
            }).start();
        }

        //5个线程同时读取缓存

        for (int i = 0; i <5 ; i++) {
            final int temp =  i;
            new Thread(()->{
                myCache.get(String.valueOf(temp));
            }).start();
        }


    }



}
//自定义缓存
class MyCache{

    private volatile   Map<String,Object> map = new HashMap<>();
    //读写锁必须一致
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void set(String key,Object object){

        try {
            //加上写锁
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"开始写入key:"+key);
            map.put(key,object);
            System.out.println(Thread.currentThread().getName()+"写入key:"+key+"完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放写锁
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){

        try {
            //添加读锁
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"开始读取key:"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取key:"+key+"完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放读锁
            readWriteLock.readLock().unlock();
        }

    }


}
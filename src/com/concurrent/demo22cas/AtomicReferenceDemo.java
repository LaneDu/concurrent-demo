package com.concurrent.demo22cas;

import com.concurrent.demo16.Human;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author lane
 * @date 2021年05月30日 下午11:34
 */
public class AtomicReferenceDemo {
    //AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题
    //初始化一个原子引用类，参数为初始期望值和版本号
    //因为范型是Integer ,值不能超过128不然就不是从缓存中取会出错
    public static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);

    //修改值为110
    public static void main(String[] args) {
        //线程A修改100->110
        new Thread(()->{
            //获取版本号
            int stamp = atomicStampedReference.getStamp();
            try {

                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //参数分别为期望值、更新值、版本号、新的版本号
            boolean b = atomicStampedReference.compareAndSet(100, 110, stamp, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"修改"+b+"版本号为"+atomicStampedReference.getStamp());
        },"A").start();
        //线程B修改100->110->100
        new Thread(()->{
            //获取版本号
            int stamp = atomicStampedReference.getStamp();
            //参数分别为期望值、更新值、版本号、新的版本号
            boolean b1 = atomicStampedReference.compareAndSet(100, 120,  atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"修改"+b1+"版本号为"+atomicStampedReference.getStamp());
            boolean b2 = atomicStampedReference.compareAndSet(120, 100,  atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"修改"+b2+"版本号为"+atomicStampedReference.getStamp());
        },"B").start();

    }

}

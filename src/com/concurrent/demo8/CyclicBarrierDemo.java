package com.concurrent.demo8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lane
 * @date 2021年05月22日 下午12:12
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            //await线程数量到达之后之后会执行方法
            System.out.println("召唤神龙成功！");

        });
        for (int i = 0; i < 7; i++) {

            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"成功集齐一颗龙珠编号为"+ finalI);
                try {
                    //每一个线程都会等待在这，知道达到7个之后再继续下去
                    cyclicBarrier.await();
                  //  System.out.println("abcd");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();


        }

    }


}

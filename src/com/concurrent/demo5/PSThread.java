package com.concurrent.demo5;

import java.sql.DataTruncation;

/**
 * 实现+1 -1操作
 * @author lane
 * @date 2021年05月21日 下午2:28
 */
public class PSThread {


    public static void main(String[] args) {
        Business business = new Business(0);
        business.produce();
        Thread threadA= new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                business.produce();
            }

        },"A");
        Thread threadAA= new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                business.produce();
            }

        },"AA");

        Thread threadB = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                business.consume();
            }

        },"B");
        Thread threadBB = new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                business.consume();
            }

        },"BB");

        threadA.start();
        threadB.start();
        threadAA.start();
        threadBB.start();


    }







}



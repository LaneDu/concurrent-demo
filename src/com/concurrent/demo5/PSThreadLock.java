package com.concurrent.demo5;

/**
 * @author lane
 * @date 2021年05月21日 下午2:28
 */
public class PSThreadLock {


    public static void main(String[] args) {
        BusinessLock business = new BusinessLock(0);

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



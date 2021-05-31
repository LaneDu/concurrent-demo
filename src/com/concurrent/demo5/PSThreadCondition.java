package com.concurrent.demo5;

/**
 * 顺序执行ABC
 * @author lane
 * @date 2021年05月21日 下午3:59
 */
public class PSThreadCondition {

    public static void main(String[] args) {
        BusinessCondition businessCondition = new BusinessCondition();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    businessCondition.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    businessCondition.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    businessCondition.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


    }




}
